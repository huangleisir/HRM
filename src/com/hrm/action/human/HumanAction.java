package com.hrm.action.human;

import java.io.File;
import java.text.ParseException;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.hrm.Dao.QueryResult;
import com.hrm.action.human.aop.Permission;
import com.hrm.pojo.TblHuman;
import com.hrm.pojo.TblUser;
import com.hrm.service.HumanServer;
import com.hrm.utils.HumanIdFactory;
import com.hrm.utils.PageHelper;
import com.hrm.utils.StringToTimeStamp;
import com.mchange.v2.beans.BeansUtils;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

@Controller("HumanAction")
@Scope("prototype")
public class HumanAction extends ActionSupport implements ModelDriven<TblHuman> {
	private TblHuman tblHuman = new TblHuman(); // modelDriven记录页面数据
	private List<TblHuman> humanList;// 数据列表
	//@Autowired  果然是这里的问题，加上注解就会报错 他不属于action，service,dao中的某一层
	private File humanPictureFile;
	private String uploadType;
	private String uploadName;
    private TblUser user; 
    private String type;
    PageHelper page=new PageHelper(1, 5);
    //公共属性Map集合
    private Map<String,List<String>> publicAttMap;
    
    
	public Map<String, List<String>> getPublicAttMap() {
		return publicAttMap;
	}

	public void setPublicAttMap(Map<String, List<String>> publicAttMap) {
		this.publicAttMap = publicAttMap;
	}

	public TblUser getUser() {
		return user;
	}

	public void setUser(TblUser user) {
		this.user = user;
	}

	public List<TblHuman> getHumanList() {
		return humanList;
	}

	public void setHumanList(List<TblHuman> humanList) {
		this.humanList = humanList;
	}

	@Resource(name = "HumanServerImpl")
	private HumanServer humanServer; // 注入业务对象

	/* 保存 */
	@Permission(nameInclude = "admin")
	public String doSave() {
		tblHuman.setCheckStatus(0); 
		tblHuman.setHumanId(HumanIdFactory.getHumanId());
		if(humanPictureFile!=null){
		tblHuman.setHumanPicture(humanServer.saveImage(humanPictureFile,tblHuman.getHumanId()+uploadName));
		}
		try {
			if(tblHuman.getHumanBirthday()!=null)
			tblHuman.setHumanBirthday( StringToTimeStamp.parse(tblHuman.getHumanBirthday()));
			if(tblHuman.getRegistTime()!=null)
			tblHuman.setRegistTime( StringToTimeStamp.parse(tblHuman.getRegistTime()));
		} catch (ParseException e) { 
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		humanServer.doSave(tblHuman);
		return SUCCESS;
	}

	/* 根据id填充修改页面 */
	@Permission(nameInclude = "admin")
	public String doFill() {
		tblHuman = humanServer.findHuamn(tblHuman.getHufId());
		System.out.println(tblHuman.getHufId());
		return SUCCESS;
	}

	/* 更新 */
	@Permission(nameInclude = "admin")
	public String doUpdate() {
		humanServer.doUpdate(tblHuman);
		return SUCCESS;
	}

	/* 获取所有数据列表 */
	@Permission(nameInclude = "admin")
	public String doShow() {
		QueryResult<TblHuman> qr = humanServer.finAll();
		humanList = qr.getResultlist();
		return SUCCESS;
	}
	
	/*查找待复核的列表*/
	@Permission(nameInclude = "admin")
	public String findCheckList(){
		filterWhere();
		QueryResult<TblHuman> qr = humanServer.queryNeesCheckKind(page.getBeginIndex(), page.getPageSize(), tblHuman.getFirstKindId(), tblHuman.getSecondKindId()); 
		page.setTotal((int)qr.getTotalrecord());
		humanList = qr.getResultlist();
		return SUCCESS;
	}
	public void filterWhere(){
		if(tblHuman==null) return;
		if(tblHuman.getFirstKindId()!=null &&tblHuman.getFirstKindId().trim().equals("null")) tblHuman.setFirstKindId(null);
		if(tblHuman.getSecondKindId()!=null &&tblHuman.getSecondKindId().trim().equals("null")) tblHuman.setSecondKindId(null);

	}

	/* 获取分页数据列表 */
	@Permission(nameInclude = "admin")
	public String findPage() {
		QueryResult<TblHuman> qr = humanServer.findPage(1,10);
		humanList = qr.getResultlist();
		return SUCCESS;
	}
	
	/*通过审核*/
	@Permission(nameInclude = "admin")
	public String checkSuccess(){
		System.out.println("审核通过"); 
		tblHuman.setCheckStatus(1);
		humanServer.doUpdate(tblHuman);
		return SUCCESS;
	}

	/* modelDrive方式获得页面数据 */
	@Override
	public TblHuman getModel() {
		return tblHuman;
	}
	@Permission(nameInclude = "admin")
	public String doDelete(){
		humanServer.doDelete(tblHuman.getHufId());
		return SUCCESS;
	}
	
	/**
	 * 永久删除
	 * @return
	 */
	@Permission(nameInclude="superadmin")
	public String doDeleteForever(){
		humanServer.doDeleteForever(tblHuman.getHufId());
		return SUCCESS;
	}
	
	public String doReDelete(){
		humanServer.doReDelete(tblHuman.getHufId());
		return SUCCESS;
	}
	private void clearModel(){
		tblHuman=new TblHuman();
	}
	/*获取可以修改的数据列表*/
	@Permission(nameInclude = "admin")
	public String findUpdateList(){
		filterWhere();
		QueryResult<TblHuman> queryResult=humanServer.findCanupdateHuman(page.getBeginIndex(), page.getPageSize(), tblHuman.getFirstKindId(), tblHuman.getSecondKindId());
		this.humanList = queryResult.getResultlist();
		page.setTotal((int)queryResult.getTotalrecord());
		return SUCCESS;
	}
	/*获得人资档案*/
	@Permission(nameInclude = "admin")
	public String findShowList(){
		filterWhere();
		QueryResult<TblHuman> queryResult=humanServer.findShowList(page.getBeginIndex(), page.getPageSize(), tblHuman.getFirstKindId(), tblHuman.getSecondKindId());
		this.humanList = queryResult.getResultlist();
		page.setTotal((int)queryResult.getTotalrecord());
		return SUCCESS;
	}
	
	/*获取可删除或可恢复的档案列表*/
	@Permission(nameInclude = "admin")
	public String findDeleteList(){
		filterWhere();
		QueryResult<TblHuman> queryResult=humanServer.findCanDeleteOrRedeleteHuman(page.getBeginIndex(), page.getPageSize(), tblHuman.getFirstKindId(), tblHuman.getSecondKindId());
		this.humanList = queryResult.getResultlist();
		page.setTotal((int)queryResult.getTotalrecord());
		return SUCCESS;
	}

	public File getHumanPictureFile() {
		return humanPictureFile;
	}

	public void setHumanPictureFile(File humanPictureFile) {
		this.humanPictureFile = humanPictureFile;
	}

	public void setHumanPictureFileContentType(String fileType) {
		this.uploadType = fileType.substring(fileType.indexOf("/")+1);
		System.out.println(uploadType); 
	}
	public void setHumanPictureFileFileName(String name){
		this.uploadName=name; 
	}

	public Integer getPageIndex() {
		return page.getPageIndex();
	}
 
	public void setPageIndex(Integer pageIndex) {
		page.setPageIndex(pageIndex);
	}

	public Integer getPageSize() {
		return page.getPageSize();
	}

	public void setPageSize(Integer pageSize) {
		this.page.setPageSize(pageSize) ;
	}
	public Integer getNextPageIndex(){
		return page.getNextPage();
	}
	public Integer getPrePageIndex(){
		return page.getPrePage();
	}
	public Integer getTotlePage(){
		return page.getTotalPage();
	}
	public Integer getTotle(){
		return page.getTotal();
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
}

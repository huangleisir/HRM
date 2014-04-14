package com.hrm.action.human;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.hrm.Dao.QueryResult;
import com.hrm.action.human.aop.Permission;
import com.hrm.pojo.TblHuman;
import com.hrm.pojo.TblUser;
import com.hrm.service.HumanServer;
import com.hrm.utils.HumanIdFactory;
import com.hrm.utils.StringToTimeStamp;
import com.hrm.vo.HumanCheckVo;
import com.hrm.vo.HumanUpdateVo;
import com.mchange.v2.beans.BeansUtils;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

@Controller("HumanCheckAction")
@Scope("prototype")
public class HumanCheckAction extends ActionSupport implements
		ModelDriven<HumanCheckVo> {
	private HumanCheckVo tblHumanVo = new HumanCheckVo(); // modelDriven记录页面数据
	private File humanPictureFile;
	private String uploadName;
	private String type="check";
	// 公共属性Map集合
	private Map<String, List<String>> publicAttMap;

	public Map<String, List<String>> getPublicAttMap() {
		return publicAttMap;
	}

	public void setPublicAttMap(Map<String, List<String>> publicAttMap) {
		this.publicAttMap = publicAttMap;
	}

	@Resource(name = "HumanServerImpl")
	private HumanServer humanServer; // 注入业务对象

	/* 通过审核 */
	@Permission(nameInclude = "admin")
	public String checkSuccess() {
		TblHuman tblHuman = humanServer.findHuamn(tblHumanVo.getHufId());
		copy(tblHuman, tblHumanVo);
		tblHuman.setCheckStatus(1);
		if(humanPictureFile!=null)
			tblHuman.setHumanPicture(humanServer.saveImage(humanPictureFile,tblHuman.getHumanId()+uploadName));
		try {
			if(tblHuman.getHumanBirthday()!=null)
				tblHuman.setHumanBirthday( StringToTimeStamp.parse(tblHumanVo.getHumanBirthday()));
			if(tblHuman.getCheckTime()!=null)
				tblHuman.setCheckTime( StringToTimeStamp.parse(tblHumanVo.getCheckTime()));
			if(tblHuman.getRegistTime()!=null)
				tblHuman.setRegistTime( StringToTimeStamp.parse(tblHuman.getRegistTime()));
			if(tblHuman.getChangeTime()!=null)
				tblHuman.setChangeTime(StringToTimeStamp.parse(tblHuman.getChangeTime()));
		} catch (ParseException e) { 
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		humanServer.doUpdate(tblHuman);
		return SUCCESS;
	}

	/* modelDrive方式获得页面数据 */
	@Override
	public HumanCheckVo getModel() {
		return tblHumanVo;
	}

	public File getHumanPictureFile() {
		return humanPictureFile;
	}

	public void setHumanPictureFile(File humanPictureFile) {
		this.humanPictureFile = humanPictureFile;
	}


	public void setHumanPictureFileFileName(String name) {
		this.uploadName = name;
	}

	private void copy(Object dest, Object orig) {
		try {
			BeanUtils.copyProperties(dest, orig);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
}

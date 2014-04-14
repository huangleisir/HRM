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
import com.hrm.vo.HumanUpdateVo;
import com.mchange.v2.beans.BeansUtils;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

@Controller("HumanUpdatekAction")
@Scope("prototype")
public class HumanUpdatekAction extends ActionSupport implements
		ModelDriven<HumanUpdateVo> {
	private HumanUpdateVo tblHumanVo = new HumanUpdateVo(); // modelDriven记录页面数据
	private File humanPictureFile;
	private String uploadName;
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

	/* 修改内容 */
	@Permission(nameInclude = "admin")
	public String updateSuccess() {
		TblHuman tblHuman = humanServer.findHuamn(tblHumanVo.getHufId());
		copy(tblHuman, tblHumanVo);
		tblHuman.setCheckStatus(0);// 修改后变回待审核
		if (humanPictureFile != null)
			tblHuman.setHumanPicture(humanServer.saveImage(humanPictureFile,
					tblHuman.getHumanId() + uploadName));
		try {
			if (tblHuman.getHumanBirthday() != null)
				tblHuman.setHumanBirthday(StringToTimeStamp.parse(tblHumanVo
						.getHumanBirthday()));
			if (tblHuman.getRegistTime() != null)
				tblHuman.setRegistTime(StringToTimeStamp.parse(tblHuman
						.getRegistTime()));
			if (tblHuman.getCheckTime() != null)
				tblHuman.setCheckTime(StringToTimeStamp.parse(tblHuman.getCheckTime()));
			if (tblHumanVo.getChangeTime() != null)
				tblHuman.setChangeTime(StringToTimeStamp.parse(tblHumanVo.getChangeTime()));
		} catch (ParseException e) { 
			e.printStackTrace();
		}
		humanServer.doUpdate(tblHuman);
		return SUCCESS;
	}

	/* modelDrive方式获得页面数据 */
	@Override
	public HumanUpdateVo getModel() {
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
}

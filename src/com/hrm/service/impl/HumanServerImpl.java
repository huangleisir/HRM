package com.hrm.service.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.io.IOUtils;
import org.apache.struts2.ServletActionContext;
import org.springframework.stereotype.Service;

import com.hrm.Dao.FirstClassDao;
import com.hrm.Dao.HumanDao;
import com.hrm.Dao.QueryResult;
import com.hrm.Dao.SecondClassDao;
import com.hrm.Dao.ThirdClassDao;
import com.hrm.pojo.TblFirstClass;
import com.hrm.pojo.TblHuman;
import com.hrm.pojo.TblMajorClassify;
import com.hrm.pojo.TblMajorName;
import com.hrm.pojo.TblSecondClass;
import com.hrm.pojo.TblStandardSalary;
import com.hrm.pojo.TblThirdClass;
import com.hrm.service.HumanServer;
import com.hrm.utils.StringToTimeStamp;

@Service("HumanServerImpl")
public class HumanServerImpl implements HumanServer {
	@Resource(name = "HumanDaoImpl")
	private HumanDao humanDao;
	@Resource(name = "FirstClassDaoImpl")
	private FirstClassDao firstClassDao;
	@Resource(name = "SecondClassDaoImpl")
	private SecondClassDao secondClassDao;
	@Resource(name = "ThirdClassDaoImpl")
	private ThirdClassDao thirdClassDao;

	@Override
	public void doSave(TblHuman tblHuman) {
		tblHuman.setHufId(getNextId());
		humanDao.save(tblHuman);
	}

	private Integer getNextId() {
		List<Object> list = humanDao.getDataByHql(
				"select max(hufId) from TblHuman", null);
		int nextId = 0;
		if (list.get(0) != null)
			nextId = (Integer) list.get(0);
		return nextId + 1;
	}

	@Override
	public TblHuman findHuamn(Integer hufId) {
		return humanDao.find(hufId);
	}

	@Override
	public void doUpdate(TblHuman tblHuman) {
		humanDao.update(tblHuman);

	}

	@Override
	public QueryResult<TblHuman> finAll() {
		return humanDao.getScrollData(-1, -1);
	}

	@Override
	public QueryResult<TblHuman> findPage(int begIndex, int maxCount) {
		return humanDao.getScrollData(begIndex, maxCount, "checkStatus = ? ",
				new Object[] { new Integer(0) });
	}

	@Override
	public void doDelete(Integer fuid) {
		TblHuman entity = humanDao.find(fuid);
		pageTime(entity);
		if (entity.getCheckStatus() == 0) {
			throw new RuntimeException("待审查的人力资料不能删除");
		}
		if (entity.getCheckStatus() == 2) {
			throw new RuntimeException("该资料已经处于删除状态");
		}
		entity.setCheckStatus(2);
		humanDao.update(entity);
	}

	@Override
	public void doReDelete(Integer fuid) {
		TblHuman entity = humanDao.find(fuid);
		pageTime(entity);
		if (entity.getCheckStatus() != 2) {
			throw new RuntimeException("不能恢复不在删除状态的数据");
		}
		entity.setCheckStatus(1);
		humanDao.update(entity);

	}

	@Override
	public QueryResult<TblHuman> queryNeesCheckKind(int b, int m,
			String firstKindId, String secondKindId) {
		/*
		 * StringBuilder whereBuilder = new StringBuilder(); List<Object> objs =
		 * new ArrayList<Object>();
		 * 
		 * whereBuilder.append("checkStatus = 0"); if (firstKindId != null &&
		 * firstKindId.trim() != null) {
		 * whereBuilder.append(" and firstKindId = ? "); objs.add(firstKindId);
		 * } if (secondKindId != null && secondKindId.trim() != null) {
		 * whereBuilder.append(" and secondKindId = ? ");
		 * objs.add(secondKindId); }
		 */
		Mssager msg = buildKind(firstKindId, secondKindId);
		msg.addWhere("checkStatus = 0", null);
		return humanDao.getScrollData(b, m, msg.getWhere(), msg.getPreporty());
	}

	@Override
	public QueryResult<TblHuman> queryByChecking(int b, int m) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public QueryResult<TblHuman> queryCanDeleteOrCanReDelete(int b, int m) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public QueryResult<TblHuman> findCanupdateHuman(int b, int m,
			String firstKindId, String secondKindId) {
		Mssager msg = buildKind(firstKindId, secondKindId);
		// msg.addWhere("checkStatus = 0", null);
		return humanDao.getScrollData(b, m, msg.getWhere(), msg.getPreporty());
	}

	@Override
	public QueryResult<TblHuman> findCanDeleteOrRedeleteHuman(int b, int m,
			String firstKindId, String secondKindId) {
		Mssager msg = buildKind(firstKindId, secondKindId);
		msg.addWhere("checkStatus in (1,2) ", null);
		return humanDao.getScrollData(b, m, msg.getWhere(), msg.getPreporty());
	}

	public Mssager buildKind(String firstKindId, String secondKindId) {
		Mssager msg = new Mssager();
		/*
		 * StringBuilder whereBuilder = new StringBuilder(); List<Object> objs =
		 * new ArrayList<Object>();
		 */
		if (firstKindId != null && firstKindId.trim() != null) {
			msg.addWhere("firstKindId = ?", firstKindId);
			/*
			 * whereBuilder.append(" and firstKindId = ? ");
			 * objs.add(firstKindId);
			 */
		}
		if (secondKindId != null && secondKindId.trim() != null) {
			msg.addWhere("secondKindId = ?", secondKindId);
			/*
			 * whereBuilder.append(" and secondKindId = ? ");
			 * objs.add(secondKindId);
			 */
		}
		/* msg.addWhere(whereBuilder.toString(),objs.toArray()); */
		return msg;
	}

	/**
	 * 用于传递 查询语句 和 参数
	 * 
	 * @author pengdaofa
	 * 
	 */
	private class Mssager {
		public StringBuilder whereBilder = new StringBuilder();
		public List objs = new ArrayList();

		public String getWhere() {
			return whereBilder.toString();
		}

		public Object[] getPreporty() {
			return objs.toArray();
		}

		public void addWhere(String where, Object... obj) {
			if (where != null && where.trim() != "") {
				if (whereBilder.toString().trim().length() == 0) {
					whereBilder.append(where);
				} else {
					whereBilder.append(" and " + where);
				}
				fillProperty(objs, obj);
			}
		}

		// 填充参数数组
		private void fillProperty(List list, Object[] objs) {
			if (objs == null)
				return;
			for (Object obj : objs) {
				list.add(obj);
			}
		}
	}

	@Override
	public List<TblFirstClass> getFirstClass() {
		return firstClassDao.getScrollData(-1, -1).getResultlist();

	}

	@Override
	public List<TblSecondClass> getSecondClassByFirstClass(int firstId) {
		return secondClassDao.getScrollData(-1, -1, "firstKindId = ?",
				new Object[] { firstId + "" }).getResultlist();
	}

	@Override
	public List<TblThirdClass> getThirdClasBySecondClass(int secondId) {
		return thirdClassDao.getScrollData(-1, -1, "secondKindId = ? ",
				new Object[] { secondId + "" }).getResultlist();
	}

	@Override
	public List<TblMajorClassify> getMajorClassifyAll() {
		List list = humanDao.getDataByHql("from TblMajorClassify", null);
		return list;
	}

	@Override
	public List<String> getPublicAttNameByType(String name) {
		List list = humanDao
				.getDataByHql(
						"select attributeName from TblPublicAttribute where attributeKind=?",
						new Object[] { name });
		return list;
	}

	@Override
	public List<TblStandardSalary> getTblStandardSalaryAll() {
		List list = humanDao.getDataByHql("from TblStandardSalary ", null);
		return list;
	}

	@Override
	public List<TblMajorName> getTblMajorNameByClassId(String clazz) {
		List list = humanDao
				.getDataByHql("from TblMajorName where majorKindId=?",
						new Object[] { clazz });
		return list;
	}

	@Override
	public String saveImage(File humanPictureFile, String nPathName) {
		String savePath = ServletActionContext.getServletContext().getRealPath(
				"/images")
				+ "/" + nPathName;
		FileOutputStream fos = null;
		FileInputStream fis = null;
		try {
			// 建立文件输出流
			System.out.println(savePath);
			fos = new FileOutputStream(savePath);
			// 建立文件上传流
			fis = new FileInputStream(humanPictureFile);
			byte[] buffer = new byte[1024];
			int len = 0;
			while ((len = fis.read(buffer)) > 0) {
				fos.write(buffer, 0, len);
			}
		} catch (Exception e) {
			System.out.println("文件上传失败");
			e.printStackTrace();
		} finally {

			try {
				if (fis != null)
					fis.close();
				if (fos != null)
					fos.close();

			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return "/images" + "/" + nPathName;
	}

	public static void main(String[] args) {
		String str = "index/jpeg";
		System.out.println(str.substring(str.indexOf("/") + 1));

	}

	@Override
	public QueryResult<TblHuman> findShowList(int beginIndex, Integer pageSize,
			String firstKindId, String secondKindId) {
		Mssager msg = buildKind(firstKindId, secondKindId);
		return humanDao.getScrollData(beginIndex, pageSize, msg.getWhere(),
				msg.getPreporty());

	}

	@Override
	public void doDeleteForever(Integer hufId) {
		TblHuman entity = humanDao.find(hufId);
		pageTime(entity);
		humanDao.delete(entity);
	}

	private void pageTime(TblHuman human) {
		
			try {
				if (human.getRegistTime() != null)
					human.setRegistTime(StringToTimeStamp.parse(human.getRegistTime()));
				if (human.getChangeTime() != null)
					human.setChangeTime(StringToTimeStamp.parse(human.getChangeTime()));
				if (human.getHumanBirthday() != null)
					human.setHumanBirthday(StringToTimeStamp.parse(human.getHumanBirthday()));
				if(human.getCheckTime()!=null)
					human.setCheckTime( StringToTimeStamp.parse(human.getCheckTime()));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

	}
}

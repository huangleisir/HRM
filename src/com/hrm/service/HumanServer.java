package com.hrm.service;

import java.io.File;
import java.util.List;

import com.hrm.Dao.QueryResult;
import com.hrm.pojo.TblFirstClass;
import com.hrm.pojo.TblHuman;
import com.hrm.pojo.TblMajorClassify;
import com.hrm.pojo.TblMajorName;
import com.hrm.pojo.TblSecondClass;
import com.hrm.pojo.TblStandardSalary;
import com.hrm.pojo.TblThirdClass;

public interface HumanServer {
    /*保存人力资源档案*/
	void doSave(TblHuman tblHuman);

	/*根据主键查找对象*/
	TblHuman findHuamn(Integer hufId);

	/*更新*/
	void doUpdate(TblHuman tblHuman);
    /*获取所有数据*/
	QueryResult<TblHuman> finAll();

	/**
	 * 
	 * @param begIndex 第几行开始
	 * @param maxCount 要拿多少条数据
	 * @return
	 */
	QueryResult<TblHuman> findPage(int begIndex, int maxCount);     
	
	/** 删除数据（非物理删除） */
	void doDelete(Integer fuid);
	
	/**
	 * 把删除的人员表恢复成正常状态
	 */
	void doReDelete(Integer fuid);
	/**
	 * 根据查询一二级机构查询需要复核的数据 
	 * @param b 记录开始
	 * @param m 最大返回数
	 * @param firstKindId 一级机构的id 传入空值或null忽略该条件
	 * @param secondKindId 二级机构的id 传入空值或null忽略该条件
	 * @return
	 */
	QueryResult<TblHuman> queryNeesCheckKind(int b,int m,String firstKindId,String secondKindId);
	
	/**
	 * 查询待复核状态的人资档案列表
	 * @param b 第几条开始返回
	 * @param m 最多返回多少条
	 * @return
	 */
	QueryResult<TblHuman> queryByChecking(int b,int m);
	
	/**
	 * 查询得到将删除（或恢复）的人资档案。
	 * @param b 第几条开始返回
	 * @param m 最多返回多少条
	 * @return
	 */
	QueryResult<TblHuman> queryCanDeleteOrCanReDelete(int b,int m);
	
	/**
	 * 返回能够修改的人力资源数据
	 * @param b 第几条开始返回
	 * @param m 最多返回多少条
	 * @param firstKindId 一级机构的id 传入空值或null忽略该条件
	 * @param secondKindId 二级机构的id 传入空值或null忽略该条件
	 * @return
	 */
	QueryResult<TblHuman> findCanupdateHuman(int b, int m, String firstKindId,
			String secondKindId); 
	
	/**
	 * 返回能够删除或恢复的人力资源数据
	 * @param b 第几条开始返回
	 * @param m 最多返回多少条
	 * @param firstKindId 一级机构的id 传入空值或null忽略该条件
	 * @param secondKindId 二级机构的id 传入空值或null忽略该条件
	 * @return
	 */
	QueryResult<TblHuman> findCanDeleteOrRedeleteHuman(int b, int m, String firstKindId,
			String secondKindId);
	/**
	 * 获得所有一级机构的记录
	 * @return
	 */
	List<TblFirstClass> getFirstClass(); 
	
	/**
	 * 根据一级机构id获得二级机构的记录
	 * @return
	 */
	List<TblSecondClass> getSecondClassByFirstClass(int firstId);
	
	/**
	 * 根据二级机构id获得三级机构的记录
	 * @return
	 */
	List<TblThirdClass> getThirdClasBySecondClass(int secondId);
	
	/**
	 * 获得所有职称
	 * @return
	 */
	List<TblMajorClassify> getMajorClassifyAll();
	
	/**
	 * 根据公共属性类型获得属性名集合
	 * @return
	 */
	List<String> getPublicAttNameByType(String name);

	/**
	 * 获得所有薪酬
	 * @return
	 */
	List<TblStandardSalary> getTblStandardSalaryAll();

	/**
	 * 根据职位类别id获取职位名称类
	 * @param clazz
	 * @return
	 */
	List<TblMajorName> getTblMajorNameByClassId(String clazz);

	/**
	 * 保存照片
	 * @param humanPictureFile
	 * @return 
	 */ 
	String saveImage(File humanPictureFile, String nPath);

	/**
	 * 分页获得所有类型
	 * @param beginIndex
	 * @param pageSize
	 * @param firstKindId
	 * @param secondKindId
	 * @return
	 */
	QueryResult<TblHuman> findShowList(int beginIndex, Integer pageSize,
			String firstKindId, String secondKindId);
    /**
     * 从数据库删除数据
     * @param hufId
     */
	void doDeleteForever(Integer hufId);
}

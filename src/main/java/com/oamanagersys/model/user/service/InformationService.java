package com.oamanagersys.model.user.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oamanagersys.model.user.dao.InformationDao;
import com.oamanagersys.model.user.entity.Information;
import com.oamanagersys.util.format.DateFormat;
/**
 * @author	李明
 * @tel		17310545652
 * @createtime	2017年6月30日 上午11:52:59
 */
@Service
public class InformationService {
	@Autowired
	private InformationDao inforDao;
	/**
	 * 添加员工基本信息
	 * @param infor
	 * @return
	 */
	public int insertInfor(Information infor){
		infor.setCreateTime(DateFormat.newDateString());
		int count = inforDao.insterInfor(infor);
		return count;
	}
	/**
	 * 查询员工基本信息
	 * @return
	 */
	public Information inforByEmpNo(int empNo){
		List<Information> list = inforDao.selectInforByEmpNo(empNo);
		if(list.size() > 0){
			return list.get(0);
		}
		return new Information();
	}
	/**
	 * 修改基本信息
	 * @param infor
	 * @return
	 */
	public int updateInfor(Information infor){
		infor.setLastUpdateTime(DateFormat.newDateString());
		return inforDao.updateInfor(infor);
	}
	
	
	
}

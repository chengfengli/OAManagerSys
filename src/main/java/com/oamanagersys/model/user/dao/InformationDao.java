package com.oamanagersys.model.user.dao;

import java.util.List;

import com.oamanagersys.model.user.entity.Information;

public interface InformationDao {
	public int insterInfor(Information infor);
	
	public List<Information> selectInforByEmpNo(int empNo);
	
	public int updateInfor(Information infor);
}

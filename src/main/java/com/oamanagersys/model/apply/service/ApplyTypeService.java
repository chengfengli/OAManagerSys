package com.oamanagersys.model.apply.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oamanagersys.model.apply.dao.ApplyTypeDao;
import com.oamanagersys.model.apply.entity.ApplyType;

/**
 * 申请类型你个service
 * @author	李明
 * @tel		17310545652
 * @createtime	2017年8月1日 下午3:03:53
 */
@Service
public class ApplyTypeService {
	@Autowired
	private ApplyTypeDao applyTypeDao;
	/**
	 * 获取申请类型
	 * @return
	 */
	public List<ApplyType> list(){
		List<ApplyType> list = applyTypeDao.select(new ApplyType());
		return list;
	}
}

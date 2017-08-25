package com.oamanagersys.model.apply.service;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oamanagersys.model.apply.dao.ApplyDao;
import com.oamanagersys.model.apply.entity.Apply;
import com.oamanagersys.util.format.DateFormat;
import com.oamanagersys.util.response.Message;

/**
 * 申请类型你个service
 * @author	李明
 * @tel		17310545652
 * @createtime	2017年8月1日 下午3:03:53
 */
@Service
public class ApplyService {
	Message message = new Message();
	@Autowired
	private ApplyDao applyDao;
	
	/**
	 * 申请
	 * @return
	 */
	public Message apply(Apply apply,HttpServletRequest request){
		
		int userId = (Integer) request.getSession().getAttribute("userId");
		apply.setCreateUser(userId);
		apply.setStatus("w");
		int count = applyDao.insert_apply(apply);
		if(count > 0){
			message.isSuccess = true;
			message.strMessage = "申请成功";
		}else{
			message.strMessage = "申请失败";
		}
		return message;
	}
	
	/**
	 * 获取外出数据
	 * @param apply
	 * @return
	 */
	public List<Apply> applylist(Apply apply){
		List<Apply> list = applyDao.select(apply);
		return list;
	}
	/**
	 * 审核
	 * @param id
	 * @param apply
	 * @return
	 */
	public Message update_appro(String id,Apply apply){
		apply.setApprovalTimne(DateFormat.nowDateTimeString());
		String[] ids = id.split(",");
		List<Apply> list =  new ArrayList<Apply>();
		for(int i=0;i<ids.length;i++){
			apply.setId(Integer.parseInt(ids[i]));
			list.add(apply);
		}
		int count = applyDao.update_appro(list);
		if(count > 0){
			message.isSuccess = true;
			message.strMessage = "审核成功";
		}else{
			message.strMessage = "审核失败";
		}
		return message;
	}
}

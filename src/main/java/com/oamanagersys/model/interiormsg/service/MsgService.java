package com.oamanagersys.model.interiormsg.service;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oamanagersys.model.interiormsg.dao.MsgDao;
import com.oamanagersys.model.interiormsg.entity.MsgEntity;
import com.oamanagersys.model.user.entity.Emp;
import com.oamanagersys.util.format.DateFormat;

/**
 * 内部短信 service
 * 创建人： 李明
 * 时    间：2017年3月30日
 * 联    系：17310545652
 */
@Service
public class MsgService {
	@Autowired
	private MsgDao msgDao;
	
	/**
	 * 发送
	 * @param msg
	 * @return
	 */
	public int sendMsg(MsgEntity msg,HttpServletRequest request){
		Emp emp = (Emp)request.getSession().getAttribute("user");
		msg.setCreateTime(DateFormat.newDateString());
		msg.setCreateUser(emp.getId());
		//设置类型为草稿
		msg.setBoxType(2);
		msg.setSendTime(DateFormat.newDateString());
		msg.setSendNo(emp.getId());
		
		List<MsgEntity> list = new ArrayList<MsgEntity>();
		list.add(msg);
		
		String acceptNo = msg.getAcceptNo();
		String acceptNos[] = acceptNo.split(";");
		String acceptName = msg.getAcceptName();
		String acceptNames[] = acceptName.split(";");
		for(int i=0;i<acceptNos.length;i++){
			MsgEntity m = new MsgEntity();
			m.setContent(msg.getContent());
			m.setSendTime(msg.getSendTime());
			m.setSendNo(emp.getId());
			m.setCreateUser(msg.getCreateUser());
			m.setCreateTime(msg.getCreateTime());
			m.setAcceptNo(acceptNos[i]);
			m.setAcceptName(acceptNames[i]);
			m.setBoxType(1);
			m.setReadStatus(0);
			list.add(m);
		}
		return msgDao.insert(list);
	}
	
	/**
	 * 草稿
	 * @param msg
	 * @return
	 */
	public int draftMsg(MsgEntity msg,HttpServletRequest request){
		Emp emp = (Emp)request.getSession().getAttribute("user");
		msg.setCreateTime(DateFormat.newDateString());
		msg.setCreateUser(emp.getId());
		//设置类型为草稿
		msg.setBoxType(0);
		List<MsgEntity> list = new ArrayList<MsgEntity>();
		list.add(msg);
		return msgDao.insert(list);
	}
}

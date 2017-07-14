package com.oamanagersys.model.interiormsg.service;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oamanagersys.model.interiormsg.dao.MsgDao;
import com.oamanagersys.model.interiormsg.entity.MsgEntity;
import com.oamanagersys.model.interiormsg.entity.SearchMsg;
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
		int id = msg.getId();
		int count = 0;
		if(id != 0){
			count = msgDao.update_msg(msg);
		}else{
			Emp emp = (Emp)request.getSession().getAttribute("user");
			msg.setCreateTime(DateFormat.newDateString());
			msg.setCreateUser(emp.getId());
			msg.setSendNo(emp.getId());
			//设置类型为草稿
			msg.setBoxType(0);
			List<MsgEntity> list = new ArrayList<MsgEntity>();
			list.add(msg);
			count = msgDao.insert(list);
		}
		return count;
	}
	/**
	 * 已发送的消息
	 * @param searchMsg
	 * @return
	 */
	public List<MsgEntity> select_sendlist(SearchMsg searchMsg,HttpServletRequest request){
		Emp emp = (Emp)request.getSession().getAttribute("user");
		searchMsg.setSendNo(emp.getId());
		return msgDao.select_sendlist(searchMsg);
	}
	
	/**
	 * 已接收的消息
	 * @param searchMsg
	 * @return
	 */
	public List<MsgEntity> select_acceptlist(SearchMsg searchMsg,HttpServletRequest request){
		Emp emp = (Emp)request.getSession().getAttribute("user");
		searchMsg.setAcceptNo(emp.getId()+"");
		return msgDao.select_acceptlist(searchMsg);
	}
	
	/**
	 * 草稿消息
	 * @param searchMsg
	 * @return
	 */
	public List<MsgEntity> select_draftlist(SearchMsg searchMsg,HttpServletRequest request){
		Emp emp = (Emp)request.getSession().getAttribute("user");
		searchMsg.setAcceptNo(emp.getId()+"");
		return msgDao.select_draftlist(searchMsg);
	}
	
	public MsgEntity selectById(int id){
		List<MsgEntity> list  = msgDao.selectById(id);
		if(list.size() > 0){
			return list.get(0);
		}
		return null;
	}
	/**
	 * 删除
	 * @param id
	 * @return
	 */
	public int delete(String id){
		String[] ids = id.split(",");
		return msgDao.delete(ids);
	}
	/**
	 * 标记已读
	 * @param id
	 * @return
	 */
	public int update_read(String id){
		String[] ids = id.split(",");
		return msgDao.update_read(ids);
	}
	
}

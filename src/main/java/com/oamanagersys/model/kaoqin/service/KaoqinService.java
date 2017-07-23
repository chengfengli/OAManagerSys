package com.oamanagersys.model.kaoqin.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oamanagersys.model.kaoqin.dao.KaoqinDao;
import com.oamanagersys.model.kaoqin.entity.Kaoqin;
import com.oamanagersys.model.kaoqin.entity.SearchKaoqin;
import com.oamanagersys.util.format.DateFormat;
import com.oamanagersys.util.response.Message;

/**
 * 
 * @author	李明
 * @tel		17310545652
 * @createtime	2017年5月4日 下午3:38:03
 */
@Service
public class KaoqinService {
	Message message = new Message();
	@Autowired
	private KaoqinDao kaoqinDao;
	
	/**
	 * 签到
	 * @param kaoqin
	 * @return
	 */
	public Message signIn(HttpServletRequest request){
		SearchKaoqin search = new SearchKaoqin();
		int empNo = (int)request.getSession().getAttribute("userId");
		search.setEmpNo(empNo);
		if(StringUtils.isBlank(search.getMonth())){
			search.setMonth(DateFormat.getYearAndMonth());
		}
		search.setDay(DateFormat.newDateString());
		List<Kaoqin> list = kaoqinDao.list(search);
		if(list.size() == 0){
			Kaoqin kaoqin = new Kaoqin();
			//规定上班时间
			long workStart = DateFormat.stringToDate(DateFormat.nowDateString()+" 09:00").getTime();
			kaoqin.setEmpNo(empNo);
			kaoqin.setDay(DateFormat.newDateString());
			kaoqin.setWeekDay(DateFormat.getWeekDay());
			kaoqin.setMonth(DateFormat.getYearAndMonth());
			kaoqin.setSignInTime(DateFormat.getTime());
			kaoqin.setStandardWorkTime(8);
			//实际上班时间
			long actualSignTime = DateFormat.stringToDate(DateFormat.nowDateString()+" "+DateFormat.getTime()).getTime();
			//时间差
			long compare = (actualSignTime - workStart)/1000/60;
			if(compare < 0){//正常
				kaoqin.setStatus("N");
			}else if(compare>0 && compare<30){
				kaoqin.setStatus("C");
				kaoqin.setLateTimeLong(0.5);
			}else if(compare>=30 && compare<60){
				kaoqin.setStatus("C");
				kaoqin.setLateTimeLong(1);
			}else if(compare>=1.5*60 && compare<1.5*60){
				kaoqin.setStatus("C");
				kaoqin.setLateTimeLong(1.5);
			}else if(compare>=1.5*60 && compare<2*60){
				kaoqin.setStatus("C");
				kaoqin.setLateTimeLong(2);
			}else{
				kaoqin.setStatus("K");
				kaoqin.setLateTimeLong(2.5);
			}
			int count = kaoqinDao.signIn(kaoqin);
			if(count > 0){
				message.isSuccess = true;
				message.strMessage = "签到成功";
			}else{
				message.isSuccess = false;
				message.strMessage = "签到失败";
			}
		}else{
			message.isSuccess = false;
			message.strMessage = "今天已签到";
		}
		return message;
	}
	
	public Message signOut(HttpServletRequest request){
		//规定下班时间
		long workEnd = DateFormat.stringToDate(DateFormat.nowDateString()+" 18:00").getTime();
		Kaoqin kaoqin = new Kaoqin();
		int empNo = (int)request.getSession().getAttribute("userId");
		kaoqin.setEmpNo(empNo);
		kaoqin.setDay(DateFormat.nowDateString());
		kaoqin.setSignOutTime(DateFormat.getTime());
		//实际下班时间
		long setSignOutTime = DateFormat.stringToDate(DateFormat.nowDateString()+" "+DateFormat.getTime()).getTime();
		//时间差
		long compare = (workEnd - setSignOutTime)/1000/60;
		if(compare < 0){
			kaoqin.setStatus("N");
			double over_time = (workEnd - setSignOutTime)/1000/60;
			double overTime = over_time/60;
			int overTimeI = (int)overTime;
			if((overTime-overTimeI)>=0.5){
				kaoqin.setOverTimeLong(overTimeI+0.5);
			}else{
				kaoqin.setOverTimeLong(overTimeI);
			}
		}else if(compare>0 && compare<30){
			kaoqin.setStatus("C");
			kaoqin.setLeaveEarlyTimeLong(0.5);
		}else if(compare>=30 && compare<60){
			kaoqin.setStatus("C");
			kaoqin.setLeaveEarlyTimeLong(1);
		}else if(compare>=1.5*60 && compare<1.5*60){
			kaoqin.setStatus("C");
			kaoqin.setLeaveEarlyTimeLong(1.5);
		}else if(compare>=1.5*60 && compare<2*60){
			kaoqin.setStatus("C");
			kaoqin.setLeaveEarlyTimeLong(2);
		}else{
			kaoqin.setStatus("K");
			kaoqin.setLeaveEarlyTimeLong(2.5);
		}
		int count = kaoqinDao.signOut(kaoqin);
		if(count>0){
			message.isSuccess = true;
			message.strMessage = "签退成功";
		}else{
			message.isSuccess = false;
			message.strMessage = "签退失败";
		}
		return message;
	}
	
	/**
	 * 获取考勤，默认是当月
	 * @param search
	 * @param request
	 * @return
	 */
	public List<Kaoqin> list(SearchKaoqin search,HttpServletRequest request){
		int empNo = (int)request.getSession().getAttribute("userId");
		search.setEmpNo(empNo);
		if(StringUtils.isBlank(search.getMonth())){
			search.setMonth(DateFormat.getYearAndMonth());
		}
		return kaoqinDao.list(search);
	}
}

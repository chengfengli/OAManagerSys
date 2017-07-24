package com.oamanagersys.model.kaoqin.service;

import java.util.Date;
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
	//规定上班时间
	double workStart = DateFormat.stringToDate(DateFormat.nowDateString()+" 09:00").getTime();
	//规定下班时间
	double workEnd = DateFormat.stringToDate(DateFormat.nowDateString()+" 18:00").getTime();
	//午休开始时间
	String restTimeStart = DateFormat.nowDateString()+" 12:00";
	double restTimeStartDate = (double)DateFormat.stringToDate(restTimeStart).getTime();
	//午休结束时间
	String restTimeEnd = DateFormat.nowDateString()+" 13:00";
	double restTimeEndDate = (double)DateFormat.stringToDate(restTimeEnd).getTime();
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
		search.setDay(DateFormat.nowDateString());
		List<Kaoqin> list = kaoqinDao.list(search);
		if(list.size() == 0){
			Kaoqin kaoqin = new Kaoqin();
			kaoqin.setEmpNo(empNo);
			kaoqin.setDay(DateFormat.newDateString());
			kaoqin.setWeekDay(DateFormat.getWeekDay());
			kaoqin.setMonth(DateFormat.getYearAndMonth());
			kaoqin.setSignInTime(DateFormat.getTime());
			kaoqin.setStandardWorkTime(8);
			//实际上班时间
			double actualSignTime = DateFormat.stringToDate(DateFormat.nowDateString()+" "+DateFormat.getTime()).getTime();
			//时间差
			double compare = 0;
			if(actualSignTime <= workStart){//正常
				kaoqin.setStatus("N");
			}else if(actualSignTime>workStart && actualSignTime < restTimeStartDate){//实际签到时间>规定签到时间 并且 实际签到时间<午休开始实际
				compare = (actualSignTime - workStart)/1000/60/60;
				int compareInt = (int)compare;
				if((compare-compareInt)!=0 && (compare-compareInt)<=0.5){
					kaoqin.setLateTimeLong(compareInt+0.5);
				}else if((compare-compareInt)!=0 && (compare-compareInt)>0.5){
					kaoqin.setLateTimeLong(compareInt+1);
				}else{
					kaoqin.setLateTimeLong(compareInt);
				}
			}else if(actualSignTime>restTimeStartDate && actualSignTime < restTimeEndDate){//实际签到时间>午休开始时间 并且 实际签到时间<午休结束时间
				compare = (restTimeStartDate - workStart)/1000/60/60;
				int compareInt = (int)compare;
				if((compare-compareInt)!=0 && (compare-compareInt)<=0.5){
					kaoqin.setLateTimeLong(compareInt+0.5);
				}else if((compare-compareInt)!=0 && (compare-compareInt)>0.5){
					kaoqin.setLateTimeLong(compareInt+1);
				}else{
					kaoqin.setLateTimeLong(compareInt);
				}
			}else if(actualSignTime>=restTimeEndDate){//实际签到时间>午休结束时间
				compare = (actualSignTime - workStart)/1000/60/60;
				int compareInt = (int)compare;
				if((compare-compareInt)!=0 && (compare-compareInt)<=0.5){
					kaoqin.setLateTimeLong(compareInt+0.5-1);
				}else if((compare-compareInt)!=0 && (compare-compareInt)>0.5){
					kaoqin.setLateTimeLong(compareInt);
				}else{
					kaoqin.setLateTimeLong(compareInt-1);
				}
			}
			
			//判断是迟到还是旷工
			if(compare>=4){
				kaoqin.setStatus("K");
			}else{
				kaoqin.setStatus("C");
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
	
	/**
	 * 签退
	 * @param request
	 * @return
	 */
	public Message signOut(HttpServletRequest request){
		SearchKaoqin search = new SearchKaoqin();
		int empNo = (int)request.getSession().getAttribute("userId");
		search.setEmpNo(empNo);
		search.setDay(DateFormat.nowDateString());
		//实际下班时间
		double setSignOutTime = DateFormat.stringToDate(DateFormat.nowDateString()+" "+DateFormat.getTime()).getTime();
		//签退时间
		String time = DateFormat.getTime();
		//当天已签到考勤
		Kaoqin kaoqin = getKaoqin(search);
		//时间差
		double compare = (workEnd - setSignOutTime)/1000/60;
		//实际工作时长
		double actualWorkTime = actualWorkTimeCount(kaoqin.getDay(),kaoqin.getSignInTime(),time);
		//新的考勤
		Kaoqin k = new Kaoqin();
		k.setId(kaoqin.getId());
		k.setEmpNo(kaoqin.getEmpNo());
		k.setDay(kaoqin.getDay());
		k.setWeekDay(kaoqin.getWeekDay());
		k.setMonth(kaoqin.getMonth());
		k.setSignInTime(kaoqin.getSignInTime());
		k.setSignOutTime(time);
		k.setStandardWorkTime(kaoqin.getStandardWorkTime());
		k.setActualWorkTime(actualWorkTime);
		if(compare < 0){//正常
			if(!"N".equals(kaoqin.getStatus())){
				k.setStatus(kaoqin.getStatus());
			}else{
				k.setStatus("N");
			}
			double over_time = (setSignOutTime - workEnd)/1000/60;
			double overTime = over_time/60;
			int overTimeI = (int)overTime;
			if((overTime-overTimeI)>=0.5){
				k.setOverTimeLong(overTimeI+0.5);
			}else{
				k.setOverTimeLong(overTimeI);
			}
		}else if(compare>=2*60){
			if("L".equals(kaoqin.getStatus())){
				k.setStatus("L");
			}else{
				k.setStatus("K");
			}
			k.setLeaveEarlyTimeLong(2.5);
			k.setActualWorkTime(0);
		}else{
			if("C".equals(kaoqin.getStatus())){
				k.setStatus(kaoqin.getStatus()+"Z");
			}else{
				k.setStatus(kaoqin.getStatus());
			}
			if(compare>0 && compare<30){
				k.setLeaveEarlyTimeLong(0.5);
			}else if(compare>=30 && compare<60){
				k.setLeaveEarlyTimeLong(1);
			}else if(compare>=1.5*60 && compare<1.5*60){
				k.setLeaveEarlyTimeLong(1.5);
			}else if(compare>=1.5*60 && compare<2*60){
				k.setLeaveEarlyTimeLong(2);
			}
		}
		int count = kaoqinDao.signOut(k);
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
	
	/**
	 * 某天的考勤
	 * @param search
	 * @return
	 */
	public Kaoqin getKaoqin(SearchKaoqin search){
		List<Kaoqin> list = kaoqinDao.list(search);
		if(list.size() > 0){
			return list.get(0);
		}else{
			return null;
		}
	}
	/**
	 * 计算实际工作时长
	 * @param day日期
	 * @param signInTime签到时间
	 * @param signOutTime签退时间
	 * @return
	 */
	@SuppressWarnings("deprecation")
	public double actualWorkTimeCount(String day,String signInTime,String signOutTime){
		String signInDateTimeStr = day+" "+signInTime;
		String singOutDateTimeStr = day+" "+signOutTime;
		Date signInDate = DateFormat.stringToDate(signInDateTimeStr);
		int signInMinute = signInDate.getMinutes();
		Date signOutDate = DateFormat.stringToDate(singOutDateTimeStr);
		int signOutMinute = signOutDate.getMinutes();
		double signInDateTime = (double)DateFormat.stringToDate(signInDateTimeStr).getTime();
		if(signInMinute>30){
			signInDateTime+=(60-signInMinute)*60*1000;
		}else{
			signInDateTime+=(30-signInMinute)*60*1000;
		}
		double singOutDateTime = (double)DateFormat.stringToDate(singOutDateTimeStr).getTime();
		if(signOutMinute>=30){
			singOutDateTime-=(signOutMinute-30)*60*1000;
		}else{
			singOutDateTime-=signOutMinute*60*1000;
		}
		double actualWorkTimeHours = 0;
		double result = 0;
		if(signInDateTime<=workStart && singOutDateTime>=workEnd){//正常情况
			actualWorkTimeHours = (singOutDateTime-workStart)/1000/60/60;
			int actualWorkTimeHours_Int = (int)actualWorkTimeHours;
			if((actualWorkTimeHours-actualWorkTimeHours_Int)>=0.5){
				result = actualWorkTimeHours_Int+0.5;
			}else{
				result = actualWorkTimeHours_Int;
			}
			//减去午休时间
			result--;
		}else if(signInDateTime>workStart && signInDateTime<restTimeStartDate){//实际签到时间超过规定签到时间,未超过午休开始时间
			actualWorkTimeHours = (singOutDateTime-signInDateTime)/1000/60/60;
			int actualWorkTimeHours_Int = (int)actualWorkTimeHours;
			if((actualWorkTimeHours-actualWorkTimeHours_Int)>=0.5){
				result = actualWorkTimeHours_Int+0.5;
			}else{
				result = actualWorkTimeHours_Int;
			}
			//减去午休时间
			result--;
		}else if(signInDateTime>=restTimeStartDate && signInDateTime<restTimeEndDate){//实际签到时间在午休期间
			actualWorkTimeHours = (singOutDateTime-restTimeEndDate)/1000/60/60;
			int actualWorkTimeHours_Int = (int)actualWorkTimeHours;
			if((actualWorkTimeHours-actualWorkTimeHours_Int)>=0.5){
				result = actualWorkTimeHours_Int+0.5;
			}else{
				result = actualWorkTimeHours_Int;
			}
		}else if(signInDateTime>restTimeEndDate){//实际签到时间超过午休结束时间
			actualWorkTimeHours = (singOutDateTime-signInDateTime)/1000/60/60;
			int actualWorkTimeHours_Int = (int)actualWorkTimeHours;
			if((actualWorkTimeHours-actualWorkTimeHours_Int)>=0.5){
				result = actualWorkTimeHours_Int+0.5;
			}else{
				result = actualWorkTimeHours_Int;
			}
		}
		return result;
	}
}

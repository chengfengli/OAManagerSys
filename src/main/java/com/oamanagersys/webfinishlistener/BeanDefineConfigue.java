package com.oamanagersys.webfinishlistener;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PropertiesLoaderUtils;

import com.oamanagersys.model.apply.dao.ApplyTypeDao;
import com.oamanagersys.model.apply.entity.ApplyType;

/**
 * 服务器启动完成之后执行
 * @author	李明
 * @tel		17310545652
 * @createtime	2017年8月1日 上午10:54:45
 */
public class BeanDefineConfigue implements ApplicationListener<ContextRefreshedEvent> {
	Logger logger = Logger.getLogger(BeanDefineConfigue.class);
	@Autowired
	private ApplyTypeDao applyTypeDao;
	@SuppressWarnings("rawtypes")
	public void onApplicationEvent(ContextRefreshedEvent event) {
		try {
			int delete = applyTypeDao.delete();
			if(delete > 0){
				logger.info("申请类型重置成功");
			}else{
				logger.info("申请类型重置失败");
			}
			Resource resource = new ClassPathResource("/apply_type.properties");
			Properties pps = PropertiesLoaderUtils.loadProperties(resource);
			Enumeration enum1 = pps.propertyNames();
			List<ApplyType> list =  new ArrayList<ApplyType>();
			while (enum1.hasMoreElements()) {
				ApplyType applyType = new ApplyType();
				String strKey = (String) enum1.nextElement();
				String strValue = pps.getProperty(strKey);
				applyType.setTypeCode(strKey);
				applyType.setTypeName(strValue);
				list.add(applyType);
			}
			int insert = applyTypeDao.insert(list);
			if(insert > 0){
				logger.info("申请类型初始化成功");
			}else{
				System.err.println("申请类型初始化失败");
			}
		} catch (IOException e) {
			logger.info("申请类型初始化异常："+e.getMessage());
		}
	}

}

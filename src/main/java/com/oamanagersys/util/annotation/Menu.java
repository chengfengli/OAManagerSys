package com.oamanagersys.util.annotation;

import java.lang.annotation.*;

@Target({ElementType.METHOD,ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Menu {
	//菜单名称 必填
	String text();
	//唯一标识，必填，用于页面设置标签的id
	String id();
}

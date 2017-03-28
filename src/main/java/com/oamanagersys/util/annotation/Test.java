package com.oamanagersys.util.annotation;

import java.util.List;
import java.util.Map;

public class Test {

	public static void main(String[] args) {
		List<String> childlist = AnnotationUtil.getClasses("com.oamanagersys.model");
		Map<String,Object> childMap = AnnotationUtil.getClassName(childlist, null);

	}

}

package com.oamanagersys.util.annotation;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileFilter;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.net.JarURLConnection;
import java.net.URL;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.collections.set.SynchronizedSet;

import net.sf.json.JSONObject;

public class AnnotationUtil {
	/**
	 * 从包package中获取所有的Class
	 * 
	 * @param pack
	 * @return
	 */
	public static List<String> getClasses(String packageName) {
		// 第一个class类的集合
		List<String> classes = new ArrayList<String>();
		// 是否循环迭代
		boolean recursive = true;
		// 获取包的名字 并进行替换
		String packageDirName = packageName.replace('.', '/');
		// 定义一个枚举的集合 并进行循环来处理这个目录下的things
		Enumeration<URL> dirs;
		try {
			dirs = Thread.currentThread().getContextClassLoader().getResources(packageDirName);
			// 循环迭代下去
			while (dirs.hasMoreElements()) {
				// 获取下一个元素
				URL url = dirs.nextElement();
				// 得到协议的名称
				String protocol = url.getProtocol();
				// 如果是以文件的形式保存在服务器上
				if ("file".equals(protocol)) {
					// 获取包的物理路径
					String filePath = URLDecoder.decode(url.getFile(), "UTF-8");
					// 以文件的方式扫描整个包下的文件 并添加到集合中
					findAndAddClassesInPackageByFile(packageName, filePath, recursive, classes);
				} else if ("jar".equals(protocol)) {
					// 如果是jar包文件
					// 定义一个JarFile
					JarFile jar;
					try {
						// 获取jar
						jar = ((JarURLConnection) url.openConnection()).getJarFile();
						// 从此jar包 得到一个枚举类
						Enumeration<JarEntry> entries = jar.entries();
						// 同样的进行循环迭代
						while (entries.hasMoreElements()) {
							// 获取jar里的一个实体 可以是目录 和一些jar包里的其他文件 如META-INF等文件
							JarEntry entry = entries.nextElement();
							String name = entry.getName();
							// 如果是以/开头的
							if (name.charAt(0) == '/') {
								// 获取后面的字符串
								name = name.substring(1);
							}
							// 如果前半部分和定义的包名相同
							if (name.startsWith(packageDirName)) {
								int idx = name.lastIndexOf('/');
								// 如果以"/"结尾 是一个包
								if (idx != -1) {
									// 获取包名 把"/"替换成"."
									packageName = name.substring(0, idx).replace('/', '.');
								}
								// 如果可以迭代下去 并且是一个包
								if ((idx != -1) || recursive) {
									// 如果是一个.class文件 而且不是目录
									if (name.endsWith(".class") && !entry.isDirectory()) {
										// 去掉后面的".class" 获取真正的类名
										String className = name.substring(packageName.length() + 1, name.length() - 6);
										// 添加到classes
										classes.add(packageName + '.' + className);
									}
								}
							}
						}
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		return classes;
	}

	/**
	 * 以文件的形式来获取包下的所有Class
	 * 
	 * @param packageName
	 * @param packagePath
	 * @param recursive
	 * @param classes
	 */
	public static void findAndAddClassesInPackageByFile(String packageName, String packagePath, final boolean recursive,
			List<String> classes) {
		// 获取此包的目录 建立一个File
		File dir = new File(packagePath);
		// 如果不存在或者 也不是目录就直接返回
		if (!dir.exists() || !dir.isDirectory()) {
			return;
		}
		// 如果存在 就获取包下的所有文件 包括目录
		File[] dirfiles = dir.listFiles(new FileFilter() {
			// 自定义过滤规则 如果可以循环(包含子目录) 或则是以.class结尾的文件(编译好的java类文件)
			public boolean accept(File file) {
				return (recursive && file.isDirectory()) || (file.getName().endsWith(".class"));
			}
		});
		// 循环所有文件
		for (File file : dirfiles) {
			// 如果是目录 则继续扫描
			if (file.isDirectory()) {
				findAndAddClassesInPackageByFile(packageName + "." + file.getName(), file.getAbsolutePath(), recursive,
						classes);
			} else {
				// 如果是java类文件 去掉后面的.class 只留下类名
				String className = file.getName().substring(0, file.getName().length() - 6);
				// 添加到集合中去
				classes.add(packageName + '.' + className);
			}
		}
	}

	public static List<Map<String, String>> getClassName(List<String> list) {
		List<Map<String, String>> result = new ArrayList<Map<String, String>>();
		try {
			List<Field[]> fieldslist = new ArrayList<Field[]>();
			for (String str : list) {
				Class<?> cls = Class.forName(str);
				
				Field[] fields = cls.getDeclaredFields();
				fieldslist.add(fields);
			}

			for (Field[] fields : fieldslist) {
				for (Field field : fields) {
					if (field.isAnnotationPresent(Menu.class) == true) {
						Menu menu = field.getAnnotation(Menu.class);
						Map<String, String> map = new HashMap<String, String>();
						map.put("text", menu.text());
						map.put("id", menu.id());
						result.add(map);
					}
				}
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return result;
	}
	/**
	 * 读取菜单子json文件
	 * @param path
	 * @return
	 */
	public static Map<String,Object> ReadJsonFile(String path,HttpServletRequest request) { 
        File file = new File(request.getServletContext().getRealPath("/")+path);
        BufferedReader reader = null;
        String jsonstr = "";
        try {  
            reader = new BufferedReader(new FileReader(file));
            String tempString = null;  
            while ((tempString = reader.readLine()) != null) {  
            	jsonstr = jsonstr + tempString;  
            }  
            reader.close();  
        } catch (IOException e) {  
            e.printStackTrace();  
        } finally {  
            if (reader != null) {  
                try {  
                    reader.close();  
                } catch (IOException e) { 
                	e.printStackTrace();
                }  
            }
        }
        jsonstr = jsonstr.replaceAll("\\s+", "");
        if(request!=null){
	        StringBuffer sb = new StringBuffer();
			String scheme = request.getScheme();
			String servletNmae = request.getServerName();
			String servletPort = Integer.toString(request.getServerPort());
			sb.append(scheme);
			sb.append("://");
			sb.append(servletNmae);
			sb.append(":");
			sb.append(servletPort);
			sb.append("/");
			sb.append("OAManagerSys/");
	        jsonstr = jsonstr.replaceAll("url='", "url='"+sb.toString());
        }
        JSONObject jb = JSONObject.fromObject(jsonstr);
        Map<String,Object> map = (Map<String, Object>)jb;
        return map;
    }
	
	
	/**
	 * 设置权限 读取菜单子json文件
	 * @param path
	 * @return
	 */
	public static Map<String,Object> setJsonFile(String path,HttpServletRequest request) { 
        File file = new File(request.getServletContext().getRealPath("/")+path);
        BufferedReader reader = null;
        String jsonstr = "";
        try {  
            reader = new BufferedReader(new FileReader(file));
            String tempString = null;  
            while ((tempString = reader.readLine()) != null) {  
            	jsonstr = jsonstr + tempString;  
            }  
            reader.close();  
        } catch (IOException e) {  
            e.printStackTrace();  
        } finally {  
            if (reader != null) {  
                try {  
                    reader.close();  
                } catch (IOException e) { 
                	e.printStackTrace();
                }  
            }
        }
        jsonstr = jsonstr.replaceAll("\\s+", "");
        System.out.println(jsonstr);
        JSONObject jb = JSONObject.fromObject(jsonstr);
        Map<String,Object> map = (Map<String, Object>)jb;
        return map;
    }
}

package com.oamanagersys.util.server;

import javax.servlet.http.HttpServletRequest;

/**工具类
 * 服务器
 * @author 李明
 * @time 2017年7月9日 下午5:35:47
 * @phone 17310545652
 */
public class Server {

	public static String getServerUrl(HttpServletRequest request){
		StringBuffer sb = new StringBuffer();
		String scheme = request.getScheme();
		String servletNmae = request.getServerName();
		String servletPort = Integer.toString(request.getServerPort());
		String context = request.getContextPath()+"/";
		sb.append(scheme);
		sb.append("://");
		sb.append(servletNmae);
		sb.append(":");
		sb.append(servletPort);
		sb.append(context);
		return sb.toString();
	}
}

package com.oamanagersys.model.file.entity;
import java.text.DecimalFormat;

import com.oamanagersys.util.base.BaseEntity;
/**
 * 文件类
 * @author	李明
 * @tel		17310545652
 * @createtime	2017年7月7日 下午3:11:13
 */

public class FileEntity extends BaseEntity {
	//文件别名
	private String fileAlias;
	
	//文件真实名
	private String fileName;
	
	//文件大小
	private String fileSize;
	
	//文件路径
	private String fileUrl;

	public String getFileAlias() {
		return fileAlias;
	}

	public void setFileAlias(String fileAlias) {
		this.fileAlias = fileAlias;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFileSize() {
		return fileSize;
	}

	public void setFileSize(Long size) {
		double B = 1024;
		double fileSize = (double)size;
		DecimalFormat df = new DecimalFormat("#.00");
		if(fileSize >= (B*B*B)){
			this.fileSize = df.format(fileSize/(B*B*B))+"GB";//GB
		}else if(fileSize >= (B*B)){
			this.fileSize = df.format(fileSize/(B*B))+"MB";//MB
		}else if(fileSize >= B){
			this.fileSize = df.format(fileSize/(B))+"KB";//KB
		}else{
			this.fileSize = Double.toString(fileSize)+"B";
		}
	}

	public String getFileUrl() {
		return fileUrl;
	}

	public void setFileUrl(String fileUrl) {
		this.fileUrl = fileUrl;
	}
	
}

package com.oamanagersys.model.file.service;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.oamanagersys.model.file.dao.FileDao;
import com.oamanagersys.model.file.entity.FileEntity;
import com.oamanagersys.util.format.DateFormat;
import com.oamanagersys.util.response.Message;

@Service
public class FileService {
	@Autowired
	public FileDao fileDao;
	/**
	 * 上传文件
	 * @param files 文件
	 * @param path 上传路径
	 * @param url 服务器地址
	 * @return
	 */
	public Message upload(MultipartFile files[],String path,String url){
		Message massage = new Message();
		List<FileEntity> list = new ArrayList<FileEntity>();
		try {
			String fileId = DateFormat.dateTime();
			for(int i=0;i<files.length;i++){
				MultipartFile file = files[i];
				String fileName = file.getOriginalFilename();
				//后缀名
				String suffix = fileName.substring(fileName.lastIndexOf("."));
				String time = DateFormat.dateTime();
				File targetFile = new File(path, time+suffix);
				if (!targetFile.exists()) {
					targetFile.mkdirs();
				}
				//上传
				file.transferTo(targetFile);
				
				FileEntity fileEntity = new FileEntity();
				fileEntity.setFileAlias(time+suffix);
				fileEntity.setFileName(fileName);
				fileEntity.setFileSize(file.getSize());
				fileEntity.setFileUrl(url+"/"+fileEntity.getFileAlias());
				fileEntity.setFilePath(targetFile.toString());
				fileEntity.setFileId(fileId);
				fileEntity.setCreateTime(DateFormat.newDateString());
				list.add(fileEntity);
			}
			int count = insert_file(list);
			if(count > 0){
				massage.isSuccess = true;
				massage.strMessage = fileId;
			}else{
				massage.isSuccess = false;
			}
		} catch (Exception e) {
			e.printStackTrace();
			massage.isSuccess = false;
			massage.strMessage = "系统异常";
		}
		return massage;
	}
	
	/**
	 * 保存文件信息到数据库
	 * @param list
	 * @return
	 */
	public int insert_file(List<FileEntity> list){
		return fileDao.insert(list);
	}
	/**
	 * 查询文件
	 * @param file
	 * @return
	 */
	public List<FileEntity> select(FileEntity file){
		List<FileEntity> list  = fileDao.select(file);
		return list;
	}
}

package com.oamanagersys.model.file.service;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.oamanagersys.model.file.entity.FileEntity;
import com.oamanagersys.util.format.DateFormat;
import com.oamanagersys.util.response.Message;

@Service
public class FileService {
	/**
	 * 上传文件
	 * @param files 文件
	 * @param path 上传路径
	 * @param emp
	 * @return
	 */
	public Message upload(MultipartFile files[],String path){
		Message massage = new Message();
		List<FileEntity> list = new ArrayList<FileEntity>();
		try {
			String time = DateFormat.dateTime();
			for(int i=0;i<files.length;i++){
				MultipartFile file = files[i];
				FileEntity fileEntity = new FileEntity();
				fileEntity.setFileName(file.getName());
				fileEntity.setFileAlias(time);
				fileEntity.setFileSize(file.getSize());
				fileEntity.setFileUrl(path);
				list.add(fileEntity);
				String fileName = file.getOriginalFilename();
				File targetFile = new File(path, fileName);
				if (!targetFile.exists()) {
					targetFile.mkdirs();
				}
				//上传
				file.transferTo(targetFile);
			}
		} catch (Exception e) {
			e.printStackTrace();
			massage.isSuccess = false;
			massage.strMessage = "系统异常";
		}
		return massage;
	}
}

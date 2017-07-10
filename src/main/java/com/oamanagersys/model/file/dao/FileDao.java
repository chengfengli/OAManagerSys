package com.oamanagersys.model.file.dao;

import java.util.List;

import com.oamanagersys.model.file.entity.FileEntity;

public interface FileDao {
	public int insert(List<FileEntity> list);
	
	public List<FileEntity> select(FileEntity file);
}

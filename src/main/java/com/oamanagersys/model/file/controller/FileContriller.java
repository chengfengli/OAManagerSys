package com.oamanagersys.model.file.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.oamanagersys.model.file.service.FileService;
import com.oamanagersys.util.response.Message;

@RequestMapping("/file")
@Controller
public class FileContriller {
	@Autowired
	private FileService fileService;
	
	@RequestMapping("/upload")
	@ResponseBody
	public Message upload(HttpServletRequest request, @RequestParam("file") MultipartFile files[]) {
        String path = request.getSession().getServletContext().getRealPath("upload");
        Message message  = fileService.upload(files, path);
        return message;
    }
}

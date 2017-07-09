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
import com.oamanagersys.util.server.Server;

@RequestMapping("/file")
@Controller
public class FileContriller {
	@Autowired
	private FileService fileService;
	
	@RequestMapping("/upload")
	@ResponseBody
	public Message upload(HttpServletRequest request, @RequestParam("file") MultipartFile files[]) {
		String folder = "upload";
		//上传路径
        String path = request.getSession().getServletContext().getRealPath(folder);
        //服务器地址
        String url = Server.getServerUrl(request)+folder;
        Message message  = fileService.upload(files, path,url);
        return message;
    }
}

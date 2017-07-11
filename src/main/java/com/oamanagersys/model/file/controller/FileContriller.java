package com.oamanagersys.model.file.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.oamanagersys.model.file.entity.FileEntity;
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
	
	/**
	 * 附件页面
	 * @return
	 */
	@RequestMapping("page/list")
	@ResponseBody
	public ModelAndView listPage(String fileId){
		ModelAndView mav = new ModelAndView("pages/email/file_view");
		mav.addObject("fileId", fileId);
		return mav;
	}
	
	/**
	 * 附件列表
	 * @return
	 */
	@RequestMapping("/list")
	@ResponseBody
	public Map<String,List<FileEntity>> inboxList(FileEntity file){
		Map<String,List<FileEntity>> map = new HashMap<String,List<FileEntity>>();
		List<FileEntity> files = fileService.select(file);
		map.put("Rows", files);
		return map;
	}
}

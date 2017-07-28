package com.oamanagersys.model.file.controller;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
	
	/**
	 * 上传附件
	 * @param request
	 * @param files
	 * @return
	 */
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
	
	/**
	 * 下载附件
	 * @param request
	 * @param files
	 * @return
	 */
	@RequestMapping("/download")
	@ResponseBody
	public void download(FileEntity file,HttpServletResponse response,HttpServletRequest request) {
		try {
			List<FileEntity> files = fileService.select(file);
			if(files.size() > 0){
				file = files.get(0);
			}
			//获得请求文件名  
			String filename = file.getFileAlias();  
			  
			//设置文件MIME类型  
			response.setContentType(request.getServletContext().getMimeType(filename));  
			//设置Content-Disposition  
			response.setHeader("Content-Disposition", "attachment;filename="+filename);  
			//获取目标文件的绝对路径  
			String fullFileName = file.getFilePath();
			//读取文件  
			InputStream in = new FileInputStream(fullFileName);  
			OutputStream out = response.getOutputStream();  
			  
			//写文件  
			int b;  
			while((b=in.read())!= -1)  
			{  
			    out.write(b);  
			}  
			  
			in.close();  
			out.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
}

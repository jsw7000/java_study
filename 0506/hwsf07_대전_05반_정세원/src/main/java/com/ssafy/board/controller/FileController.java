package com.ssafy.board.controller;

import java.io.File;
import java.io.FileInputStream;
import java.util.Random;

import javax.servlet.ServletContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ssafy.board.model.dto.FileDto;
import com.ssafy.board.model.service.FileService;

@Controller
public class FileController {
	@Autowired
	private FileService fservice;
	@Autowired
	ServletContext servletContext;
	
	@GetMapping("/upload")
	public String upload() {
		return "uploadForm";
	}
	
	@PostMapping("/upload")
	public ModelAndView upload(FileDto dto) {
		String path = servletContext.getRealPath("/resources/img");
		
		File dir = new File(path);
		if(!dir.exists())
			dir.mkdir();
		
		String savedName = path + new Random().nextInt(100000000);
		File saveFile = new File(savedName);
		
		try {
			dto.getUploadFile().transferTo(saveFile);
			String str = new String(dto.getUploadFile().getOriginalFilename().getBytes("8859_1"),"utf-8");
			dto.setFilename(str);
			dto.setOrigin(saveFile.getAbsolutePath());
			fservice.saveFile(dto);
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		ModelAndView mav = new ModelAndView("uploadResult");
		mav.addObject("dto", dto);
		return mav;
		
	}
	
	@GetMapping("/fileList")
	public String fileList(Model model) {
		model.addAttribute("fileList", fservice.searchAll());
		return "fileList";
	}
	

	@GetMapping("/download")
	public void download(int fno,HttpServletResponse response) {
		FileDto dto = fservice.searchFile(fno);
		
		response.setContentType("application/octet-stream; charset=UTF-8"); // 이번 응답은 html이 아니라 파일이다.
		response.setHeader("Content-Disposition", "attachment; filename=\""+dto.getFilename()+"\"");
		
		try {
			FileInputStream is = new FileInputStream(dto.getOrigin()); //서버에 저장된 파일 읽음
			
			ServletOutputStream os = response.getOutputStream();
			
			int data = 0;
			while((data=is.read())!=-1)
				os.write(data);
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	
	}
	

}

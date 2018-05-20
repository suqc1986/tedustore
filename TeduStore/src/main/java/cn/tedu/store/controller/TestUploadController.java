package cn.tedu.store.controller;

import java.io.File;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/test")
public class TestUploadController {
	@RequestMapping("/showUpload.do")
	public String showUpload() {
		return "upload";
	}
	@RequestMapping("/doUpload.do")
	public String doUpload(MultipartFile file) throws Exception {
		
		file.transferTo(new File("/home/soft01/图片/imageFolder",file.getOriginalFilename()));
		
		return "redirect:../main/showIndex.do";
	}
}

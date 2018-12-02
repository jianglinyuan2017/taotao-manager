package com.taotao.contr;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.taotao.comm.util.JsonUtils;
import com.taotao.comm.util.PictureResult;
import com.taotao.service.PictureService;

@Controller
@RequestMapping("pic/")
public class PictureController {

	@Autowired
	PictureService PictureService;
	
	@RequestMapping(value="upload",method=RequestMethod.POST)
	@ResponseBody
	public String picUpload(MultipartFile uploadFile) {
		PictureResult result = PictureService.uploadFile(uploadFile);
		return JsonUtils.objectToJson(result);
	}
}

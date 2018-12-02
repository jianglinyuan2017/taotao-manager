package com.taotao.service;

import org.springframework.web.multipart.MultipartFile;
import com.taotao.comm.util.PictureResult;

public interface PictureService {
	
	public  PictureResult uploadFile(MultipartFile uploadFile);

}

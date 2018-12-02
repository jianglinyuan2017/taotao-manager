package com.taotao.service;

import java.io.IOException;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.taotao.comm.util.FtpUtil;
import com.taotao.comm.util.IDUtils;
import com.taotao.comm.util.PictureResult;

@Service
public class PictureServiceImpl implements PictureService {

	@Value("${ftp_host}")
	private String ftp_host;
	
	@Value("${ftp_port}")
	private int ftp_port;
	
	@Value("${ftp_userName}")
	private String ftp_userName;
	
	@Value("${ftp_passWord}")
	private String ftp_passWord;
	
	@Value("${ftp_basePath}")
	private String ftp_basePath;
	
	@Value("${ftp_addr}")
	private String ftp_addr;
	
	@Override
	public PictureResult uploadFile(MultipartFile uploadFile) {
		
		String savePicture = savePicture(uploadFile);
		if(StringUtils.isEmpty(savePicture)) {
			return new PictureResult(1,savePicture,"图片上传失败！");
		}
		return new PictureResult(0,savePicture);
	}

	private String savePicture(MultipartFile uploadFile) {
		if(uploadFile.isEmpty()) {
			return null;
		}
		String originalFilename = uploadFile.getOriginalFilename();
		String filePath = new DateTime().toString("yyyy/MM/dd/");
		String filename = IDUtils.genImageName()+originalFilename.substring(originalFilename.lastIndexOf("."));
		try {
			boolean result = FtpUtil.uploadFile(ftp_host, ftp_port, ftp_userName, ftp_passWord, ftp_basePath, 
					filePath, filename, uploadFile.getInputStream());
			if(!result) {
				throw new RuntimeException("上传失败");
			}
			return ftp_addr+filePath+filename;	
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
}

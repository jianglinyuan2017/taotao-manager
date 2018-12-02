package com.taotao.contr;

import java.io.File;
import java.util.Locale;

import org.springframework.web.servlet.view.JstlView;

public class DefaultJstlView extends JstlView{

	 @Override
	    public boolean checkResource(Locale locale) throws Exception {
	        File file = new File(this.getServletContext().getRealPath("/") + getUrl());
	        File file1 = new File(this.getServletContext().getRealPath("/"));
	        File[] listFiles = file1.listFiles();
	        for (int i = 0; i < listFiles.length; i++) {
				File file2 = listFiles[i];
				System.out.println(file2.getAbsolutePath());
				System.out.println(file2.getName());
			}
	        System.out.println(file.exists());
	        return file.exists();//判断该jsp页面是否存在
	    }
}

package com.taotao.contr;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.taotao.comm.pojo.EUDataGridResult;
import com.taotao.comm.util.TaotaoResult;
import com.taotao.pojo.TbContent;
import com.taotao.service.ContentService;

@Controller
@RequestMapping("/content")
public class contentController {
	
	@Autowired
	ContentService contentService;
	
	@RequestMapping("/query/list")
	@ResponseBody
	public EUDataGridResult getQueryList(long categoryId,@RequestParam(defaultValue="1") Integer page,@RequestParam(defaultValue="20") Integer rows) {
		EUDataGridResult queryList = contentService.getQueryList(categoryId, page, rows);
		return queryList;
	}

	@RequestMapping("/save")
	@ResponseBody
	public TaotaoResult save(TbContent tbContent) {
		TaotaoResult save = contentService.save(tbContent);
		return save;
	}
}

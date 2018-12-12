package com.taotao.service;

import org.springframework.web.bind.annotation.RequestParam;

import com.taotao.comm.pojo.EUDataGridResult;
import com.taotao.comm.util.TaotaoResult;
import com.taotao.pojo.TbContent;

public interface ContentService {
	
	public EUDataGridResult getQueryList(long categoryId,Integer page,Integer rows);
	
	public TaotaoResult save(TbContent tbContent);

}

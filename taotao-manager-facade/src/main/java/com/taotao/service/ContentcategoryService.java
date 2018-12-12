package com.taotao.service;

import java.util.List;

import org.springframework.web.bind.annotation.RequestParam;

import com.taotao.comm.pojo.EUTreeNode;
import com.taotao.comm.util.TaotaoResult;

public interface ContentcategoryService {

	public List<EUTreeNode> getContentCat(long parentId);
	
	public TaotaoResult create(long parentId, String name);
	
	public TaotaoResult Update(long id,String name);
	
	public TaotaoResult Delete(long id,long parentId);
}

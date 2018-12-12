package com.taotao.service;

import java.util.List;

import org.springframework.web.bind.annotation.RequestParam;

import com.taotao.comm.util.TaotaoResult;
import com.taotao.pojo.TbItemCat;

public interface ItemCatService {

	/**
	  * 商品列表
	 * @return
	 */
	public List<TbItemCat> getItemCatList(long parent_id);
}

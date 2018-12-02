package com.taotao.service;

import java.util.List;

import com.taotao.pojo.TbItemCat;

public interface ItemCatService {

	/**
	  * 商品列表
	 * @return
	 */
	public List<TbItemCat> getItemCatList(long parent_id);
}

package com.taotao.service;

import java.util.List;
import java.util.Map;

import com.taotao.comm.pojo.EUDataGridResult;
import com.taotao.pojo.TbItem;

public interface ItemService {
	
	public TbItem getItemById(long itemId);
	
	public EUDataGridResult getPage(int page,int pageSize);
	
	public String itemSave(TbItem tbItem,String desc);

}

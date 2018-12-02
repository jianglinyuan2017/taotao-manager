package com.taotao.service;

import com.taotao.comm.pojo.EUDataGridResult;
import com.taotao.comm.util.TaotaoResult;
import com.taotao.pojo.TbItemParam;

public interface ItemParamService {

	TaotaoResult getItemParamByCid(long cid);
	TaotaoResult insertItemParam(TbItemParam itemParam);
	
	public EUDataGridResult getPage(int page, int pageSize);
}

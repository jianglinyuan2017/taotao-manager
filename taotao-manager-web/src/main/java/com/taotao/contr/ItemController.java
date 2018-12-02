package com.taotao.contr;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.taotao.comm.pojo.EUDataGridResult;
import com.taotao.comm.util.TaotaoResult;
import com.taotao.pojo.TbItem;
import com.taotao.service.ItemService;

@Controller
@RequestMapping("/item")
public class ItemController {
	
	@Autowired
	private ItemService itemService;
	
	@RequestMapping("/item/{itemId}")
	@ResponseBody
	public TbItem getItemById(@PathVariable Long itemId) {
		TbItem tbItem = itemService.getItemById(itemId);
		return tbItem;
	}
	

	@RequestMapping("/list")
	//设置相应的内容为json数据
	@ResponseBody
	public EUDataGridResult getItemlist(@RequestParam(defaultValue="1")Integer page, 
			@RequestParam(defaultValue="30")Integer rows) throws Exception {
		//查询商品列表
		EUDataGridResult result = itemService.getPage(page, rows);
		
		return result;
	}

	@RequestMapping("/save")
	@ResponseBody
	public TaotaoResult itemSave(TbItem tbItem, String desc) {
		itemService.itemSave(tbItem,desc);
		return TaotaoResult.ok();
	}
}

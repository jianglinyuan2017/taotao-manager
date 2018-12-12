package com.taotao.contr;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.taotao.comm.util.TaotaoResult;
import com.taotao.pojo.TbItemCat;
import com.taotao.service.ItemCatService;

@Controller
@RequestMapping("item/cat")
public class ItemCatController {
	
	@Autowired
	ItemCatService ItemCatService;
	
	
	
	@RequestMapping("/list")
	@ResponseBody
	public List<Map<String,Object>> getItemCatList(@RequestParam(value="id",defaultValue="0") long parent_id){
		List<Map<String,Object>> catList = new ArrayList<Map<String,Object>>();
		List<TbItemCat> itemCatList = ItemCatService.getItemCatList(parent_id);
		for (Iterator<TbItemCat> iterator = itemCatList.iterator(); iterator.hasNext();) {
			Map<String,Object> node = new HashMap<String,Object>();
			TbItemCat tbItemCat = iterator.next();
			node.put("id", tbItemCat.getId());
			node.put("text", tbItemCat.getName());
			node.put("state", tbItemCat.getIsParent()?"closed":"open");
			catList.add(node);
		}
		return catList;
	}
}

package com.taotao.contr;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.taotao.comm.pojo.EUTreeNode;
import com.taotao.comm.util.TaotaoResult;
import com.taotao.service.ContentcategoryService;

@Controller
@RequestMapping("/content/category")
public class Contentcategory {

	@Autowired
	ContentcategoryService contentcategoryService;
	
	@RequestMapping("/list")
	@ResponseBody
	public List<EUTreeNode> getContentCat(@RequestParam(value="id",defaultValue="0") long parentId) {
		List<EUTreeNode> contentCat = contentcategoryService.getContentCat(parentId);
		return contentCat;
	}
	
	@RequestMapping(value="/create",method=RequestMethod.POST)
	@ResponseBody
	public TaotaoResult Create(@RequestParam long parentId,@RequestParam String name) {
		return contentcategoryService.create(parentId, name);
	}
	
	@RequestMapping(value="/update",method=RequestMethod.POST)
	@ResponseBody
	public TaotaoResult Update(@RequestParam long id,@RequestParam String name) {
		return contentcategoryService.Update(id, name);
	}
	
	@RequestMapping(value="/delete",method=RequestMethod.POST)
	@ResponseBody
	public TaotaoResult Delete(@RequestParam long id,@RequestParam long parentId) {
		return contentcategoryService.Delete(id, parentId);
	}
}

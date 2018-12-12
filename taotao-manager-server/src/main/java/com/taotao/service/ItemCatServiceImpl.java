package com.taotao.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taotao.comm.util.TaotaoResult;
import com.taotao.mapper.TbItemCatMapper;
import com.taotao.pojo.TbContentCategory;
import com.taotao.pojo.TbItemCat;
import com.taotao.pojo.TbItemCatExample;
import com.taotao.pojo.TbItemCatExample.Criteria;

@Service
public class ItemCatServiceImpl implements ItemCatService{
	
	
	@Autowired
	private TbItemCatMapper tbItemCatMapper;
	
	@Override
	public List<TbItemCat> getItemCatList(long parent_id) {
		TbItemCatExample example = new TbItemCatExample();
		Criteria createCriteria = example.createCriteria();
		createCriteria.andParentIdEqualTo(parent_id);
		List<TbItemCat> selectByExample = tbItemCatMapper.selectByExample(example);
		return selectByExample;
	}


}

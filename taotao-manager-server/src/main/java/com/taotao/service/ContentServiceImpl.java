package com.taotao.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.taotao.comm.pojo.EUDataGridResult;
import com.taotao.comm.util.TaotaoResult;
import com.taotao.mapper.TbContentMapper;
import com.taotao.pojo.TbContent;
import com.taotao.pojo.TbContentExample;
import com.taotao.pojo.TbContentExample.Criteria;

@Service
public class ContentServiceImpl implements ContentService {

	@Autowired
	TbContentMapper tbContentMapper;
	
	@Override
	public EUDataGridResult getQueryList(long categoryId, Integer page, Integer rows) {
		TbContentExample example = new TbContentExample();
		Criteria createCriteria = example.createCriteria();
		createCriteria.andCategoryIdEqualTo(categoryId);
		PageHelper.startPage(page, rows);
		List<TbContent> selectByExample = tbContentMapper.selectByExample(example);
		PageInfo<TbContent> pageInfo = new PageInfo<TbContent>(selectByExample);
		EUDataGridResult eUDataGridResult = new EUDataGridResult();
		eUDataGridResult.setRows(selectByExample);
		eUDataGridResult.setTotal(pageInfo.getTotal());
		return eUDataGridResult;
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public TaotaoResult save(TbContent tbContent) {
		int insert = tbContentMapper.insert(tbContent);
		return TaotaoResult.ok();
	}

}

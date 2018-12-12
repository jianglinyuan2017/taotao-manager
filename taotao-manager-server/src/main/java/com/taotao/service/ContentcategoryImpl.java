package com.taotao.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.taotao.comm.pojo.EUTreeNode;
import com.taotao.comm.util.TaotaoResult;
import com.taotao.mapper.TbContentCategoryMapper;
import com.taotao.pojo.TbContentCategory;
import com.taotao.pojo.TbContentCategoryExample;
import com.taotao.pojo.TbContentCategoryExample.Criteria;

@Service
public class ContentcategoryImpl implements ContentcategoryService {

	@Autowired
	TbContentCategoryMapper tbContentCategoryMapper;
	
	@Override
	public List<EUTreeNode> getContentCat(long parentId) {
		TbContentCategoryExample example = new TbContentCategoryExample();
		Criteria createCriteria = example.createCriteria();
		createCriteria.andParentIdEqualTo(parentId);
		List<TbContentCategory> selectByExample = tbContentCategoryMapper.selectByExample(example);
		List<EUTreeNode> list = new ArrayList<EUTreeNode>();
		for(TbContentCategory t : selectByExample) {
			EUTreeNode node = new EUTreeNode();
			node.setId(t.getId());
			node.setText(t.getName());
			node.setState(t.getIsParent()?"closed":"open");
			list.add(node);
		}
		return list;
	}


	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public TaotaoResult create(long parentId, String name) {
		TbContentCategory tbContentCategory = new TbContentCategory();
		tbContentCategory.setParentId(parentId);
		tbContentCategory.setName(name);
		tbContentCategory.setCreated(new Date());
		tbContentCategory.setStatus(1);
		tbContentCategory.setSortOrder(1);
		tbContentCategory.setIsParent(false);
		int insert = tbContentCategoryMapper.insert(tbContentCategory);
		return TaotaoResult.ok();
	}


	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public TaotaoResult Update(long id, String name) {
		TbContentCategory tbContentCategory = new TbContentCategory();
		tbContentCategory.setName(name);
		int updateByPrimaryKey = tbContentCategoryMapper.updateByPrimaryKey(tbContentCategory);
		return TaotaoResult.ok();
	}


	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public TaotaoResult Delete(long id, long parentId) {
		tbContentCategoryMapper.deleteByPrimaryKey(id);
		return TaotaoResult.ok();
	}
}

package com.taotao.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.taotao.comm.pojo.EUDataGridResult;
import com.taotao.comm.util.IDUtils;
import com.taotao.mapper.TbItemDescMapper;
import com.taotao.mapper.TbItemMapper;
import com.taotao.pojo.TbItem;
import com.taotao.pojo.TbItemDesc;
import com.taotao.pojo.TbItemExample;
import com.taotao.pojo.TbItemExample.Criteria;

@Service
public class ItemServiceImpl implements ItemService {

	@Autowired
	private TbItemMapper itemMapper;
	
	@Autowired
	private TbItemDescMapper tbItemDescMapper;

	
	@Override
	@Transactional(readOnly=true)
	public TbItem getItemById(long itemId) {
		
		//TbItem item = itemMapper.selectByPrimaryKey(itemId);
		//添加查询条件
		TbItemExample example = new TbItemExample();
		Criteria criteria = example.createCriteria();
		criteria.andIdEqualTo(itemId);
		List<TbItem> list = itemMapper.selectByExample(example);
		if (list != null && list.size() > 0) {
			TbItem item = list.get(0);
			return item;
		}
		return null;
	}

	@Override
	@Transactional(readOnly=true)
	public EUDataGridResult getPage(int page, int pageSize) {
		TbItemExample example = new TbItemExample();
		PageHelper.startPage(page, pageSize);
		List<TbItem> selectByExample = itemMapper.selectByExample(example);
		EUDataGridResult eUDataGridResult = new EUDataGridResult();
		eUDataGridResult.setRows(selectByExample);
		//取记录总条数
		PageInfo<TbItem> pageInfo = new PageInfo<>(selectByExample);
		eUDataGridResult.setTotal(pageInfo.getTotal());
		return eUDataGridResult;
	}

	@Override
	public String itemSave(TbItem tbItem,String desc) {
		int saveItemTB = saveItemTB(tbItem);
		saveDesc(desc,tbItem.getId());
		System.out.println(saveItemTB);
		return null;
	}

	
	@Transactional(propagation=Propagation.REQUIRED)
	private int saveItemTB(TbItem tbItem) {
		long id = IDUtils.genItemId();
		tbItem.setId(id);
		tbItem.setStatus((byte)0);
		tbItem.setCreated(new Date());
		tbItem.setUpdated(new Date());
		int insert = itemMapper.insert(tbItem);
		return insert;
	}
	
	@Transactional(propagation=Propagation.REQUIRED)
	private void saveDesc(String desc,long item_id) {
		TbItemDesc tbItemDesc = new TbItemDesc();
		tbItemDesc.setItemId(item_id);
		tbItemDesc.setItemDesc(desc);
		tbItemDesc.setCreated(new Date());
		tbItemDesc.setUpdated(new Date());
		tbItemDescMapper.insert(tbItemDesc);
	}
}

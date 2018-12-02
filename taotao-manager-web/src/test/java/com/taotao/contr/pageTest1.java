package com.taotao.contr;
import java.net.URL;
import java.util.Iterator;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.github.pagehelper.PageHelper;
import com.taotao.mapper.TbItemMapper;
import com.taotao.pojo.TbItem;
import com.taotao.pojo.TbItemExample;

public class pageTest1 {

	public void PageList() {
		URL resource = this.getClass().getClassLoader().getResource("");
		System.out.println(resource.getPath());
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring/applicationContext-*.xml");
		TbItemMapper mapper = applicationContext.getBean(TbItemMapper.class);
		TbItemExample tbItemExample = new TbItemExample();
		PageHelper.startPage(1, 10);
		List<TbItem> selectByExample = mapper.selectByExample(tbItemExample);
		for (Iterator iterator = selectByExample.iterator(); iterator.hasNext();) {
			TbItem tbItem = (TbItem) iterator.next();
			System.out.println(tbItem.getTitle());
		}
	}
	
	public static void main(String[] args) {
		new pageTest1().PageList();
	}
}

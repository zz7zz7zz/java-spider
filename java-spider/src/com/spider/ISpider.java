package com.spider;

/**
 * 蜘蛛基类
 * @author yanglonghui
 *
 */
public interface ISpider {

	/**
	 * 抓取
	 */
	public void fetch(String []param);
	
	/**
	 * 处理数据
	 */
	public void onHandle();
	
	/**
	 * 回调
	 */
	public void onResponse();
	
}

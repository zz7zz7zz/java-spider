package com.spider.test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.spider.SpiderUtil;
import com.spider.image.BaiduImageSpider;

public class TestMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		SpiderUtil.fetch(new BaiduImageSpider(), "http://image.baidu.com");
		
//		String reg="^.*(?<!(不合谐))$";//用到了后顾  
//        System.out.println("不管信不信,反正现在很不合谐".matches(reg));//false不通过  
//        System.out.println("不管信不信,反正现在非常合谐".matches(reg));//true通过  
//        System.out.println("不合谐在某国是普遍存在的".matches(reg));//true通过  
        
//        Pattern p = Pattern.compile(reg,Pattern.CASE_INSENSITIVE);
//		Matcher m = p.matcher("不管信不信,反正现在很不合谐");
//        Matcher m = p.matcher("不合谐在某国是普遍存在的");
//		if(m.find())
//		{
//			System.out.println(m.group());
//		}
        
//		System.out.println("A: "+NetUtil.getHost("http://image.baidu.com/channel?c=%E7%BE%8E%E5%A5%B3&t=%E5%B0%8F%E6%B8%85%E6%96%B0&s=0"));
//		System.out.println("B: "+NetUtil.getHost("http://image.baidu.com"));
//		System.out.println("C: "+NetUtil.getHost("HTTP://image.baidu.com"));
//		System.out.println("D: "+NetUtil.getHost("image.baidu.com/"));
//		System.out.println("E: "+NetUtil.getHost("image.baidu.com"));
		
//		NetUtil.XHttp("http://www.baidu.com/", 80);
//		NetUtil.XHttp("http://www.baidu.com", 80);
//		NetUtil.XHttp("www.baidu.com", 80);
//		NetUtil.XHttp("http://image.baidu.com/channel?c=%E7%BE%8E%E5%A5%B3&t=%E5%B0%8F%E6%B8%85%E6%96%B0&s=0", 80);
		
//		NetUtil.getHost("http://image.baidu.com/channel?c=%E7%BE%8E%E5%A5%B3&t=%E5%B0%8F%E6%B8%85%E6%96%B0&s=0");
	}

}

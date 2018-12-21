/**
 * 
 */
package com.mock.test;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.alibaba.fastjson.JSONObject;
import com.mock.MockApplication;
import com.mock.controller.MockController;
import com.mock.entity.User;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

/**
 * @author ignore1992
 * 1.使用@SpringBootTest注解，通过classes属性，启动MockApplication应用
 * 2.测试指定的Controller
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = MockApplication.class)
public class MockTest1
{
	Logger logger = Logger.getLogger(MockTest1.class);
	
	private MockMvc mvc;
	
	@Autowired
	private MockController mockController;
	
	@Before
	public void setUp()
	{
		mvc = MockMvcBuilders.standaloneSetup(mockController).build();
	}
	
	@Test
	public void test()
	{
		//1.测试get请求
		try
		{
			RequestBuilder request = get("/mock/get").param("param", "中文参数").accept(MediaType.APPLICATION_JSON_UTF8);
			String res = mvc.perform(request).andReturn().getResponse().getContentAsString();
			logger.info(String.format("get请求成功，返回数据：%s", res));
		}
		catch(Exception e)
		{
			logger.error("测试发送get请求异常.", e);
		}
		
		//2.测试post请求
		try
		{
			User aUser = new User();
			aUser.setName("ignore1992");
			aUser.setAge(26);
			//传递对象参数
			RequestBuilder request = post("/mock/post").contentType(MediaType.APPLICATION_JSON_UTF8).content(JSONObject.toJSONString(aUser)).accept(MediaType.APPLICATION_JSON_UTF8);
			String res = mvc.perform(request).andReturn().getResponse().getContentAsString();
			logger.info(String.format("post请求成功，返回数据：%s", res));
		}
		catch(Exception e)
		{
			logger.error("测试发送post请求异常.", e);
		}
	}
}

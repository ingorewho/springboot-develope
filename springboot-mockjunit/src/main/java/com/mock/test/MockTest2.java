/**
 * 
 */
package com.mock.test;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.alibaba.fastjson.JSONObject;
import com.mock.entity.User;

/**
 * @author ignore1992
 * 1.SpringRunner是SpringJUnit4ClassRunner的子类，和使用SpringJUnit4ClassRunner达到的效果一样
 * 2.使用webEnvironment属性启用web容器，RANDOM_PORT表示端口随机
 * 3.测试所有controller的接口
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class MockTest2
{
	private Logger logger = Logger.getLogger(MockTest2.class);
	
	private MockMvc mvc;
	
	@Autowired
	private WebApplicationContext context; 
	
	@Before
	public void setUp()
	{
		mvc = MockMvcBuilders.webAppContextSetup(context).build();
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

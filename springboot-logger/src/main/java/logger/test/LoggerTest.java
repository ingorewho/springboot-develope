/**
 * 
 */
package logger.test;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import java.util.HashMap;
import java.util.Map;

import net.minidev.json.JSONObject;

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

/**
 * @author ignore1992
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class LoggerTest
{
	private MockMvc mvc;
	
	private Logger logger = Logger.getLogger(LoggerTest.class);
	
	@Autowired
	private WebApplicationContext wac;
	
	@Before
	public void setUp()
	{
		mvc = MockMvcBuilders.webAppContextSetup(wac).build();
	}
	
	@Test
	public void modifyLoggerLevel() throws Exception
	{
		RequestBuilder request = null;
		//0.查看当前系统默认日志级别
		request = get("/loggers");
		String defaultEncodeStr = mvc.perform(request).andReturn().getResponse().getContentAsString();
		logger.warn(String.format("系统默认日志级别为:%s", defaultEncodeStr));
		
		//1.未修改日志级别前调用LoggerController的testLogge方法
		request = get("/logger/test");
		mvc.perform(request);
		
		//2.修改日志级别为DEBUG级别后再次调用LoggerController的testLogge方法
		Map<String, String> map = new HashMap<String, String>();
		map.put("configuredLevel", "DEBUG");
		request = post("/loggers/logger.controller").contentType(MediaType.APPLICATION_JSON).content(JSONObject.toJSONString(map));
		mvc.perform(request);
		
		request = get("/logger/test");
		mvc.perform(request);
		
		//3.修改日志级别为WARN级别后再次调用LoggerController的testLogge方法
		Map<String, String> map1 = new HashMap<String, String>();
		map1.put("configuredLevel", "WARN");
		request = post("/loggers/logger.controller").contentType(MediaType.APPLICATION_JSON).content(JSONObject.toJSONString(map1));
		mvc.perform(request);
		
		request = get("/logger/test");
		mvc.perform(request);
		
	}
}

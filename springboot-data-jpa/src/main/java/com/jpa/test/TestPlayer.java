/**
 * 
 */
package com.jpa.test;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

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
import com.jpa.controller.PlayerController;
import com.jpa.entity.Player;

/**
 * @author ignore1992
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TestPlayer
{
	@Autowired
	private PlayerController playerController;
	
	private MockMvc mvc;
	
	@Before
	public void setUp()
	{
		mvc = MockMvcBuilders.standaloneSetup(playerController).build();
	}
	
	@Test
	public void test()
	{
		//添加一个Player
		try
		{
			Player aPlayer = new Player();
			aPlayer.setName("ignore1992");
			aPlayer.setId(1);
			RequestBuilder request = post("/player/add").contentType(MediaType.APPLICATION_JSON).content(JSONObject.toJSONString(aPlayer));
			mvc.perform(request);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
		//查询一个Player
		try
		{
			RequestBuilder request = post("/player/query").param("id", "1");
			mvc.perform(request);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
		//删除一个Player
		try
		{
			RequestBuilder request = post("/player/delete").param("id", "1");
			mvc.perform(request);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
}

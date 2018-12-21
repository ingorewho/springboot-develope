/**
 * 
 */
package com.mock.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mock.entity.User;

/**
 * @author ignore1992
 * RequestBody注释用于接收json格式参数
 */
@RestController
@RequestMapping(value = "mock")
public class MockController
{
	@RequestMapping(value = "get", method = RequestMethod.GET)
	public String get(String param)
	{
		return "测试get请求成功! 参数为: " + param;
	}
	
	@RequestMapping(value = "post", method = RequestMethod.POST)
	public String post(@RequestBody User aUser)
	{
		return "测试post请求成功! 参数为: " + aUser;
	}
}

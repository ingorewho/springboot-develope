/**
 * 
 */
package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

import com.event.MyEvent;
import com.listener.MyListener1;

/**
 * @author ignore1992
 *
 */
@SpringBootApplication
public class LisenterApplication
{
	public static void main(String[] args)
	{
		ConfigurableApplicationContext context = SpringApplication.run(LisenterApplication.class, args);
		//装载事件
		context.addApplicationListener(new MyListener1());
		//发布事件
		context.publishEvent(new MyEvent("测试事件."));
	}
}

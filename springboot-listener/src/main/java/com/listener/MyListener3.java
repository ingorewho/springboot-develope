/**
 * 
 */
package com.listener;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationListener;

import com.event.MyEvent;

/**
 * @author ignore1992
 *  通过在application.properties中配置监听
 */
public class MyListener3 implements ApplicationListener<MyEvent>
{
	Logger logger = Logger.getLogger(MyListener3.class);
	
	public void onApplicationEvent(MyEvent event)
	{
		logger.info(String.format("%s监听到事件源：%s.", MyListener3.class.getName(), event.getSource()));
	}
}

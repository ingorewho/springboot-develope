/**
 * 
 */
package com.listener;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationListener;

import com.event.MyEvent;

/**
 * @author ignore1992
 * 通过在springboot应用启动时手工添加监听器实现
 */
public class MyListener1 implements ApplicationListener<MyEvent>
{
	Logger logger = Logger.getLogger(MyListener1.class);
	
	public void onApplicationEvent(MyEvent event)
	{
		logger.info(String.format("%s监听到事件源：%s.", MyListener1.class.getName(), event.getSource()));
	}
}

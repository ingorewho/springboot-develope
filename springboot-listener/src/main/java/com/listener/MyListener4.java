/**
 * 
 */
package com.listener;

import org.apache.log4j.Logger;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import com.event.MyEvent;

/**
 * @author ignore1992
 * 通过@EventListener注解实现事件监听
 */
@Component
public class MyListener4
{
	Logger logger = Logger.getLogger(MyListener4.class);
	
	@EventListener
	public void listener(MyEvent event)
	{
		logger.info(String.format("%s监听到事件源：%s.", MyListener4.class.getName(), event.getSource()));
	}
}

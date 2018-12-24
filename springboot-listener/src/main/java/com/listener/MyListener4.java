/**
 * 
 */
package com.listener;

import com.event.MyEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * @author ignore1992
 * 通过@EventListener注解实现事件监听
 */
@Component
public class MyListener4
{
	private Logger logger = LogManager.getLogger();
	
	@EventListener
	public void listener(MyEvent event)
	{
		logger.info(String.format("%s监听到事件源：%s.", MyListener4.class.getName(), event.getSource()));
	}
}

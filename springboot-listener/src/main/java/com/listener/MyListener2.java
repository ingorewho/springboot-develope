/**
 * 
 */
package com.listener;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import com.event.MyEvent;

/**
 * @author ignore1992
 *  将监听器放入spring容器中
 */
@Component
public class MyListener2 implements ApplicationListener<MyEvent>
{
	Logger logger = Logger.getLogger(MyListener2.class);
	
	public void onApplicationEvent(MyEvent event)
	{
		logger.info(String.format("%s监听到事件源：%s.", MyListener2.class.getName(), event.getSource()));
	}
}

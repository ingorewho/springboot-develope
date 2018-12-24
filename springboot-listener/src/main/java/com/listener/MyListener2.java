/**
 * 
 */
package com.listener;

import com.event.MyEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * @author ignore1992
 *  将监听器放入spring容器中
 */
@Component
public class MyListener2 implements ApplicationListener<MyEvent>
{
	private Logger logger = LogManager.getLogger();

	@Override
	public void onApplicationEvent(MyEvent event)
	{
		logger.info(String.format("%s监听到事件源：%s.", MyListener2.class.getName(), event.getSource()));
	}
}

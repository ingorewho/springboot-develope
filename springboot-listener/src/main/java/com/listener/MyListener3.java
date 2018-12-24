/**
 * 
 */
package com.listener;

import com.event.MyEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.ApplicationListener;

/**
 * @author ignore1992
 *  通过在application.properties中配置监听
 */
public class MyListener3 implements ApplicationListener<MyEvent>
{
	private Logger logger = LogManager.getLogger();

	@Override
	public void onApplicationEvent(MyEvent event)
	{
		logger.info(String.format("%s监听到事件源：%s.", MyListener3.class.getName(), event.getSource()));
	}
}

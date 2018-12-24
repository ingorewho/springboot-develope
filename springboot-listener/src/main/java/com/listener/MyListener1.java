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
 * 通过在springboot应用启动时手工添加监听器实现
 */
public class MyListener1 implements ApplicationListener<MyEvent>
{
	private Logger logger = LogManager.getLogger();

	@Override
	public void onApplicationEvent(MyEvent event)
	{
		logger.info(String.format("%s监听到事件源：%s.", MyListener1.class.getName(), event.getSource()));
	}
}

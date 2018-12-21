/**
 * 
 */
package com.event;

import org.springframework.context.ApplicationEvent;

/**
 * @author ignore1992
 *
 */
@SuppressWarnings("serial")
public class MyEvent extends ApplicationEvent
{
	public MyEvent(Object source)
	{
		super(source);
	}
}

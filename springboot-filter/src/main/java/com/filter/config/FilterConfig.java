/**
 * 
 */
package com.filter.config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.filter.service.SimpleFilter;

/**
 * @author ignore1992
 * 
 */
@Configuration
public class FilterConfig
{
	@Bean
	public FilterRegistrationBean createSimpleFilterBean()
	{
		FilterRegistrationBean aBean = new FilterRegistrationBean();
		aBean.setFilter(new SimpleFilter());
		//设置匹配请求url
		aBean.addUrlPatterns("/*");
		//设置注册Bean的顺序
		aBean.setOrder(1);
		aBean.setName("simpleFilter");
		return aBean;
	}
}

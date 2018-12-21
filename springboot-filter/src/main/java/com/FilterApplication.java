/**
 * 
 */
package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

/**
 * @author ignore1992
 * springboot有两种扫描filter的方式：
 * 1.定义一个FilterRegistrationBean，将自己写的filter设置进去
 * 2.使用注解方式实现
 */
@SpringBootApplication
@ServletComponentScan
public class FilterApplication
{
	public static void main(String[] args)
	{
		SpringApplication.run(FilterApplication.class, args);
	}
}

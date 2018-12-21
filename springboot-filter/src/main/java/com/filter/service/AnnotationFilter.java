/**
 * 
 */
package com.filter.service;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import org.springframework.core.annotation.Order;

/**
 * @author ignore1992
 *
 */
@Order(1)
@WebFilter(filterName = "annotationFilter", urlPatterns = "/*")
public class AnnotationFilter implements Filter
{
	public void init(FilterConfig arg0) throws ServletException
	{
		
	}
	
	public void doFilter(ServletRequest req, ServletResponse res,
			FilterChain chain) throws IOException, ServletException
	{
		res.getWriter().write("annotation filter!!");
		chain.doFilter(req, res);
	}

	public void destroy()
	{
		
	}
}

/**
 * 
 */
package thymeleaf.controller;

import java.util.ArrayList;
import java.util.List;

import javax.swing.text.View;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import thymeleaf.repository.ThymeleafBean;

/**
 * @author ignore1992
 *
 */
@RestController
@RequestMapping(value="thymeleaf")
public class ThymeleafController
{
	
	@RequestMapping(value="getList")
	public ModelAndView getList(ModelAndView model)throws Exception
	{
		List<ThymeleafBean> result = new ArrayList<ThymeleafBean>();
		//模拟获取一个Bean列表
		for(int i = 0; i < 5; i++)
		{
			ThymeleafBean aBean = new ThymeleafBean("bean实例"+ i , "这是thymeleaf使用" + i, "主要用于前端开发" + i);
			result.add(aBean);
		}
		model.addObject("thymeleafs", result);
		//访问自定义目录下/templates/thymeleaf/list.html，要注意路径格式
		model.setViewName("thymeleaf/list");
		return model;
	}
	
}

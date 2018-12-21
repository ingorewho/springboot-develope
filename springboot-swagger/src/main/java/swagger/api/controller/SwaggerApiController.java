/**
 * 
 */
package swagger.api.controller;

import io.swagger.annotations.ApiOperation;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ignore1992
 *
 */
@RestController
@RequestMapping(value = "/swaggerapi")
public class SwaggerApiController
{
	@ApiOperation(value = "测试swaggerapi接口方法")
	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public String test()throws Exception
	{
		return "swaggerapi 测试";
	}
}

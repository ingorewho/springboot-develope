/**
 * 
 */
package logger.controller;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ignore1992
 *
 */
@RestController
@RequestMapping(value="logger")
public class LoggerController
{
	private Logger logger = Logger.getLogger(LoggerController.class);
	
	@RequestMapping(value = "test", method= RequestMethod.GET)
	public void testLogger()throws Exception
	{
		//1.测试debug级别日志
		logger.debug("debug日志打印.");
		
		//2.测试info级别日志
		logger.info("info日志打印");
		
		//3.测试warn级别日志
		logger.warn("warn日志打印");
		
		//4.测试error级别日志
		logger.error("error日志打印.");
	}
}

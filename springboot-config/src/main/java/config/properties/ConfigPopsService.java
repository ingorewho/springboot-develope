/**
 * 
 */
package config.properties;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * @author ignore1992
 * 使用@Value注解默认读取application.properties配置文件中的配置信息
 */
@Component
@PropertySource(value="classpath:/application/my.properties")
public class ConfigPopsService
{
	@Value("${application.config.name}")
	private String name;
	@Value("${application.config.age}")
	private String age;
	@Value("${application.config.job}")
	private String job;
	
	private Logger logger = Logger.getLogger(ConfigPopsService.class);
	
	public void printProperties()
	{
		logger.info(String.format("config[name=%s, age=%s, job=%s]", name, age, job));
	}
}

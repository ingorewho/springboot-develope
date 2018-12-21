/**
 * 
 */
package config.yml;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * @author ignore1992
 *
 */
@Component
@PropertySource(value="classpath:/yml/my.yml")
public class ConfigYmlService
{
	@Value("${yml.config.name}")
	private String name;
	@Value("${yml.config.age}")
	private String age;
	@Value("${yml.config.job}")
	private String job;
	
	private Logger logger = Logger.getLogger(ConfigYmlService.class);
	
	public void printYml()
	{
		logger.info(String.format("yml-config[name=%s, age=%s, job=%s]", name, age, job));
	}
}

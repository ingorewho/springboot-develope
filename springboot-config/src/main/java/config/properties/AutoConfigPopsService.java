/**
 * 
 */
package config.properties;

import org.apache.log4j.Logger;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * @author ignore1992
 * 通过自动读取的方式读取配置文件中的配置项
 * 注：自定义配置文件中的配置项名称不要与默认配置文件中的配置项名称冲突，否则可能会导致读取默认配置文件的内容
 */
@Component
@PropertySource(value="classpath:/application/my.properties")
@ConfigurationProperties(prefix = "application.config")
public class AutoConfigPopsService
{
	private String name;
	private String age;
	private String job;
	private Logger logger = Logger.getLogger(AutoConfigPopsService.class);
	
	public void printProperties()
	{
		logger.info(String.format("auto-application-config[name=%s, age=%s, job=%s]", name, age, job));
	}
	/**
	 * @return the name
	 */
	public String getName()
	{
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name)
	{
		this.name = name;
	}
	/**
	 * @return the age
	 */
	public String getAge()
	{
		return age;
	}
	/**
	 * @param age the age to set
	 */
	public void setAge(String age)
	{
		this.age = age;
	}
	/**
	 * @return the job
	 */
	public String getJob()
	{
		return job;
	}
	/**
	 * @param job the job to set
	 */
	public void setJob(String job)
	{
		this.job = job;
	}
	
}

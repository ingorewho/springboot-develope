/**
 * 
 */
package config.yml;

import org.apache.log4j.Logger;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * @author ignore1992
 *
 */
@Component
@PropertySource(value="classpath:/yml/my.yml")
@ConfigurationProperties(prefix = "yml.config")
public class AutoConfigYmlService
{
	private String name;
	private String age;
	private String job;
	private Logger logger = Logger.getLogger(AutoConfigYmlService.class);
	
	public void printYml()
	{
		logger.info(String.format("auto-yml-config[name=%s, age=%s, job=%s]", name, age, job));
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

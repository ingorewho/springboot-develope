/**
 * 
 */
package yaml.config;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author ignore1992
 *
 */
@Component
@ConfigurationProperties(prefix  = "my")
public class YamlConfig
{
	private String name;
	
	private List<String> jobs = new ArrayList<String>();
	
	private List<Map<String, String>> ip = new ArrayList<Map<String, String>>();
	
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
	 * @return the jobs
	 */
	public List<String> getJobs()
	{
		return this.jobs;
	}

	/**
	 * @param jobs the jobs to set
	 */
	public void setJobs(List<String> jobs)
	{
		this.jobs = jobs;
	}

	/**
	 * @return the ip
	 */
	public List<Map<String, String>> getIp()
	{
		return ip;
	}

	/**
	 * @param ip the ip to set
	 */
	public void setIp(List<Map<String, String>> ip)
	{
		this.ip = ip;
	}

	
}

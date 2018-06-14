/**
 * 
 */
package thymeleaf.repository;

/**
 * @author ignore1992
 *
 */
public class ThymeleafBean
{
	private String name;
	
	private String description;
	
	private String application;

	public ThymeleafBean(String name, String description, String application)
	{
		this.name = name;
		this.description = description;
		this.application = application;
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
	 * @return the description
	 */
	public String getDescription()
	{
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description)
	{
		this.description = description;
	}

	/**
	 * @return the application
	 */
	public String getApplication()
	{
		return application;
	}

	/**
	 * @param application the application to set
	 */
	public void setApplication(String application)
	{
		this.application = application;
	}
	
}

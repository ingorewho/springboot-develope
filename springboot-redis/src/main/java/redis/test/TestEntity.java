/**
 * 
 */
package redis.test;

import java.io.Serializable;

/**
 * @author ignore1992
 *
 */
public class TestEntity implements Serializable
{
	private static final long serialVersionUID = -2596171633758973275L;

	private int id;
	
	private String name;

	/**
	 * @return the id
	 */
	public int getId()
	{
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id)
	{
		this.id = id;
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
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid()
	{
		return serialVersionUID;
	}
	
	@Override
	public String toString()
	{
		return String.format("Entity:[id=%d, name=%s]", id, name);
	}
}

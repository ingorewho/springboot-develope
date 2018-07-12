/**
 * 
 */
package com.mybatis.entity;

/**
 * @author ignore1992
 *
 */
public class Player
{
	private long id;
	
	private String name;

	/**
	 * @return the id
	 */
	public long getId()
	{
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(long id)
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
	
	@Override
	public String toString()
	{
		return String.format("Player[id=%s, name=%s]", id, name);
	}
}

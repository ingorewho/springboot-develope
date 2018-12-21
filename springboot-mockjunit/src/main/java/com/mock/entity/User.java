/**
 * 
 */
package com.mock.entity;

/**
 * @author ignore1992
 *
 */
public class User
{
	private String name;
	
	private int age;

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
	public int getAge()
	{
		return age;
	}

	/**
	 * @param age the age to set
	 */
	public void setAge(int age)
	{
		this.age = age;
	}
	
	@Override
	public String toString()
	{
		return String.format("User[name=%s, age=%d]", name, age);
	}
}

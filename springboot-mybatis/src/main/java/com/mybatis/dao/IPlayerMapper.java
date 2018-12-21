/**
 * 
 */
package com.mybatis.dao;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.mybatis.entity.Player;

/**
 * @author ignore1992
 *
 */
@Mapper
public interface IPlayerMapper
{
	@Insert("insert into player(id, name) values(#{id}, #{name})")
	public void addPlayer(Player aPlayer)throws Exception;
	
	@Select("select id, name from player where id=#{id}")
	public Player queryPlayer(@Param("id") long id)throws Exception;
	
	@Delete("delete from player where id=#{id}")
	public void deletePlayer(@Param("id") long id)throws Exception;
}

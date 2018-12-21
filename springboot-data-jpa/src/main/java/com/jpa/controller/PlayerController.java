/**
 * 
 */
package com.jpa.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.jpa.entity.Player;
import com.jpa.repository.PlayerRepository;

/**
 * @author ignore1992
 *
 */
@RestController
@RequestMapping(value = "player")
public class PlayerController
{
	Logger logger = Logger.getLogger(PlayerController.class);
	
	@Autowired
	private PlayerRepository playerRepository; 

	@RequestMapping(value = "add", method = RequestMethod.POST)
	public void addPlayer(@RequestBody Player aPlayer)
	{
		logger.info(String.format("添加一个Player, 参数Player=%s", aPlayer));
		
		playerRepository.save(aPlayer);
	}
	
	@RequestMapping(value = "query", method = RequestMethod.POST)
	public Player queryPlayer(long id)
	{
		logger.info(String.format("查询一个Player, 参数id=%s", id));
		
		Player aPlayer =  playerRepository.findOne(id);
		
		logger.info(String.format("查询到player=%s", aPlayer));
		
		return aPlayer;
	}
	
	@RequestMapping(value = "delete", method = RequestMethod.POST)
	public void deletePlayer(long id)
	{
		logger.info(String.format("删除一个Player, 参数id=%s", id));

		playerRepository.delete(id);
	}
	
}

/**
 * 
 */
package com.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jpa.entity.Player;

/**
 * @author ignore1992
 *
 */
public interface PlayerRepository extends JpaRepository<Player, Long> 
{

}

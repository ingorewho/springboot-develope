/**
 *
 */
package com.mybatis.test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.mybatis.PlayerApplication;
import com.mybatis.dao.IPlayerMapper;
import com.mybatis.entity.Player;

/**
 * @author ignore1992
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = PlayerApplication.class)
public class TestPlayer {
    Logger logger = LogManager.getLogger();

    @Autowired
    private IPlayerMapper playerMapper;

    @Test
    public void test() {
        //1.测试添加一个player
        try {
            Player aPlayer = new Player();
            aPlayer.setId(1);
            aPlayer.setName("ignore1992");
            playerMapper.addPlayer(aPlayer);
            logger.info("添加一个Player成功! ");
        } catch (Exception e) {
            logger.error("添加一个Player失败" , e);
        }

        //2.测试查询一个player
        try {
            Player aPlayer = playerMapper.queryPlayer(1);
            logger.info(String.format("查询到一个Player: %s" , aPlayer));
        } catch (Exception e) {
            logger.error("查询一个Player失败" , e);
        }

        //3.测试删除一个player
        try {
            playerMapper.deletePlayer(1);
            logger.info("删除一个Player成功! ");
        } catch (Exception e) {
            logger.error("删除一个Player失败" , e);
        }
    }
}

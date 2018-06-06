/**
 * 
 */
package redis.test;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import redis.service.RedisServiceImpl;

/**
 * @author ignore1992
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TestRedisService
{
	private Logger logger = Logger.getLogger(TestRedisService.class);
	
	@Autowired
	private RedisServiceImpl redisService;
	
	@Test
	public void testPutGet()
	{
		String key = "test-key";
		String value = "test-value";
		try
		{
			logger.info(String.format("向redis中添加数据: key=%s, value=%s", key, value));
			redisService.put(key, value);
			
			Object result = redisService.get(key);
			logger.info(String.format("从redis中获取数据: key=%s, value=%s", key, result));
		} 
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}

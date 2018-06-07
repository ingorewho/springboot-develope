/**
 * 
 */
package redis.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

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
		
		try
		{
			//1.测试实体对象存放和获取
			String key = "test-key";
			TestEntity entity = new TestEntity();
			entity.setId(1);
			entity.setName("test-name");
			logger.info(String.format("向redis中添加实体对象数据: key=%s, value=%s", key, entity));
			redisService.putEntity(key, entity);
			TestEntity result = (TestEntity)redisService.getEntity(key);
			logger.info(String.format("从redis中获取实体对象数据: key=%s, value=%s", key, result));
			
			//2.测试集合数据存放和获取
			String key1 = "test-key1";
			Set<String> sets = new HashSet<String>();
			sets.add("test-value1");
			sets.add("test-value2");
			logger.info(String.format("向redis中添加集合数据: key=%s, value=%s", key1, sets));
			redisService.putSet(key1, sets);
			Set<String> result1 = redisService.getSets(key1);
			logger.info(String.format("从redis中获取集合数据: key=%s, value=%s", key1, result1));
			
			//3.测试列表数据存放和获取
			String key2 = "test-key2";
			List<String> lists = new ArrayList<String>();
			lists.add("test-value1");
			lists.add("test-value2");
			logger.info(String.format("向redis中添加列表数据: key=%s, value=%s", key2, lists));
			redisService.putList(key2, lists);
			List<String> result2 = redisService.getLists(key2);
			logger.info(String.format("从redis中获取列表数据: key=%s, value=%s", key2, result2));
			
			//4.测试map数据的存放和获取
			String key3 = "test-key3";
			Map<String, String> map = new HashMap<String, String>();
			map.put("test1", "value1");
			map.put("test2", "value2");
			logger.info(String.format("向redis中添加map数据: key=%s, value=%s", key3, lists));
			redisService.putHash(key3, map);
			HashMap<String, String> result3 = redisService.getHashs(key3);
			logger.info(String.format("从redis中获取map数据: key=%s, value=%s", key3, result3));
		} 
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}

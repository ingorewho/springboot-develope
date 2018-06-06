/**
 * 
 */
package redis.service;

import java.io.Serializable;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

/**
 * @author ignore1992
 *
 */
@Component
public class RedisServiceImpl
{
	private Logger logger = Logger.getLogger(RedisServiceImpl.class);
	
	@Autowired
	private RedisTemplate redisTemplate;
	
	/**
	 * 获取数据
	 * @param key .
	 * @param value .
	 * @throws Exception .
	 */
	public void put(String key, Object value) throws Exception
	{
		try
		{
			ValueOperations<Serializable, Object> operations = redisTemplate.opsForValue();
			operations.set(key, value);
		}
		catch(Exception e)
		{
			logger.error(String.format("存放数据到redis异常: key=%s, value=%s", key, value), e);
		}
	}
	
	/**
	 * 存放数据，可设置有效期
	 * @param key .
	 * @param value .
	 * @param expireTime .
	 * @throws Exception .
	 */
	public void put(String key, Object value, long expireTime) throws Exception
	{
		try
		{
			ValueOperations<Serializable, Object> operations = redisTemplate.opsForValue();
			operations.set(key, value);
			redisTemplate.expire(key, 1, TimeUnit.MINUTES);
		}
		catch(Exception e)
		{
			logger.error(String.format("存放数据到redis异常: key=%s, value=%s, expireTime=%s", key, value, expireTime), e);
		}
	}
	
	/**
	 * 存放数据
	 * @param key .
	 * @return .
	 * @throws Exception .
	 */
	public Object get(String key) throws Exception
	{
		if(StringUtils.isEmpty(key))
		{
			return null;
		}
		
		ValueOperations<Serializable, Object> operations = redisTemplate.opsForValue();
		Object result = operations.get(key);
		return result;
	}
}

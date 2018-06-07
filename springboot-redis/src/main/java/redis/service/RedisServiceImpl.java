/**
 * 
 */
package redis.service;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.SetOperations;
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
	 * 存放实体对象：实体对象一定要实现序列化接口
	 * @param key .
	 * @param value .
	 * @throws Exception .
	 */
	public void putEntity(String key, Object value) throws Exception
	{
		if(StringUtils.isEmpty(key))
		{
			return;
		}
		ValueOperations<Serializable, Object> operations = redisTemplate.opsForValue();
		operations.set(key, value);
	}
	
	/**
	 * 存放实体对象，可设置有效期
	 * @param key .
	 * @param value .
	 * @param expireTime .
	 * @throws Exception .
	 */
	public void put(String key, Object value, long expireTime) throws Exception
	{
		if(StringUtils.isEmpty(key))
		{
			return;
		}
		ValueOperations<Serializable, Object> operations = redisTemplate.opsForValue();
		operations.set(key, value);
		redisTemplate.expire(key, 1, TimeUnit.MINUTES);
	}
	
	/**
	 * 存放集合数据
	 * @param key .
	 * @param values .
	 * @throws Exception .
	 */
	public void putSet(String key, Set<String> values)throws Exception
	{
		if(StringUtils.isEmpty(key) || values == null || values.isEmpty())
		{
			return;
		}
		
		SetOperations setOps = redisTemplate.opsForSet();
		
		setOps.add(key, values);
	}
	
	/**
	 * 存放列表数据
	 * @param key .
	 * @param values .
	 * @throws Exception .
	 */
	public void putList(String key, List<String> values)throws Exception
	{
		if(StringUtils.isEmpty(key) || values == null || values.isEmpty())
		{
			return;
		}
		
		ListOperations listOps = redisTemplate.opsForList();
		
		listOps.leftPush(key, values);
		
		//or listOps.rightPush(key, values);
	}
	
	/**
	 * 存放map数据
	 * @param key .
	 * @param values .
	 * @throws Exception .
	 */
	public void putHash(String key, Map<String, String> values)throws Exception
	{
		if(StringUtils.isEmpty(key) || values == null || values.isEmpty())
		{
			return;
		}
		
		HashOperations hashOps = redisTemplate.opsForHash();
		
		hashOps.putAll(key, values);
	}
	
	/**
	 * 删除数据
	 * @param key .
	 * @return .
	 * @throws Exception .
	 */
	public boolean delete(String key)throws Exception
	{
		if(StringUtils.isEmpty(key))
		{
			return false;
		}
		
		redisTemplate.delete(key);
		
		return true;
	}
	
	/**
	 * 获取实体对象
	 * @param key .
	 * @return .
	 * @throws Exception .
	 */
	public Object getEntity(String key) throws Exception
	{
		if(StringUtils.isEmpty(key))
		{
			return null;
		}
		
		ValueOperations<Serializable, Object> operations = redisTemplate.opsForValue();
		Object result = operations.get(key);
		return result;
	}
	
	/**
	 * 获取集合数据
	 * @param key .
	 * @return .
	 * @throws Exception .
	 */
	public Set<String> getSets(String key)throws Exception
	{
		if(StringUtils.isEmpty(key))
		{
			return null;
		}
		
		SetOperations setOps = redisTemplate.opsForSet();
		
		return setOps.members(key);
	}
	
	/**
	 * 获取列表数据
	 * @param key .
	 * @return .
	 * @throws Exception .
	 */
	public List<String> getLists(String key)throws Exception
	{
		if(StringUtils.isEmpty(key))
		{
			return null;
		}
		
		ListOperations listOps = redisTemplate.opsForList();
		
		return (List<String>) listOps.leftPop(key);
	}
	
	/**
	 * 获取map数据
	 * @param key .
	 * @return .
	 * @throws Exception .
	 */
	public HashMap<String, String> getHashs(String key)throws Exception
	{
		if(StringUtils.isEmpty(key))
		{
			return null;
		}
		
		HashOperations hashOps = redisTemplate.opsForHash();
		
		return (HashMap<String, String>) hashOps.entries(key);
	}
	
}

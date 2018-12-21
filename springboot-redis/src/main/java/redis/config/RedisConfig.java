/**
 * 
 */
package redis.config;

import java.lang.reflect.Method;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;


/**
 * @author ignore1992
 *
 */
@Configuration
@EnableCaching
public class RedisConfig extends CachingConfigurerSupport
{
	//缓存管理
    @Bean  
    public CacheManager cacheManager(RedisTemplate redisTemplate) {  
        RedisCacheManager cacheManager = new RedisCacheManager(redisTemplate);  
        //设置缓存过期时间  
        cacheManager.setDefaultExpiration(600);  
        return cacheManager;  
    }  
  
    @Bean  
    public RedisTemplate<String, String> redisTemplate(RedisConnectionFactory factory){  
        StringRedisTemplate template = new StringRedisTemplate(factory);  
        setSerializer(template);
        template.afterPropertiesSet();  
        return template;  
    }  
  
    private void setSerializer(StringRedisTemplate template){  
        //使用Jackson2JsonRedisSerializer来序列化和反序列化redis的value  
        Jackson2JsonRedisSerializer jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer(Object.class);  
        ObjectMapper om = new ObjectMapper();  
        om.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);  
        om.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);  
        jackson2JsonRedisSerializer.setObjectMapper(om);  
        template.setValueSerializer(jackson2JsonRedisSerializer);  
        template.afterPropertiesSet();  
    }  
  
    //自定义缓存key生成策略  
    @Bean  
    public KeyGenerator keyGenerator() {  
        return new KeyGenerator() {  
            public Object generate(Object target, Method method, Object... params)
            {
            	StringBuffer sb = new StringBuffer();  
                sb.append(target.getClass().getName());  
                sb.append(method.getName());  
                for (Object obj : params) {  
                    sb.append(obj.toString());  
                }  
                return sb.toString();  
            }
        };  
    }  
}

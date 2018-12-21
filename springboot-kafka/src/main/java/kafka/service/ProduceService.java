/**
 * 
 */
package kafka.service;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

/**
 * @author ignore1992
 *
 */
@Component
public class ProduceService
{
	private Logger logger = Logger.getLogger(ProduceService.class);
	
	@Autowired
	private KafkaTemplate kafkaTemplate;
	
	public void produce(String topic, String key, String value) throws Exception
	{
		logger.info(String.format("生产者服务发送消息:topic=%s,key=%s,value=%s", topic, key, value));
		kafkaTemplate.send(topic, key, value);
	}
}

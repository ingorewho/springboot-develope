/**
 * 
 */
package kafka.service;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.log4j.Logger;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.KafkaListeners;
import org.springframework.stereotype.Component;

/**
 * @author ignore1992
 *
 */
@Component
public class CusumerService
{
	private Logger logger = Logger.getLogger(CusumerService.class);
	
	@KafkaListeners( value ={ @KafkaListener(topics = {"test-topic"}),  @KafkaListener(topics = {"test-topic1"})})
	public void consumer(ConsumerRecord<?, ?> record)
	{
		logger.info(String.format("消费者服务收到消息:topic=%s,key=%s,value=%s", record.topic(), record.key(), record.value()));
		
		//处理具体业务逻辑
	}
}

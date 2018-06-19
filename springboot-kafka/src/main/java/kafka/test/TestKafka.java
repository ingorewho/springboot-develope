/**
 * 
 */
package kafka.test;

import kafka.service.ProduceService;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


/**
 * @author ignore1992
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TestKafka
{
	@Autowired
	private ProduceService producer;
	
	@Test
	public void test()
	{
		String topic = "test-topic";
		String key = "test-key";
		String value = "test-value";
		try
		{
			producer.produce(topic, key, value);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}

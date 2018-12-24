/**
 * 
 */
package yaml.test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import yaml.config.YamlConfig;

/**
 * @author ignore1992
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TestYaml
{
	private Logger logger = LogManager.getLogger();
	
	@Autowired
	private YamlConfig config;
	
	@Test
	public void test()
	{
		logger.info(config.getName() + "," + config.getJobs() + "," + config.getIp());
	}
}

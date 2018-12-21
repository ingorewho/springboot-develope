/**
 * 
 */
package config.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import config.properties.AutoConfigPopsService;
import config.properties.ConfigPopsService;
import config.yml.AutoConfigYmlService;
import config.yml.ConfigYmlService;

/**
 * @author ignore1992
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TestConfig
{
	@Autowired
	private ConfigPopsService configService;
	
	@Autowired
	private AutoConfigPopsService autoConfigService;
	
	@Autowired
	private ConfigYmlService configYmlService;
	
	@Autowired
	private AutoConfigYmlService autoConfigYmlService;
	
	@Test
	public void test()
	{
		//1.测试通过@Value注解实现的properties配置文件的读取
		configService.printProperties();
		//2.测试通过自动读取的方式实现的properties配置文件的读取
		autoConfigService.printProperties();
		//3.测试通过@Value注解实现的yml配置文件的读取
		configYmlService.printYml();
		//4.测试通过自动读取的方式实现的yml配置文件的读取
		autoConfigYmlService.printYml();
	}
}

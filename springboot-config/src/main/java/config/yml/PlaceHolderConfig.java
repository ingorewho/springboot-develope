/**
 * 
 */
package config.yml;

import org.springframework.beans.factory.config.YamlPropertiesFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.FileSystemResource;

/**
 * @author ignore1992
 *  1.springboot1.5x之后的版本，ConfigurationProperties注解的locations属性没有了，无法通过该方式来加载自定义配置文件
 *  2.PropertySource注解只支持yml文件加载，但不能将配置信息暴露给spring environment
 *  3.通过自定义PropertySourcesPlaceholderConfigurer解决上述问题
 */
@Configuration
public class PlaceHolderConfig
{
	@Bean  
    public static PropertySourcesPlaceholderConfigurer properties() 
	{  
        PropertySourcesPlaceholderConfigurer configurer = new PropertySourcesPlaceholderConfigurer();  
        YamlPropertiesFactoryBean yaml = new YamlPropertiesFactoryBean();  
        //引入自定义的yml配置文件，暴露给spring environment
        yaml.setResources(new FileSystemResource("src/main/resources/yml/my.yml"));
        configurer.setProperties(yaml.getObject());  
        return configurer;  
    }  
}

package com.ignore;

import com.ignore.filter.PackageTypeFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;

/**
 * @Author: ignore1992
 * @Description: 自定义扫描包的规则
 * @Date: Created In 12:21 2018/12/24
 */
@SpringBootApplication
@ComponentScan(value = "com.ignore", excludeFilters = {@ComponentScan.Filter(type = FilterType.CUSTOM, value = PackageTypeFilter.class)})
public class PackageFilterApplication {
    public static void main(String[] args)
    {
         SpringApplication.run(PackageFilterApplication.class, args);
    }
}

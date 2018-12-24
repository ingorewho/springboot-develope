package com.ignore.filter;

import org.springframework.core.io.Resource;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.core.type.filter.TypeFilter;

import java.io.IOException;
import java.net.URI;

/**
 * @Author: ignore1992
 * @Description: 自己实现TypeFilter接口，用于按照自己的方式来过滤扫描包
 * @Date: Created In 12:33 2018/12/24
 */
public class PackageTypeFilter implements TypeFilter {
    @Override
    public boolean match(MetadataReader metadataReader , MetadataReaderFactory metadataReaderFactory) throws IOException {
        //可以自行扩展
        Resource resource = metadataReader.getResource();
        URI uri = resource.getURI();
        if (uri.getPath().indexOf("com.ignore.test") != -1){
            return true;
        }
        return false;
    }
}

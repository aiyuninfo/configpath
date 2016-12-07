package com.aiyun.config.path;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class VirtualPathConfiguration extends WebMvcConfigurerAdapter {

    /**
     * 本地文件夹路径或者resource文件夹路径比如 D:/abc/ (注：D:/abc/最后一个/必须存在)，或者static,此处的static文件夹必须在resource文件夹下
     */
    @Value("${upload.path}")
    private String uploadPath;

    /**
     * 映射的路径比如 web，此时本地文件夹可以使用这个映射来直接访问文件
     */
    @Value("${vm.resource.path}")
    private String resourceHandler;

    /**
     * 映射类型，如果是本地文件夹绝对路径，type为 file ,resource文件夹内的，type 为classpath
     */
    @Value("${vm.resource.type}")
    private String type;

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/" + resourceHandler + "/**")
                .addResourceLocations(type + ":" + uploadPath);
        super.addResourceHandlers(registry);
    }
}

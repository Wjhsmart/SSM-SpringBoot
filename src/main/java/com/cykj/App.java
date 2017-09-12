package com.cykj;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.ArrayList;
import java.util.List;
/**
 * 在这里我们我们使用@SpringBootApplication, 指定这是一个SpringBoot应用启动程序
 * Created by Administrator on 2017-06-13.
 */
@SpringBootApplication
@EnableConfigurationProperties
@ComponentScan(basePackages = { "com.cykj"})
@MapperScan(basePackages = "com.cykj.mapper")
public class App extends WebMvcConfigurerAdapter {

    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        super.configureMessageConverters(converters);

        /**
         * 1、需要定义一个 converter 转换消息的对象；
         * 2、添加 fastJson 的配置信息，比如：是否需要格式化返回的json数据；
         * 3、设置 fastJson 返回的编码格式，防止中文乱码
         * 4、在 converter 中设置配置信息
         * 5、讲 converter 添加到 converters 集合当中
         */
        // 1、需要定义一个 converter 转换消息的对象；
        FastJsonHttpMessageConverter converter = new FastJsonHttpMessageConverter();
        // 2、添加 fastJson 的配置信息，比如：是否需要格式化返回的json数据
        FastJsonConfig config = new FastJsonConfig();
        config.setSerializerFeatures(SerializerFeature.PrettyFormat);
        // 3、设置 fastJson 返回的编码格式，防止中文乱码
        List<MediaType> mediaTypes = new ArrayList<MediaType>();
        mediaTypes.add(MediaType.APPLICATION_JSON_UTF8);
        converter.setSupportedMediaTypes(mediaTypes);
        // 4、在 converter 中设置配置信息
        converter.setFastJsonConfig(config);
        // 5、讲 converter 添加到 converters 集合当中
        converters.add(converter);
    }

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
}
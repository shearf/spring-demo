package com.shearf.demo.spring.config;

import com.google.common.collect.Lists;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.nio.charset.Charset;
import java.util.List;

/**
 * Created by xiahaihu on 17/4/24.
 */
@Configuration
@ComponentScan(value = "com.shearf.demo.spring.web")
@EnableWebMvc
public class WebConfig extends WebMvcConfigurerAdapter {

    @Bean
    public Charset utf8Charset() {
        return Charset.forName("UTF-8");
    }

    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        converters.add(mappingJackson2HttpMessageConverter());
    }

    @Bean
    public MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter() {
        MappingJackson2HttpMessageConverter messageConverter = new MappingJackson2HttpMessageConverter();
        messageConverter.setDefaultCharset(utf8Charset());
        messageConverter.setSupportedMediaTypes(Lists.newArrayList(
                MediaType.APPLICATION_JSON
        ));
        return new MappingJackson2HttpMessageConverter();
    }
}

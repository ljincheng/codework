package cn.booktable.service.webadmin.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 *  Web配置
 * @author ljc
 */
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    /**
     * 添加静态资源--过滤swagger-api (开源的在线API文档)
     * @param registry
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/res/**").addResourceLocations("classpath:/res/");
//        registry.addResourceHandler("/views/**").addResourceLocations("classpath:/views/");
    }

    /**
     * 跨域支持
     * @param registry
     */
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("*")
                .allowCredentials(true)
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
                .maxAge(3600 * 24);
    }

    /**
     * 配置消息转换器--这里我用的是alibaba 开源的 fastjson
     * @param converters
     */
//    @Override
//    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
//        converters.add(new ByteArrayHttpMessageConverter());
//        converters.add(new StringHttpMessageConverter());
//        converters.add(new ResourceHttpMessageConverter());
//        converters.add(new AllEncompassingFormHttpMessageConverter());
//        converters.add(new StringHttpMessageConverter());
//        converters.add(jackson2HttpMessageConverter());
//    }

//    @Bean
//    public MappingJackson2HttpMessageConverter jackson2HttpMessageConverter() {
//        MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
//        ObjectMapper mapper = new ObjectMapper();
//
//        //日期格式转换
//        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
//        mapper.setDateFormat(new SimpleDateFormat(DateUtils.DATE_TIME_PATTERN));
//        mapper.setTimeZone(TimeZone.getTimeZone("GMT+8"));
//
//        //Long类型转String类型
//        SimpleModule simpleModule = new SimpleModule();
//        simpleModule.addSerializer(Long.class, ToStringSerializer.instance);
//        simpleModule.addSerializer(Long.TYPE, ToStringSerializer.instance);
//        mapper.registerModule(simpleModule);
//
//        converter.setObjectMapper(mapper);
//        return converter;
//    }



}
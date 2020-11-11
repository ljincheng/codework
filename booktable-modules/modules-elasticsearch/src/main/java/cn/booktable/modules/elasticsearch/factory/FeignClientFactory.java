package cn.booktable.modules.elasticsearch.factory;


import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import feign.Feign;
import feign.Logger;
import feign.Response;
import feign.codec.Decoder;
import feign.codec.Encoder;
import feign.codec.ErrorDecoder;
import feign.form.FormEncoder;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.cloud.openfeign.support.ResponseEntityDecoder;
import org.springframework.cloud.openfeign.support.SpringDecoder;
import org.springframework.cloud.openfeign.support.SpringEncoder;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;

import java.io.IOException;

/**
 * FeignClient制造工厂
 * @author ljc
 */
public class FeignClientFactory {
    private static org.slf4j.Logger logger= LoggerFactory.getLogger(FeignClientFactory.class);

    public static Decoder jacksonDecoder() {
        HttpMessageConverter jacksonConverter = new MappingJackson2HttpMessageConverter(customObjectMapper());
        ObjectFactory<HttpMessageConverters> objectFactory = () -> new HttpMessageConverters(jacksonConverter);
        return new ResponseEntityDecoder(new SpringDecoder(objectFactory));
    }
    public static Encoder jacksonEncoder(){
        HttpMessageConverter jacksonConverter = new MappingJackson2HttpMessageConverter(customObjectMapper());
        ObjectFactory<HttpMessageConverters> objectFactory = () -> new HttpMessageConverters(jacksonConverter);
        return new SpringEncoder(objectFactory);
    }



    private static ObjectMapper customObjectMapper(){
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT, true);
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        objectMapper.setPropertyNamingStrategy(PropertyNamingStrategy.CAMEL_CASE_TO_LOWER_CASE_WITH_UNDERSCORES);
        return objectMapper;
    }

    static class FeishuClientError extends RuntimeException {
        private String message; // parsed from json

        @Override
        public String getMessage() {
            return message;
        }
    }


    static class FeishuErrorDecoder implements ErrorDecoder {

        final Decoder decoder;
        final ErrorDecoder defaultDecoder = new ErrorDecoder.Default();

        FeishuErrorDecoder(Decoder decoder) {
            this.decoder = decoder;
        }

        @Override
        public Exception decode(String methodKey, Response response) {
            try {
                response = response.toBuilder().status(200).build();
                return (Exception) decoder.decode(response, FeishuClientError.class);
            } catch (final IOException fallbackToDefault) {
                return defaultDecoder.decode(methodKey, response);
            }
        }
    }

    public  <T> T target(Class<T> apiType, String url)
    {
        Decoder decoder =jacksonDecoder();
        Encoder encoder=jacksonEncoder();
        return Feign.builder()
                .encoder(encoder)
                .decoder(decoder)
                .errorDecoder(new FeishuErrorDecoder(decoder))
                .logger(new Logger.ErrorLogger())
                .logLevel(Logger.Level.FULL)
                .requestInterceptor(template -> {
                    template.header(
                            "Content-Type",
                            "application/json; charset=utf8");
                })
                .target(apiType, url);
    }

    public  <T> T formTarget(Class<T> apiType, String url)
    {
        Decoder decoder =jacksonDecoder();
        Encoder encoder=new FormEncoder();
        return Feign.builder()
                .encoder(encoder)
                .decoder(decoder)
                .errorDecoder(new FeishuErrorDecoder(decoder))
                .logger(new Logger.ErrorLogger())
                .logLevel(Logger.Level.FULL)
                .target(apiType, url);
    }


}

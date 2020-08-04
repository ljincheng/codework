package cn.booktable.core.redis;

import cn.booktable.core.util.SerializeUtils;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import java.io.Serializable;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class RedisManager {

    private RedisTemplate redisTemplate;

    private String group;

    public RedisManager(RedisTemplate redisTemplate,String group)
    {
        this.redisTemplate=redisTemplate;
        if(redisTemplate!=null)
        {
            redisTemplate.setDefaultSerializer(new RedisObjectSerializer());
            redisTemplate.setKeySerializer(new StringRedisSerializer());
            redisTemplate.setValueSerializer(new RedisObjectSerializer());
            this.group=group;
        }
    }


    public Object get(Object key){
        Object redisVal= redisTemplate.opsForValue().get(key);
        return redisVal;
    }

    public Object set(Object key,Object value,long expire){

        redisTemplate.opsForValue().set(key,value,expire, TimeUnit.MILLISECONDS);
        return value;
    }

    public Object set(Object key,Object value){

        redisTemplate.opsForValue().set(key,value);
        return value;
    }


    public void delete(Object key){
        redisTemplate.delete(key);
    }

    public void clear(String keyPrefix){

        redisTemplate.delete(keys(keyPrefix));
    }

    /**
     * size
     */
    public int size(String keyPrefix){
        return keys(keyPrefix).size();
    }

    public Set<Object> keys(String pattern){
        Set<Object> keys = null;
        return redisTemplate.keys(pattern);

    }


    /**
     * 获取字符串KEY
     * @param sessionId
     * @return
     */
    public String getGroupKey(Serializable sessionId){
        String preKey =""+ this.group + sessionId;
        return preKey;
    }
}

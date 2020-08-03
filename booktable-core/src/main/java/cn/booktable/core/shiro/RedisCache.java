package cn.booktable.core.shiro;



import cn.booktable.core.redis.RedisManager;
import cn.booktable.core.util.SerializeUtils;
import com.alibaba.fastjson.JSONObject;
import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheException;
import org.apache.shiro.util.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;

import java.util.*;

/**
 * Shiro的Redis缓存实现
 * @author ljc
 * @version 1.0
 * @param <K>
 * @param <V>
 */
public class RedisCache<K, V> implements Cache<K, V> {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * The wrapped Jedis instance.
     */
    private RedisManager cache;

    /**
     * The Redis key prefix for the sessions
     */
    private String keyPrefix = "jctp_shiro_session:";

    private long expire=60000;

    /**
     * Returns the Redis session keys
     * prefix.
     * @return The prefix
     */
    public String getKeyPrefix() {
        return keyPrefix;
    }

    /**
     * Sets the Redis sessions key
     * prefix.
     * @param keyPrefix The prefix
     */
    public void setKeyPrefix(String keyPrefix) {
        this.keyPrefix = keyPrefix;
    }

    /**
     * 通过一个JedisManager实例构造RedisCache
     */
    public RedisCache(RedisManager cache,long timeout){
        if (cache == null) {
            throw new IllegalArgumentException("Cache argument cannot be null.");
        }
        this.cache = cache;
        this.expire=timeout;
    }

    /**
     * Constructs a cache instance with the specified
     * Redis manager and using a custom key prefix.
     * @param cache The cache manager instance
     * @param prefix The Redis key prefix
     */
    public RedisCache(RedisManager cache,
                      String prefix,long timeout){

        this( cache,timeout );
        // set the prefix
        this.keyPrefix = prefix;
    }

    /**
     * 获得byte[]型的key
     * @param key
     * @return
     */
//    private byte[] getByteKey(K key){
//        if(key instanceof String){
//            String preKey = this.keyPrefix + key;
//            return preKey.getBytes();
//        }else if(key instanceof Integer)
//        {
//            String preKey = this.keyPrefix + key;
//            return preKey.getBytes();
//        }else if(key instanceof Long)
//        {
//            String preKey = this.keyPrefix + key;
//            return preKey.getBytes();
//        }
//        else{
//            return SerializeUtils.serialize(key);
//        }
//    }

    private String getStringKey(K key){
        String preKey= this.keyPrefix ;
        if(key instanceof String){
             preKey = this.keyPrefix + key;

        }else if(key instanceof Integer)
        {
             preKey = this.keyPrefix + key;
        }else if(key instanceof Long)
        {
            preKey = this.keyPrefix + key;
        }else if(key instanceof Character || key instanceof CharSequence )
        {
            preKey= this.keyPrefix+key;
        }
        else{
            String jsonKey= JSONObject.toJSONString(key);
            preKey= String.valueOf( SerializeUtils.serialize(this.keyPrefix+jsonKey));
        }
        String redisKey= this.cache.getGroupKey(preKey);
        return redisKey;
    }


    @Override
    public V get(K key) throws CacheException {
        logger.debug("根据key从Redis中获取对象 key [" + key + "]");
        try {
            if (key == null) {
                return null;
            }else{
                Object rawValue = cache.get(getStringKey(key));

                if(rawValue!=null) {
                    @SuppressWarnings("unchecked")
                    V value = (V)rawValue;
                    return value;
                }
            }
        } catch (Throwable t) {
            throw new CacheException(t);
        }
        return null;
    }

    @Override
    public V put(K key, V value) throws CacheException {
        logger.debug("根据key从存储 key [" + key + "]");
        try {
//            byte[] bytesValue= SerializeUtils.serialize(value);
            cache.set(getStringKey(key), value,expire);
            return value;
        } catch (Throwable t) {
            throw new CacheException(t);
        }
    }

    @Override
    public V remove(K key) throws CacheException {
        logger.debug("从redis中删除 key [" + key + "]");
        try {
            V previous = get(key);
            cache.delete(getStringKey(key));
            return previous;
        } catch (Throwable t) {
            throw new CacheException(t);
        }
    }

    @Override
    public void clear() throws CacheException {
        logger.debug("从redis中删除所有元素");
        try {
            cache.clear(this.keyPrefix+"*");
        } catch (Throwable t) {
            throw new CacheException(t);
        }
    }

    @Override
    public int size() {
        try {
            Long longSize = new Long(cache.size(this.keyPrefix+"*"));
            return longSize.intValue();
        } catch (Throwable t) {
            throw new CacheException(t);
        }
    }

    @SuppressWarnings("unchecked")
    @Override
    public Set<K> keys() {
        try {
            Set<Object> keys = cache.keys(this.keyPrefix + "*");
            if (CollectionUtils.isEmpty(keys)) {
                return Collections.emptySet();
            }else{
                Set<K> newKeys = new HashSet<>();
                for(Object key:keys){
                    newKeys.add((K)key);
                }
                return newKeys;
            }
        } catch (Throwable t) {
            throw new CacheException(t);
        }
    }

    @Override
    public Collection<V> values() {
        try {
            Set<Object> keys = cache.keys(this.keyPrefix + "*");
            if (!CollectionUtils.isEmpty(keys)) {
                List<V> values = new ArrayList<V>(keys.size());
                for (Object key : keys) {
                    @SuppressWarnings("unchecked")
                    V value = get((K)key);
                    if (value != null) {
                        values.add(value);
                    }
                }
                return Collections.unmodifiableList(values);
            } else {
                return Collections.emptyList();
            }
        } catch (Throwable t) {
            throw new CacheException(t);
        }
    }

    public long getExpire() {
        return expire;
    }

    public void setExpire(long expire) {
        this.expire = expire;
    }
}

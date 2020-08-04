package cn.booktable.core.shiro;

import cn.booktable.core.redis.RedisManager;
import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheException;
import org.apache.shiro.cache.CacheManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class RedisCacheManager implements CacheManager {

    private static final Logger logger = LoggerFactory.getLogger(RedisCacheManager.class);

    // fast lookup by name map
    private final ConcurrentMap<String, Cache> caches = new ConcurrentHashMap<>();
    public static final String DEFAULT_PRINCIPAL_ID_FIELD_NAME = "authCacheKey or id";
    private String principalIdFieldName = DEFAULT_PRINCIPAL_ID_FIELD_NAME;

    private RedisManager redisManager;
    private long timeout;

    /**
     * The Redis key prefix for caches
     */
    private String keyPrefix =  "[shiro_cache]";

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


    public RedisCacheManager(RedisManager redisManager,long timeout)
    {
        this.redisManager=redisManager;
        this.timeout=timeout;
    }

    public RedisCacheManager(RedisManager redisManager,String keyPrefix)
    {
        this.redisManager=redisManager;
        this.keyPrefix=keyPrefix;
    }

    @Override
    public <K, V> Cache<K, V> getCache(String name) throws CacheException {
        logger.debug("获取名称为: " + name + " 的RedisCache实例");

        Cache c = caches.get(name);

        if (c == null) {

            // create a new cache instance
            c = new RedisCache<K, V>(redisManager, keyPrefix,timeout);

            // add it to the cache collection
            caches.put(name, c);
        }
        return c;
    }



}

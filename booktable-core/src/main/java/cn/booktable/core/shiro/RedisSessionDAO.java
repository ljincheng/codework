package cn.booktable.core.shiro;
import java.io.Serializable;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import cn.booktable.core.redis.RedisManager;
import cn.booktable.core.util.SerializeUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.session.UnknownSessionException;
import org.apache.shiro.session.mgt.eis.AbstractSessionDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class RedisSessionDAO extends AbstractSessionDAO {

    private static Logger logger = LoggerFactory.getLogger(RedisSessionDAO.class);
    /**
     * shiro-redis的session对象前缀
     */
    private RedisManager redisManager;

    /**
     * The Redis key prefix for the sessions
     */
    private String keyPrefix = "[shiro_session]";
    private String group;//组名
    private long timeout=3600000;

    public RedisSessionDAO(RedisManager redisManager)
    {
        this.redisManager=redisManager;

    }

    public RedisSessionDAO(RedisManager redisManager,String keyPrefix)
    {
        this.redisManager=redisManager;
        this.keyPrefix=keyPrefix;
    }

    @Override
    public void update(Session session) throws UnknownSessionException {
        this.saveSession(session);
    }

    /**
     * save session
     * @param session
     * @throws UnknownSessionException
     */
    private void saveSession(Session session) throws UnknownSessionException{
        if(session == null || session.getId() == null || redisManager== null ){
            logger.error("session or session id is null");
            return;
        }
        String key = getStringKey(session.getId());
        long expire= session.getTimeout();
        session.setTimeout(timeout);
        this.redisManager.set(key, session,timeout);
    }

    @Override
    public void delete(Session session) {
        if(session == null || session.getId() == null ){
            logger.error("session or session id is null");
            return;
        }
        redisManager.delete(this.getStringKey(session.getId()));

    }

    @Override
    public Collection<Session> getActiveSessions() {
        Set<Session> sessions = new HashSet<Session>();

        Set<Object> keys = redisManager.keys(this.keyPrefix + "*");
        if(keys != null && keys.size()>0){
            for(Object key:keys){
                Object redisValue=redisManager.get(key);
                if(redisValue!=null)
                {
                    sessions.add((Session)redisValue);
                }
            }
        }

        return sessions;
    }

    @Override
    protected Serializable doCreate(Session session) {
        Serializable sessionId = this.generateSessionId(session);
        this.assignSessionId(session, sessionId);
        this.saveSession(session);
        return sessionId;
    }

    @Override
    protected Session doReadSession(Serializable sessionId) {
        if(sessionId == null ){
            logger.error("session id is null");
            return null;
        }
        Object redisValue=redisManager.get(this.getStringKey(sessionId));
        if(redisValue!=null)
        {
            return (Session) redisValue;
        }
        return null;
    }


    private String getStringKey(Serializable sessionId){
        String preKey = this.keyPrefix + sessionId;
        return this.redisManager.getGroupKey(preKey);
    }


    public RedisManager getRedisManager() {
        return redisManager;
    }

    public void setRedisManager(RedisManager redisManager) {
        this.redisManager = redisManager;
    }

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

    public long getTimeout() {
        return timeout;
    }

    public void setTimeout(long timeout) {
        this.timeout = timeout;
    }
}

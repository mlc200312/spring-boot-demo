package com.springboot.util.redis.impl;

import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.util.CollectionUtils;

import com.springboot.util.redis.RedisSupport;

public abstract class RedisSupportImpl<T> implements RedisSupport<T> {

	private RedisTemplate<String, T> redisTemplate;

	protected final void setRedisTemplate(RedisTemplate<String, T> redisTemplate) {
		if (this.redisTemplate == null || this.redisTemplate != redisTemplate) {
			this.redisTemplate = redisTemplate;
		}
	}

	protected RedisTemplate<String, T> getRedisTemplate() {
		return redisTemplate;
	}

	@Override
	public void delete(String key) {
		this.getRedisTemplate().delete(key);
	}

	@Override
	@SuppressWarnings("unchecked")
	public void delete(String... keys) {
		this.getRedisTemplate().delete(CollectionUtils.arrayToList(keys));
	}

	@Override
	public boolean flushDB() {
		return (Boolean) this.getRedisTemplate().execute(
				new RedisCallback<Boolean>() {
					public Boolean doInRedis(RedisConnection connection)
							throws DataAccessException {
						try {
							connection.flushDb();
							return true;
						} catch (Exception e) {
							return false;
						}
					}
				});
	}

}

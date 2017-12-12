package com.springboot.util.redis.impl;

import org.springframework.data.redis.core.BoundSetOperations;

import com.springboot.util.redis.RedisSupport;

public class RedisSetOpsImpl<T> extends RedisSupportImpl implements RedisSupport {

	public void add(String key, Object value) {
		BoundSetOperations<String, Object> boundSetOps = getRedisTemplate().boundSetOps(key);
		boundSetOps.add(key);
	}

	public Object pop(String key) {
		BoundSetOperations<String, Object> boundSetOps = getRedisTemplate().boundSetOps(key);
		Object result = boundSetOps.pop();
		return result;
	}

}

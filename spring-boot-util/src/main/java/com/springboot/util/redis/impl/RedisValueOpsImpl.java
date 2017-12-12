package com.springboot.util.redis.impl;

import org.springframework.data.redis.core.BoundValueOperations;

import com.springboot.util.redis.RedisSupport;

public abstract class RedisValueOpsImpl extends RedisSupportImpl implements RedisSupport {

	public void set(String key, Object value) {
		BoundValueOperations<String, Object> boundValueOps = getRedisTemplate().boundValueOps(key);
		boundValueOps.set(value);
	}

	public Object get(String key) {
		BoundValueOperations<String, Object> boundValueOps = getRedisTemplate().boundValueOps(key);
		return boundValueOps.get();
	}

}

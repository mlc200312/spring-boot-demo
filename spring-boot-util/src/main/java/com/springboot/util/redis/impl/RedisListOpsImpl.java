package com.springboot.util.redis.impl;

import org.springframework.data.redis.core.BoundListOperations;

import com.springboot.util.redis.RedisSupport;

public class RedisListOpsImpl extends RedisSupportImpl implements RedisSupport {

	public void leftPush(String key, Object value) {
		BoundListOperations<String, Object> boundListOps = getRedisTemplate().boundListOps(key);
		boundListOps.leftPush(value);
	}

	public Object leftPop(String key) {
		BoundListOperations<String, Object> boundListOps = getRedisTemplate().boundListOps(key);
		Object result = boundListOps.leftPop();
		return result;
	}

	public void rightPush(String key, Object value) {
		BoundListOperations<String, Object> boundListOps = getRedisTemplate().boundListOps(key);
		boundListOps.rightPush(value);
	}

	public Object rightPop(String key) {
		BoundListOperations<String, Object> boundListOps = getRedisTemplate().boundListOps(key);
		Object result = boundListOps.rightPop();
		return result;
	}
}

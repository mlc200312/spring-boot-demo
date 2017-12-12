package com.springboot.util.redis.impl;

import org.springframework.data.redis.core.BoundZSetOperations;

import com.springboot.util.redis.RedisSupport;

public class RedisZSetOpsImpl extends RedisSupportImpl implements RedisSupport {

	public Boolean add(String key, Object vaule, double score) {
		BoundZSetOperations<String, Object> boundZSetOps = getRedisTemplate().boundZSetOps(key);
		return boundZSetOps.add(vaule, score);
	}

	public Double score(String key, Object value) {
		BoundZSetOperations<String, Object> boundZSetOps = getRedisTemplate().boundZSetOps(key);
		return boundZSetOps.score(value);
	}

	public Double incrementScore(String key, Object value, double score) {
		BoundZSetOperations<String, Object> boundZSetOps = getRedisTemplate().boundZSetOps(key);
		return boundZSetOps.incrementScore(value, score);
	}

}

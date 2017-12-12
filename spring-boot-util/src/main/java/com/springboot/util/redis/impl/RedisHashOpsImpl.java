package com.springboot.util.redis.impl;

import java.util.Map;
import java.util.Set;

import org.springframework.data.redis.core.BoundHashOperations;

import com.springboot.util.redis.RedisSupport;

public class RedisHashOpsImpl extends RedisSupportImpl implements RedisSupport {

	public void put(String key, String mkey, Object value) {
		BoundHashOperations<String, Object, Object> boundHashOps = getRedisTemplate().boundHashOps(key);
		boundHashOps.put(mkey, value);
	}

	public Object get(String key, String mkey) {
		BoundHashOperations<String, Object, Object> boundHashOps = getRedisTemplate().boundHashOps(key);
		Object result = boundHashOps.get(mkey);
		return result;
	}

	public Set<Object> keys(String key) {
		BoundHashOperations<String, Object, Object> boundHashOps = getRedisTemplate().boundHashOps(key);
		return boundHashOps.keys();
	}

	public Map<Object, Object> entries(String key) {
		BoundHashOperations<String, Object, Object> boundHashOps = getRedisTemplate().boundHashOps(key);
		return boundHashOps.entries();
	}

}

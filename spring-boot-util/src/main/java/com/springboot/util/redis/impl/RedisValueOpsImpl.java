package com.springboot.util.redis.impl;

import org.springframework.data.redis.core.BoundValueOperations;

import com.springboot.util.redis.RedisSupport;

public abstract class RedisValueOpsImpl<T> extends RedisSupportImpl<T>
		implements RedisSupport<T> {

	@Override
	public void add(String key, T t) {
		BoundValueOperations<String, T> operations = this.getRedisTemplate()
				.boundValueOps(key);
		operations.set(t);
	}

	@Override
	public T get(String key) {
		BoundValueOperations<String, T> operations = this.getRedisTemplate()
				.boundValueOps(key);
		return operations.get();
	}

}

package com.springboot.util.redis.impl;

import com.springboot.util.redis.RedisSupport;

public class RedisListOpsImpl<T> extends RedisSupportImpl<T> implements
		RedisSupport<T> {

	@Override
	public void add(String key, T t) {
		this.getRedisTemplate().boundListOps(key).leftPush(t);
	}

	@Override
	public T get(String key) {
		return this.getRedisTemplate().boundListOps(key).leftPop();
	}

}

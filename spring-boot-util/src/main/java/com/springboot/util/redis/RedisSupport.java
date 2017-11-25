package com.springboot.util.redis;

public interface RedisSupport<T> {

	void add(String key, T t);

	void delete(String key);

	void delete(String... keys);

	T get(String key);

	boolean flushDB();

}

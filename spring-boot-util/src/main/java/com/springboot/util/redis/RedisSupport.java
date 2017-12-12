package com.springboot.util.redis;

import java.util.List;

import org.springframework.data.redis.connection.DataType;

public interface RedisSupport {

	/**
	 * 删除key
	 * 
	 * @param key
	 * @return
	 */
	long del(String key);

	/**
	 * 删除keys
	 * 
	 * @param keys
	 */
	void del(String... keys);

	/**
	 * 递增数字
	 * 
	 * @param key
	 * @return
	 */
	long incr(String key);

	/**
	 * 增加指定的整数
	 * 
	 * @param key
	 * @param num
	 * @return
	 */
	long incrBy(String key, long num);

	/**
	 * 增加指定的小數
	 * 
	 * @param key
	 * @param num
	 * @return
	 */
	double incrBy(String key, double num);

	/**
	 * 递减数字
	 * 
	 * @param key
	 * @return
	 */
	long decr(String key);

	/**
	 * 减少指定的整数
	 * 
	 * @param key
	 * @param num
	 * @return
	 */
	long decrBy(String key, long num);

	/**
	 * 获取字符串长度
	 * 
	 * @param key
	 * @return
	 */
	long strlen(String key);

	/**
	 * 设置生存时间
	 * 
	 * 单位是秒
	 * 
	 * @param key
	 * @param time
	 * @return
	 */
	boolean expire(String key, long time);

	/**
	 * 查看生存时间
	 * 
	 * @param key
	 * @return
	 */
	long ttl(String key);

	/**
	 * 清除生存时间
	 * 
	 * @param key
	 * @return
	 */
	boolean persist(String key);

	/**
	 * 返回数据类型
	 * 
	 * @param key
	 * @return
	 */
	DataType type(String key);

	/**
	 * 开启事务
	 * 
	 * @return
	 */
	boolean multi();

	/**
	 * 提交事务
	 * 
	 * @return
	 */
	List<?> exec();

	/**
	 * 清空当前DB数据
	 * 
	 * @return
	 */
	boolean flushDB();

	/**
	 * 清空所有数据
	 * 
	 * @return
	 */
	boolean flushAll();
}

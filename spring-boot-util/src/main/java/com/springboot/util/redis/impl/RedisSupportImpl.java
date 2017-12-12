package com.springboot.util.redis.impl;

import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.DataType;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.util.CollectionUtils;

import com.springboot.util.redis.RedisSupport;

public class RedisSupportImpl implements RedisSupport {

	private RedisTemplate<String, Object> redisTemplate;

	protected final void setRedisTemplate(RedisTemplate<String, Object> redisTemplate) {
		if (this.redisTemplate == null || this.redisTemplate != redisTemplate) {
			this.redisTemplate = redisTemplate;
		}
	}

	protected RedisTemplate<String, Object> getRedisTemplate() {
		return redisTemplate;
	}

	@Override
	public long del(final String key) {
		return (Long) this.getRedisTemplate().execute(new RedisCallback<Long>() {
			@Override
			public Long doInRedis(RedisConnection redisconnection) throws DataAccessException {
				return redisconnection.del(key.getBytes());
			}
		});
	}

	@Override
	@SuppressWarnings("unchecked")
	public void del(String... keys) {
		this.getRedisTemplate().delete(CollectionUtils.arrayToList(keys));
	}

	@Override
	public long incr(final String key) {
		return (Long) this.getRedisTemplate().execute(new RedisCallback<Long>() {
			@Override
			public Long doInRedis(RedisConnection redisconnection) throws DataAccessException {
				long scroe = redisconnection.incr(key.getBytes());
				return scroe;
			}
		});
	}

	@Override
	public long incrBy(final String key, final long num) {
		return (Long) this.getRedisTemplate().execute(new RedisCallback<Long>() {
			@Override
			public Long doInRedis(RedisConnection redisconnection) throws DataAccessException {
				long scroe = redisconnection.incrBy(key.getBytes(), num);
				return scroe;
			}
		});
	}

	@Override
	public double incrBy(final String key, final double num) {
		return (Double) this.getRedisTemplate().execute(new RedisCallback<Double>() {
			@Override
			public Double doInRedis(RedisConnection redisconnection) throws DataAccessException {
				double scroe = redisconnection.incrBy(key.getBytes(), num);
				return scroe;
			}
		});
	}

	@Override
	public long decr(final String key) {
		return (Long) this.getRedisTemplate().execute(new RedisCallback<Long>() {
			@Override
			public Long doInRedis(RedisConnection redisconnection) throws DataAccessException {
				long scroe = redisconnection.decr(key.getBytes());
				return scroe;
			}
		});
	}

	@Override
	public long decrBy(final String key, final long num) {
		return (Long) this.getRedisTemplate().execute(new RedisCallback<Long>() {
			@Override
			public Long doInRedis(RedisConnection redisconnection) throws DataAccessException {
				long scroe = redisconnection.decrBy(key.getBytes(), num);
				return scroe;
			}
		});
	}

	@Override
	public long strlen(final String key) {
		return (Long) this.getRedisTemplate().execute(new RedisCallback<Long>() {
			@Override
			public Long doInRedis(RedisConnection redisconnection) throws DataAccessException {
				long len = redisconnection.strLen(key.getBytes());
				return len;
			}
		});
	}

	@Override
	public boolean expire(final String key, final long time) {
		return (Boolean) this.getRedisTemplate().execute(new RedisCallback<Boolean>() {
			@Override
			public Boolean doInRedis(RedisConnection redisconnection) throws DataAccessException {
				return redisconnection.expire(key.getBytes(), time);
			}
		});
	}

	@Override
	public long ttl(final String key) {
		return (Long) this.getRedisTemplate().execute(new RedisCallback<Long>() {
			@Override
			public Long doInRedis(RedisConnection redisconnection) throws DataAccessException {
				return redisconnection.ttl(key.getBytes());
			}
		});
	}

	@Override
	public boolean persist(final String key) {
		return (Boolean) this.getRedisTemplate().execute(new RedisCallback<Boolean>() {
			@Override
			public Boolean doInRedis(RedisConnection redisconnection) throws DataAccessException {
				return redisconnection.persist(key.getBytes());
			}
		});
	}

	@Override
	public DataType type(final String key) {
		return (DataType) this.getRedisTemplate().execute(new RedisCallback<DataType>() {
			@Override
			public DataType doInRedis(RedisConnection redisconnection) throws DataAccessException {
				DataType dataType = redisconnection.type(key.getBytes());
				return dataType;
			}
		});
	}

	@Override
	public boolean multi() {
		return (Boolean) this.getRedisTemplate().execute(new RedisCallback<Boolean>() {
			@Override
			public Boolean doInRedis(RedisConnection redisconnection) throws DataAccessException {
				try {
					redisconnection.multi();
					return true;
				} catch (Exception e) {
					return false;
				}
			}
		});
	}

	@Override
	public List<?> exec() {
		return (List<?>) this.getRedisTemplate().execute(new RedisCallback<List<?>>() {
			@Override
			public List<?> doInRedis(RedisConnection redisconnection) throws DataAccessException {
				List<?> list = redisconnection.exec();
				return list;
			}
		});
	}

	@Override
	public boolean flushDB() {
		return (Boolean) this.getRedisTemplate().execute(new RedisCallback<Boolean>() {
			public Boolean doInRedis(RedisConnection connection) throws DataAccessException {
				try {
					connection.flushDb();
					return true;
				} catch (Exception e) {
					return false;
				}
			}
		});
	}

	@Override
	public boolean flushAll() {
		return (Boolean) this.getRedisTemplate().execute(new RedisCallback<Boolean>() {
			public Boolean doInRedis(RedisConnection connection) throws DataAccessException {
				try {
					connection.flushAll();
					return true;
				} catch (Exception e) {
					return false;
				}
			}
		});
	}

}

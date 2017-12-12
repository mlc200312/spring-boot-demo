package lab.springboot.redis.controller;

import java.util.List;

import javax.annotation.Resource;

import lab.springboot.redis.Application;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class RedisTest {

	@Resource
	private ResdisImpl resdisImpl;

	@Test
	public void test() {
		List<Object> list = resdisImpl.getSuperRedisTemplate().execute(new RedisCallback<List<Object>>() {

			@Override
			public List<Object> doInRedis(RedisConnection redisconnection) throws DataAccessException {
				redisconnection.multi();
				redisconnection.incr("abcde".getBytes());
				redisconnection.incr("abcde".getBytes());
				return redisconnection.exec();
			}
		});
		System.out.println(list);
	}

	@Test
	public void test2() {

		resdisImpl.leftPush("list_key", "min1");
		resdisImpl.leftPush("list_key", "min2");
		resdisImpl.leftPush("list_key", "min3");
		resdisImpl.leftPush("list_key", "min4");
		resdisImpl.leftPush("list_key", "min5");

		System.out.println(resdisImpl.leftPop("list_key"));
		System.out.println(resdisImpl.rightPop("list_key"));

	}
}

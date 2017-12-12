package lab.springboot.redis.controller;

import javax.annotation.Resource;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import com.springboot.util.redis.impl.RedisListOpsImpl;

@Component
public class ResdisImpl extends RedisListOpsImpl{

	@Resource(name = "redisTemplate")
	private void setSuperRedisTemplate(RedisTemplate<String, Object> redisTemplate) {
		super.setRedisTemplate(redisTemplate);
	}

	public RedisTemplate<String, Object> getSuperRedisTemplate(){
		return super.getRedisTemplate();
	}
	
}

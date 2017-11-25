package lab.springboot.redis.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import lab.springboot.core.model.User;
import lab.springboot.redis.service.UserService;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import com.springboot.util.redis.impl.RedisValueOpsImpl;

@Service("userService")
public class UserServiceImpl extends RedisValueOpsImpl<User> implements
		UserService {

	@Resource(name = "redisTemplate")
	private void setSuperRedisTemplate(RedisTemplate<String, User> redisTemplate) {
		super.setRedisTemplate(redisTemplate);
	}

	@Override
	public void save(User user) {
		this.add("KEY_USER_" + user.getUserName(), user);
	}

	@Override
	public User find(String userName) {
		User user = this.get("KEY_USER_" + userName);
		return user;
	}

	@Override
	@Cacheable(value = "user-findAll")
	public List<User> findAll() {
		List<User> users = new ArrayList<User>();
		Set<String> keys = this.getRedisTemplate().keys("KEY_USER_*");
		for (String key : keys) {
			User user = find(key.replace("KEY_USER_", ""));
			users.add(user);
		}
		return users;
	}

}

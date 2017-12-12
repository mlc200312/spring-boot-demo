package lab.springboot.redis.service;

import java.util.List;

import lab.springboot.core.model.User;

import com.springboot.util.redis.RedisSupport;

public interface UserService extends RedisSupport {
	void save(User user);

	User find(String userName);

	List<User> findAll();
}

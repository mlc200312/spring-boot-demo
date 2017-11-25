package lab.springboot.mybatis.service;

import java.util.List;

import lab.springboot.core.model.User;
import lab.springboot.core.param.Page;

import com.github.pagehelper.PageInfo;
import com.springboot.util.mybatis.BaseService;

public interface UserService extends BaseService<User, Long> {
	void save(User user);

	void deleteAll();

	User find(String userName);

	List<User> findAll();

	PageInfo<User> queryByPage(Page page);
}

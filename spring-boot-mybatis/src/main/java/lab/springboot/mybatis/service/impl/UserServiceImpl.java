package lab.springboot.mybatis.service.impl;

import java.util.List;

import javax.annotation.Resource;

import lab.springboot.core.model.User;
import lab.springboot.core.param.Page;
import lab.springboot.mybatis.mapper.UserMapper;
import lab.springboot.mybatis.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.springboot.util.collection.MapUtil;
import com.springboot.util.mybatis.AbstractService;

@Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true)
@Service("userService")
public class UserServiceImpl extends AbstractService<User, Long> implements UserService {

	@Resource
	private UserMapper userMapper;

	@Override
	@Autowired
	public void setBaseMapper() {
		super.setBaseMapper(userMapper);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = Exception.class)
	public void save(User user) {
		userMapper.save(user);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = Exception.class)
	public void deleteAll() {
		userMapper.deleteAll();
	}

	@Override
	public User find(String userName) {
		User record = new User();
		record.setUserName(userName);
		// Object o = this.selectOne(record);
		//
		// return ModelUtil.cast(o, User.class);
		return userMapper.findByName(userName);
	}

	@Override
	public List<User> findAll() {
		return userMapper.selectAll();
	}

	@Override
	@Cacheable(value = "user-queryByPage")
	public PageInfo<User> queryByPage(Page page) {
		page.setDefaultOrder("id", "desc");
		PageHelper.startPage(page.getPage(), page.getRows(), page.getSidx());
		List<User> list = userMapper.queryByPage(MapUtil.Builder().getMap());
		return new PageInfo<>(list);
	}
}

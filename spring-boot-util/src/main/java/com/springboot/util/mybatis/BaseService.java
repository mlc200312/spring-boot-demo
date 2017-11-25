package com.springboot.util.mybatis;

import java.io.Serializable;

public interface BaseService<T, ID extends Serializable> {
	void setBaseMapper();

	int deleteByPrimaryKey(ID id);

	int insert(T record);

	int insertSelective(T record);

	T selectByPrimaryKey(ID id);
	
	T selectOne(T record);

	int updateByPrimaryKeySelective(T record);

	int updateByPrimaryKeyWithBLOBs(T record);

	int updateByPrimaryKey(T record);
}

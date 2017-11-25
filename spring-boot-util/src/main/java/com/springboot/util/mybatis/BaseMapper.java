package com.springboot.util.mybatis;

import java.io.Serializable;

import tk.mybatis.mapper.common.Mapper;

public interface BaseMapper<T, ID extends Serializable> extends Mapper<T> {
	// TODO
	// FIXME 特别注意，该接口不能被扫描到，否则会出错

	// int deleteByPrimaryKey(ID id);
	//
	// int insert(T record);
	//
	// int insertSelective(T record);
	//
	// T selectByPrimaryKey(ID id);
	//
	// int updateByPrimaryKeySelective(T record);
	//
	int updateByPrimaryKeyWithBLOBs(T record);
	//
	// int updateByPrimaryKey(T record);
}
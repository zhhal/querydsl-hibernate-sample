package com.sample.querydsl.dao;

import com.sample.querydsl.model.User;

public interface UserDao extends BaseDao<User, Integer>{
	int getTotal();
	User getUser(int userId);
}

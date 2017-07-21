package com.sample.querydsl.service;

import java.util.List;

import com.sample.querydsl.model.User;

public interface UserService extends BaseService<User, Integer> {
	int getTotal();
	User getUser(int userId);
	List<User> getUsers();
}

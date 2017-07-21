package com.sample.querydsl.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.querydsl.core.types.Predicate;
import com.sample.querydsl.dao.UserDao;
import com.sample.querydsl.model.QUser;
import com.sample.querydsl.model.User;
import com.sample.querydsl.service.UserService;

@Service("userService")
public class UserServiceImpl extends BaseServiceImpl<User, Integer> implements UserService {
	private UserDao userDao;
	
	@Autowired
	public void setBaseDao(UserDao userDao){
		super.setBaseDao(userDao);
		this.userDao = userDao;
	}

	public int getTotal(){
		return userDao.getTotal();
	}
	
	public User getUser(int userId){
		//return userDao.getUser(userId);
		QUser user = QUser.user;
		return userDao.get(user, user.userId.eq(userId));
	}
	
	public List<User> getUsers(){
		QUser user = QUser.user;
		return userDao.getList(user, 
				user.userId.gt(2)
				.and(user.userName.length().loe(5))
				);
	}
}

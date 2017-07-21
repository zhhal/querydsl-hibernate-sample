package com.sample.querydsl.dao.impl;

import java.util.List;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Repository;
import com.querydsl.jpa.hibernate.HibernateQuery;
import com.sample.querydsl.dao.UserDao;
import com.sample.querydsl.model.QUser;
import com.sample.querydsl.model.User;

@Repository
public class UserDaoImpl extends BaseDaoImpl<User,Integer> implements UserDao {
	 
	public int getTotal(){
		//return  jdbcTemplate.queryForObject("select count(*) from tb_user",int.class);
		QUser user = QUser.user;	
		Long count = this.getHibernateQuery().from(user).fetchCount();
		return count.intValue();
	}
	
	public User getUser(int userId){
		//hibernateTemplate
		//return hibernateTemplate.get(User.class,userId);
		
		//jdbcTemplate
		//return jdbcTemplate.queryForObject("select * from tb_user where id=?", new Object[]{userId}, new BeanPropertyRowMapper<User>(User.class));
		
		//queryDsl
		QUser user = QUser.user;
		return getHibernateQuery().from(user).where(user.userId.eq(userId)).fetchOne();
		/*
		QUser user = QUser.user;
		HibernateQuery<User> query = this.getHibernateQuery();
		query = query.from(user).where(user.userId.eq(userId));		
		return query.fetchOne();
		*/
	}
}

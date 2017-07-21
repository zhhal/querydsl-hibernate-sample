package com.sample.querydsl.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.orm.hibernate5.HibernateTemplate;

import com.querydsl.core.types.Predicate;
import com.querydsl.core.types.dsl.EntityPathBase;
import com.querydsl.jpa.hibernate.HibernateQuery;
import com.sample.querydsl.util.Page;

public interface BaseDao<T,PK extends Serializable> {
	public void setEntityClass(Class<T> entityClass);
	public JdbcTemplate geJdbcTemplate();
	public HibernateTemplate geHibernateTemplate();
	public HibernateQuery<T> getHibernateQuery();
	/**
	 * 获取hibernate session对象
	 * @return
	 */
	public Session getSession();
	
	
	/**
	 * queryDsl通用查询
	 */
	public T get(EntityPathBase<T> entity, Predicate predicate);
	public List<T> getList(EntityPathBase<T> entity, Predicate predicate);
	
	/**
	 * 创建一个criteria
	 * @return
	 */
	public Criteria getCriteria();

	/**
	 * 通过id加载实体
	 * @param id
	 * @return 实体对象
	 */
	public T load(PK id);

	/**
	 * 通过id加载实体
	 * @param id
	 * @return 实体对象
	 */
	public T get(PK id);

	/**
	 * 根据ID数组获取实体对象集合.
	 * @param ids
	 * @return 实体对象集合
	 */
	public List<T> get(PK[] ids);

	/**
	 * 根据属性名和属性值获取实体对象.
	 * @param propertyName
	 * @param value
	 * @return 实体对象
	 */
	public T get(String propertyName, Object value);
	
	/**
	 * 根据DetachedCriteria获取对象
	 * @param criteria
	 * @return
	 */
	public T get(DetachedCriteria criteria);

	/**
	 * 根据属性名和属性值获取实体对象集合.
	 * @param propertyName
	 * @param value
	 * @return 实体对象集合
	 */
	public List<T> getList(String propertyName, Object value);

	/**
	 * 获取所有实体对象总数.
	 * @return 实体对象总数
	 */
	public Integer getCount();
	
	/**
	 * 根据DetachedCriteria获取实体数量
	 * @param criteria
	 * @return
	 */
	public Integer getCount(DetachedCriteria criteria);

	/**
	 * 保存实体对象.
	 * @param entity
	 * @return ID
	 */
	public PK save(T entity);
	
	/**
	 * 保存或更新一个对象
	 * @param entity
	 */
	public void saveOrUpdate(T entity);

	/**
	 * 更新实体对象.
	 * @param entity
	 */
	public void update(T entity);
	
	/**
	 * 合并一个对象
	 * @param entity
	 */
	public void merge(T entity);

	/**
	 * 删除实体对象.
	 * @param entity
	 * @return
	 */
	public void delete(T entity);

	/**
	 * 根据ID删除实体对象.
	 * @param id
	 */
	public void delete(PK id);

	/**
	 * 根据ID数组删除实体对象.
	 * @param ids
	 */
	public void delete(PK[] ids);
	
	/**
	 * 根据实体集合删除实体对象
	 * @param list
	 */
	public void delete(List<T> list);
	
	/**
	 * 获取全部列表
	 * @return
	 */
	public List<T> list();
	
	/**
	 * 根据DetachedCriteria 获取列表
	 * @param criteria
	 * @return
	 */
	public List<T> list(DetachedCriteria criteria);

	/**
	 * 执行criteria查询获得一个结果
	 * @param criteria
	 * @return
	 */
	public Object findObject(DetachedCriteria criteria);
	
	/**
	 * DetachedCriteria分页查询
	 * @param criteria
	 * @param pageSize
	 * @param pageNumber
	 * @return
	 */
	public List<T> page(DetachedCriteria criteria,Integer pageSize,Integer pageNumber);

	/**
	 * 根据DetachedCriteria和Page对象获取分页page对象
	 * @param criteria
	 * @param page
	 * @return
	 */
	public Page<T> getPage(DetachedCriteria criteria,Page<T> page);
	
}

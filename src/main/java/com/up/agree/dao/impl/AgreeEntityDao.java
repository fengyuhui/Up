package com.up.agree.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.up.agree.dao.IAgreeEntityDao;
import com.up.model.AgreeEntity;

/**
 * IAgreeDao接口的实现
 * 
 * @author su
 *
 */

@Repository
@Transactional
public class AgreeEntityDao implements IAgreeEntityDao{
	
		/**
		 * 获取在Application.java文件当中的Bean，调用AgreeDao中的函数时该对象会自动的生成
		 */
		@Autowired
		private SessionFactory sessionFactory;

		/**
		 * 相当于insert语句，在数据库中添加一个新的Agree
		 */
		@Override
		public void save(AgreeEntity agree) {
			sessionFactory.getCurrentSession().save(agree);
		}
		
		/**
		 * 点赞后微博表中的点赞数属性自加1。因为怕用count操作读取会太慢，所以直接修改。
		 */
		@Override
		public void increaseAgreenum(int weibo_id) {
			sessionFactory.getCurrentSession()
			.createQuery("update Weibo set agreenum = isNull(agreenum, 0) + 1 where id = ?");
		}

		/**
		 * 取消点赞，将点赞表中相应的赞删除。
		 */

		@Override
		public void cancel(int weibo_id, int user_id) {
			sessionFactory.getCurrentSession()
			.createQuery("delete from Agree where weibo_id = ? and user_id = ?");
		}

		/**
		 * 取消点赞后微博表中的点赞数属性自减1。
		 */
		@Override
		public void decreaseAgreenum(int weibo_id) {
			sessionFactory.getCurrentSession()
			.createQuery("update Weibo set agreenum = isNull(agreenum, 0) - 1 where Weibo.id = ?");
		}
		
		/**
		 * select * from Agree where weibo_id=?，返回当下点赞列表
		 */
		@SuppressWarnings("unchecked")
		@Override
		public List<AgreeEntity> findByWeiboID(int weibo_id) {
			List<AgreeEntity> agrees = new ArrayList<AgreeEntity>();

			agrees = sessionFactory.getCurrentSession()
					.createQuery("from Agree where weibo=?")
					.setParameter(0, weibo_id).list();

			if (agrees.size() > 0) {
				return agrees;
			} else {
				return null;
				}
			}

}
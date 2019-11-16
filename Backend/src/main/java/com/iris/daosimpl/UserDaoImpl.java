package com.iris.daosimpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.iris.daos.UserDao;
import com.iris.models.User;

@Repository("userDao")
@Transactional
public class UserDaoImpl implements UserDao {
	
		@Autowired
		SessionFactory sessionFactory;

		public boolean registerUser(User uObj) {
			try {
				Session session = sessionFactory.getCurrentSession();
				session.saveOrUpdate(uObj);
				return true;
			} catch (Exception e) {
					e.printStackTrace();
			
			}
			return false;
		}

		public User loginUser(int userId, String password) {
				try {
					Session session = sessionFactory.getCurrentSession();
					User uObj=session.get(User.class, userId);
					
				if(uObj!=null) {
					if(uObj.getPassword().equals(password));
							return uObj;
				}
				} catch (Exception e) {
						
				}
			return null;
		}
		
		public User getUserById(int userId) {
			Session session=sessionFactory.getCurrentSession();
			User uObj=session.get(User.class, userId);
			
			return uObj;
		}
	

		public List<User> getAllUsers() {
			Session session=sessionFactory.getCurrentSession();
			Query q=session.createQuery("from com.iris.models.User where role='User'");
			List<User> uList=q.list();
			return uList;
		}

		
	
		public boolean deleteUser(User uObj){
			
			try {
				Session session=sessionFactory.getCurrentSession();
				session.delete(uObj);
				return true;
				
			} catch (Exception e) {
				e.printStackTrace();
			} 
				return false;
		 
		 
		 }
	
}

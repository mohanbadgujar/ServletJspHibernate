package com.bridgelabz.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.bridgelabz.model.User;
import com.bridgelabz.util.HibernateUtil;

public class LoginService {

	public boolean authenticateUser(String email, String password) {

		User user = getUserByEmailId(email);

		if (user != null && user.getEmail().equals(email) && user.getPassword().equals(password)) {
			return true;
		} else {
			return false;
		}
	}

	public User getUserByEmailId(String email) {

		Session session = HibernateUtil.openSession();
		Transaction transaction = null;
		User user = null;
		try {
			transaction = session.getTransaction();
			transaction.begin();
			Query query = session.createQuery("from User where email = :email");
			query.setParameter("email", email);
			user = (User) query.uniqueResult();
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return user;
	}
}

package com.bridgelabz.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.bridgelabz.model.User;
import com.bridgelabz.util.HibernateUtil;

public class RegisterService {

	public boolean register(User user) {

		System.out.println("hellossdf");

		Session session = HibernateUtil.openSession();

		if (isUserExits(user))
			return false;

		Transaction transaction = null;
		try {
			transaction = session.getTransaction();
			transaction.begin();
			session.saveOrUpdate(user);
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return true;
	}

	public boolean isUserExits(User user) {

		Session session = HibernateUtil.openSession();
		boolean result = false;
		Transaction transaction = null;

		try {
			transaction = session.getTransaction();
			transaction.begin();
			Query query = session.createQuery("from User where email=" + user.getEmail());

			User userexits = (User) query.uniqueResult();
			transaction.commit();

			if (userexits != null) {
				result = true;
			}

		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
		} finally {
			session.close();
		}
		return result;
	}
}

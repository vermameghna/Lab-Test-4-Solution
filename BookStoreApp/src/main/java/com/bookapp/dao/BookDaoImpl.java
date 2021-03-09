package com.bookapp.dao;


import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.bookapp.exceptions.DataAccessException;
import com.bookapp.sessionfactory.HibernateSessionFactory;


public class BookDaoImpl implements BookDao{
	
	private SessionFactory factory;

	public BookDaoImpl() {
		factory = HibernateSessionFactory.getSessionfactory();
	}

	@Override
	public void addBook(Book book) {
		Session session = factory.openSession();
		Transaction tx = session.getTransaction();
		
		try {
			tx.begin();

			session.save(book);

			tx.commit();
		} catch (HibernateException e) {
			tx.rollback();
			throw new DataAccessException(e.getCause().getMessage());
		} finally {
			if (session != null)
				session.close();
		}
		
	}

	@Override
	public Book getBook(String isbn) {
		Session session = factory.openSession();

		Book book = session.get(Book.class, isbn);

		if (session != null) {
			session.close();
		}
		
		return book;
	}

}

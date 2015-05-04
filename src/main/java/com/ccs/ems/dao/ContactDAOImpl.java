package com.ccs.ems.dao;

import java.io.File;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

import com.ccs.ems.model.Contact;

public class ContactDAOImpl implements ContactDAO{
	
	@Autowired
	SessionFactory sessionFactory;

	@Override
	public void uploadFile(Contact contact) {
		// TODO Auto-generated method stub
		Session s = sessionFactory.openSession();
		Transaction tx = s.beginTransaction();
		s.save(contact);
		tx.commit();
		s.close();
	}

}

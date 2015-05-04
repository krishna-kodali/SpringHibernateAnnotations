package com.ccs.ems.svc;

import org.springframework.beans.factory.annotation.Autowired;

import com.ccs.ems.dao.ContactDAO;
import com.ccs.ems.model.Contact;

public class ContactServiceImpl implements ContactService {

	@Autowired
	ContactDAO contactDAO;
	
	@Override
	public void uploadFile(Contact contact) {
		// TODO Auto-generated method stub
		contactDAO.uploadFile(contact);
	}

}

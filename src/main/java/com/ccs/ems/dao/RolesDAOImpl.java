package com.ccs.ems.dao;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

import com.ccs.ems.model.Roles;

public class RolesDAOImpl implements RolesDAO {

	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public Roles getEmployeeByName(String empName) {
		
		Session s = sessionFactory.openSession();
		String hql = "from Employee where empName = :empname";
		Query q = s.createQuery(hql);
		q.setParameter("empname", empName);
		Roles employee = (Roles) q.uniqueResult();
		s.close();
		return employee;
		
	}

	@Override
	public Roles getEmployeeByID(Long empID) {
		
		Session s = sessionFactory.openSession();
		Roles employee = (Roles) s.get(com.ccs.ems.model.Roles.class, empID);
		s.close();
		return employee;
	}

	@Override
	public void renameEmployee(String oldName, String newName) {
		
		Session s = sessionFactory.openSession();
		Transaction tx = s.beginTransaction();
		String hql = "update Employee set empName = :empname1" + " where empName = :empname2";
		Query q = s.createQuery(hql);
		q.setParameter("empname1", newName);
		q.setParameter("empname2", oldName);
		q.executeUpdate();
		tx.commit();
		s.close();
		

	}

	@Override
	public void deleteEmployeeByID(long ID) {
		
		Session s = sessionFactory.openSession();
		Transaction tx = s.beginTransaction();
		Roles employee = getEmployeeByID(ID); 
		s.delete(employee);
		tx.commit();
		s.close();
	}

	@Override
	public void deleteEmployeeByName(String empName) {
		
		Session s = sessionFactory.openSession();
		Transaction tx = s.beginTransaction();
		String hql = "delete Employee where empName = :empname";
		Query q = s.createQuery(hql);
		q.setParameter("empname", empName);
		q.executeUpdate();
		tx.commit();
		s.close();
		
	}

	@Override
	public Roles createEmployee(Roles emp) {
		
		Session s = sessionFactory.openSession();
		Transaction tx = s.beginTransaction();
		s.save(emp);
		tx.commit();
		//s.flush();
		s.close();
		return emp;
		
	}

	@Override
	public List<Roles> getEmployeesByDeptName(String deptName) {
		
		List<Roles> employees = new ArrayList<Roles>();
		Session s  = sessionFactory.openSession();
		String hql = "from Employee as employee where employee.dept.deptName = :deptname";
		Query q = s.createQuery(hql);
		q.setParameter("deptname", deptName);
		employees = (List<Roles>) q.list();
		s.close();
		
		return employees;
	}

	@Override
	public List<Roles> getAll() {
		
		Session s = sessionFactory.openSession();
		String hql = "from Employee";
		Query q = s.createQuery(hql);
		List<Roles> employees = q.list();
		s.close();
		return employees;
		
	}
		
}

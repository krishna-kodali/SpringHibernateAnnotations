package com.ccs.ems.svc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.ccs.ems.dao.RolesDAO;
import com.ccs.ems.dao.UserDAO;
import com.ccs.ems.model.Roles;

public class RolesServiceImpl implements RolesService{
	
	@Autowired
	RolesDAO rolesDAO;

	@Override
	public Roles getEmployeeByName(String empName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Roles getEmployeeByID(Long empID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void renameEmployee(String oldName, String newName) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteEmployeeByID(long ID) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteEmployeeByName(String empName) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Roles createEmployee(Roles emp) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Roles> getEmployeesByDeptName(String deptName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Roles> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

}

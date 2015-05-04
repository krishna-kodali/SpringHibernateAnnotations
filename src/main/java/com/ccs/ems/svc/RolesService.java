package com.ccs.ems.svc;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ccs.ems.model.Roles;

@Service
public interface RolesService {
	
	public Roles getEmployeeByName(String empName);
	
	public Roles getEmployeeByID(Long empID);
	
	public void renameEmployee(String oldName, String newName);
	
	public void deleteEmployeeByID(long ID);
	
	public void deleteEmployeeByName(String empName);
	
	public Roles createEmployee(Roles emp);
	
	public List<Roles> getEmployeesByDeptName(String deptName);
	
	public List<Roles> getAll();
}

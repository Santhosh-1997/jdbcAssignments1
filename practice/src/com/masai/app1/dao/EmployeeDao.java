package com.masai.app1.dao;

import java.util.List;

import com.masai.app1.bean.Employee;
import com.masai.app1.exception.EmployeeException;

public interface EmployeeDao {

	
	public boolean deleteEmployeeById(int empId)throws EmployeeException;
	
	public String giveBonusToEmployee(int empId,int amount) throws EmployeeException;
	
	public String saveEmployeeDetails(Employee employee);
	
	public List<Employee> getAllEmployee();
	
	public Employee getEmployeebyId(int id) throws EmployeeException;
	
}

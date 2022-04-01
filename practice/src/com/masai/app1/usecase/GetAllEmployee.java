package com.masai.app1.usecase;

import java.util.ArrayList;
import java.util.List;

import com.masai.app1.bean.Employee;
import com.masai.app1.dao.EmployeeDao;
import com.masai.app1.dao.EmployeeDaoImpl;

public class GetAllEmployee {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		List<Employee> result = new ArrayList<>();
		
		EmployeeDao dao = new EmployeeDaoImpl();
		
		result = dao.getAllEmployee();
		
		for(Employee el : result)
			System.out.println(el.toString());

	}

}

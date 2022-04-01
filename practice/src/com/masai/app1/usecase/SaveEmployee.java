package com.masai.app1.usecase;

import java.util.Scanner;

import com.masai.app1.bean.Employee;
import com.masai.app1.dao.EmployeeDao;
import com.masai.app1.dao.EmployeeDaoImpl;

public class SaveEmployee {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner input = new Scanner(System.in);
		
		System.out.println("Enter id");
		
		int id = input.nextInt();
		
		System.out.println("Enter name");
		
		String name = input.next();
		
		System.out.println("Enter Address");
		
		String address = input.next();
		
		System.out.println("Enter salary");
		
		int salary = input.nextInt();
		
		Employee emp = new Employee(id, name, address, salary);
		
		EmployeeDao dao = new EmployeeDaoImpl();
		
		String result = dao.saveEmployeeDetails(emp);
		
		System.out.println(result);

	}

}

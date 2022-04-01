package com.masai.app1.usecase;

import java.util.Scanner;

import com.masai.app1.dao.EmployeeDao;
import com.masai.app1.dao.EmployeeDaoImpl;
import com.masai.app1.exception.EmployeeException;

public class deleteEmployee {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner input = new Scanner(System.in);
		
		System.out.println("Enter id");
		
		int id = input.nextInt();
		
		
		EmployeeDao dao = new EmployeeDaoImpl();
		
		try {
			boolean result = dao.deleteEmployeeById(id);
			if(result)
				System.out.println("deleted successfully");
		} catch (EmployeeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}

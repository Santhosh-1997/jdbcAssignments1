package com.masai.app1.usecase;

import java.util.Scanner;

import com.masai.app1.dao.EmployeeDao;
import com.masai.app1.dao.EmployeeDaoImpl;
import com.masai.app1.exception.EmployeeException;

public class GiveBonus {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner input = new Scanner(System.in);
		
		System.out.println("Enter employee id");
		
		int id = input.nextInt();
		
		System.out.println("Enter employee bonus");
		
		int bonus = input.nextInt();
		
		EmployeeDao dao = new EmployeeDaoImpl();
		
		try {
			String result = dao.giveBonusToEmployee(id, bonus);
			System.out.println(result);
			
		} catch (EmployeeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}

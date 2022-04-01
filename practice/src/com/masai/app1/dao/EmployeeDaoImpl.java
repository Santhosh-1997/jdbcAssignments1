package com.masai.app1.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.masai.app1.bean.Employee;
import com.masai.app1.exception.EmployeeException;
import com.masai.app1.utility.DataBaseUtil;

public class EmployeeDaoImpl implements EmployeeDao {

	@Override
	public boolean deleteEmployeeById(int empId) throws EmployeeException {
		
		boolean result = false;
		
		
		try(Connection conn = DataBaseUtil.getConnection()){
			
			PreparedStatement ps = conn.prepareStatement("delete from employee where eid = ?");
			
			ps.setInt(1, empId);
			
			int i = ps.executeUpdate();
			
			if(i>=0)
				result = true;
			else
				throw new EmployeeException("eid not found");
			
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new EmployeeException(e.getMessage());
		}
		
		
		
		return result;
	}

	@Override
	public String giveBonusToEmployee(int empId, int amount) throws EmployeeException {
		
		
		String result = "not found";
		
		
		try(Connection conn = DataBaseUtil.getConnection()){
			
			PreparedStatement ps = conn.prepareStatement("update employee set salary = salary + ? where eid = ?");
			
			ps.setInt(1, amount);
			ps.setInt(2, empId);
			
			int i = ps.executeUpdate();
			
			if(i>0)
				result = "bonus updated";
			else
				throw new EmployeeException("eid not found");
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new EmployeeException(e.getMessage());
		}
		
		
		
		return result;
		
	}

	@Override
	public String saveEmployeeDetails(Employee employee) {
		
		String result = "not updated";
		
		try(Connection conn = DataBaseUtil.getConnection()){
			
			PreparedStatement ps = conn.prepareStatement("insert into employee values(?,?,?,?)");
			
			ps.setInt(1, employee.getEid());
			ps.setString(2, employee.getName());
			ps.setString(3, employee.getAddress());
			ps.setInt(4, employee.getSalary());
			
			int i = ps.executeUpdate();
			
			if(i>0)
				result = "details updated";
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return result;
		
	}

	@Override
	public List<Employee> getAllEmployee() {
		
		List<Employee> result = new ArrayList<>();
		
		
		try(Connection conn = DataBaseUtil.getConnection()){
			
			PreparedStatement ps = conn.prepareStatement("select * from employee");
			
			ResultSet rs = ps.executeQuery();			

			while(rs.next()) {
				
				Employee emp = new Employee(rs.getInt("eid"), rs.getString("name"), rs.getString("address"), rs.getInt("salary"));
				
				result.add(emp);
				
			}

			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		return result;
		
		
	}

	@Override
	public Employee getEmployeebyId(int id) throws EmployeeException {
		
		Employee employee = null;
		
		try(Connection conn = DataBaseUtil.getConnection()){
			
			
			PreparedStatement ps = conn.prepareStatement("select * from employee where eid = ?");
			
			ps.setInt(1, id);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				
				employee = new Employee(rs.getInt("eid"), rs.getString("name"), rs.getString("address"), rs.getInt("salary"));
				
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new EmployeeException(e.getMessage());
		}
		
		
		
		
		return employee;
	}

}

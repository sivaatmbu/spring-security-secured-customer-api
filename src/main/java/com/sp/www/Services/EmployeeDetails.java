package com.sp.www.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.sp.www.Beans.Employees;
import com.sp.www.Beans.MyEmployees;
import com.sp.www.Repositories.EmployeesRepo;

@Service
public class EmployeeDetails implements UserDetailsService {
	
	@Autowired
	EmployeesRepo empRepo;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Employees emp=empRepo.getByName(username);
		if(emp==null) {
			System.out.println("Employee Not Found");
			throw new UsernameNotFoundException("Employee Not Found");
		}
		return new MyEmployees(emp);
	}

}

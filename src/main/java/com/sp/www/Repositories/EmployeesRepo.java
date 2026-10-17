package com.sp.www.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sp.www.Beans.Employees;

public interface EmployeesRepo extends JpaRepository<Employees,Integer> {
	Employees getByName(String name);
}

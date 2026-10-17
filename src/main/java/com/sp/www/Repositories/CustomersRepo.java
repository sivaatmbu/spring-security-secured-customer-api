package com.sp.www.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sp.www.Beans.Customers;

public interface CustomersRepo extends JpaRepository<Customers,Integer> {
	Customers getByName(String name);
}

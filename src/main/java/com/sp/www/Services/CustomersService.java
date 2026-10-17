package com.sp.www.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sp.www.Beans.Customers;
import com.sp.www.Repositories.CustomersRepo;

@Service
public class CustomersService {
	@Autowired
	CustomersRepo customerRepo;
	
	public List<Customers> getAllCustomers(){
		return customerRepo.findAll();
	}
	public Customers getCustomerById(Integer id) {
        return customerRepo.findById(id).orElse(null);
    }
    public Customers getCustomerByName(String name) {
        return customerRepo.getByName(name);
    }
    public Customers addCustomer(Customers customer) {
        return customerRepo.save(customer);
    }
    public Customers updateCustomer(Customers customer) {
        return customerRepo.save(customer);
    }
    public void deleteCustomer(Integer id) {
        customerRepo.deleteById(id);
    }
}

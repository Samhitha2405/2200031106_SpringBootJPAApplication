package com.klef.jfsd.exam.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.klef.jfsd.exam.model.Customer;
import com.klef.jfsd.exam.repository.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService{
	
	@Autowired
	private CustomerRepository repository;

	@Override
	public String UpdateCustomer(Customer c) {
		Optional<Customer> object = repository.findById(c.getId());
		String msg=null;
		if(object.isPresent())
		{
			Customer cu = object.get();
			cu.setName(cu.getName());
			cu.setAddress(cu.getAddress());
			
			repository.save(c);
			msg="Customer Updated Successfully";
		
		
		}
		else
		{
			msg="Customer ID not found";
		}
		
		return msg;
	}

}

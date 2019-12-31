package service;

import java.util.*;

import entities.Wallet;

public interface ICustomerService {
	void addCustomer(Wallet w);
	
	Wallet findByMobileno(String mobileno);
	
	Set<Wallet> allCustomers();

}

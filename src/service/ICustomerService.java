package service;

import java.util.*;

import entities.Wallet;

public interface ICustomerService {
	void addCustomer(Wallet w);
	
	Wallet findByMobileno(String mobileno);
	
	public void transferAmount(Wallet sender, Wallet receiver,double amount);
	
	Set<Wallet> allCustomers();

}

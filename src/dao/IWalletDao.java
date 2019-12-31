package dao;

import entities.Wallet;

import java.util.*;

public interface IWalletDao {
	
	void addCustomer(Wallet w);
	
	Wallet findByMobileno(String mobileno);
	
	
	Set<Wallet> allCustomers();

}

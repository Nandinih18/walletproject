package dao;

import entities.Wallet;

import java.util.*;

public interface IWalletDao {
	
	void addCustomer(Wallet w);
	
	Wallet findByMobileno(String mobileno);
	
	public void transferAmount(Wallet sender, Wallet receiver,double amount);
	
	Set<Wallet> allCustomers();

}

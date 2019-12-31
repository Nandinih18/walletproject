package service;

import java.util.*;

import entities.Wallet;
import exceptions.*;
import dao.IWalletDao;

public class CustomerServiceImpl implements ICustomerService {
	private IWalletDao dao;

	public CustomerServiceImpl(IWalletDao dao) {
		this.dao=dao;
	}
	
	@Override
    public void addCustomer(Wallet w) {
        dao.addCustomer(w);
    }
	
	@Override
	public void transferAmount(Wallet sender, Wallet receiver,double amount) {
	dao.transferAmount(sender,receiver,amount);
	}

	
	@Override
	public Wallet findByMobileno(String mobileno) {
		if(mobileno.length()!=10) {
			throw new IncorrectMobNoException("Mobile number is incorrect");
		}
		
		Wallet w=dao.findByMobileno(mobileno);
		return w;
	}
	
	@Override
	public Set<Wallet> allCustomers() {
	Set<Wallet> customers = dao.allCustomers();
    return customers;
	}
	
	

}

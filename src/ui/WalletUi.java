package ui;

import java.util.*;

import dao.*;
import entities.*;
import service.*;

public class WalletUi {
	private ICustomerService service= new CustomerServiceImpl(new WalletDaoImpl());
	
	public static void main(String[]args) {
		WalletUi ui=new WalletUi();
		ui.runUi();
	}
	
	public void runUi() {
		try {
			Wallet w1=new Wallet("1234567890","Nandini",1000);
			Wallet w2=new Wallet("9876543211","Nida",2000);
			service.addCustomer(w1);
			service.addCustomer(w2);
			Wallet fetched1= service.findByMobileno("9876543211");
			Wallet fetched2= service.findByMobileno("1234567890");
			service.transferAmount(w1, w2, 500);
			System.out.println("Name:"+fetched1.getName()+"Balance:"+fetched1.getBalance());
			System.out.println("Name:"+fetched2.getName()+"Balance:"+fetched2.getBalance());
			System.out.println("*****Printing all Customers");
			Set<Wallet> customers=service.allCustomers();
			print(customers);
			
		}catch (Throwable e) {
			e.printStackTrace();
			System.out.println("Something went wrong");
		}
	}
	
	void print(Collection<Wallet>customers) {
		for(Wallet w:customers) {
			System.out.println(w.getName());
		}
	}

}

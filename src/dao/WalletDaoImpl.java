package dao;

import entities.Wallet;
import exceptions.*;

import java.util.*;

public class WalletDaoImpl implements IWalletDao {
	private Map<String, Wallet> store = new HashMap<>();
	
	@Override
    public void addCustomer(Wallet w) {
        store.put(w.getMobileno(), w);
    }


	@Override
	public Wallet findByMobileno(String mobileno) {
		Wallet w = store.get(mobileno);
		if (w == null) {
			throw new CustomerNotFoundException("customer not found for mobile number:" + mobileno);
		}
		return w;
	}

	@Override
	public Set<Wallet> allCustomers() {
		Collection<Wallet> customers = store.values();
		Set<Wallet> customerSet = new HashSet<>(customers);
		return customerSet;
	}
	
	public void transferAmount(Wallet sender, Wallet receiver,double amount) {
		if(sender.getBalance()>amount) {
		receiver.addAmount(amount);
		sender.addAmount(0-amount);
		}
		else
		{
			System.out.println("Insufficient Balance");
		}

	}
}

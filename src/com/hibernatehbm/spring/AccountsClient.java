package com.hibernatehbm.spring;

import java.util.List;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;



public class AccountsClient {
	
	public static void main(String[] args)
	{
		
		AccountsClient acc = new AccountsClient();
		
		ApplicationContext context = new FileSystemXmlApplicationContext("src/beans.xml");
		AccountsDao accountsDao = context.getBean("accountsDaoBean",AccountsDao.class);
		
		//accountsDao.createAccount(1112, "Manoj", 1000);
		//accountsDao.createAccount(1121, "Ghag", 5000);
		
		//accountsDao.updatebalance(111, 12000);
		
	
		acc.showall(accountsDao);
		
		accountsDao.updatebalance(1112, 12000);
		
		acc.showall(accountsDao);
		
		
		
	}
	
	public void showall(AccountsDao accountsDao)
	{
		List<Account> accounts = accountsDao.getAllAccounts();
		for (int i = 0;i<accounts.size();i++)
		{
			Account acc = accounts.get(i);
			System.out.print(acc.getAccountNumber() + ":" + acc.getOwner()+":" + acc.getBalance());
			
			
		}
		
	}

}

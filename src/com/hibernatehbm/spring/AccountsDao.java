package com.hibernatehbm.spring;

import java.util.*;
import org.springframework.orm.hibernate3.support.*;

public class AccountsDao extends HibernateDaoSupport  {
	public void createAccount(int accountNumber,String owner, double balance)
	{
		Account account = new Account(accountNumber,owner,balance);
		getHibernateTemplate().save(account);
		
	}
	public void updatebalance(int accountNumber, double newBalance)
	{
		Account account = getHibernateTemplate().get(Account.class, accountNumber);
		
		if(account!=null)
		{
			account.setBalance(newBalance);
		}
		getHibernateTemplate().update(account);
		
		
	}

	
	public List<Account> getAllAccounts()
	{
		return getHibernateTemplate().find("from Account");
	}
}

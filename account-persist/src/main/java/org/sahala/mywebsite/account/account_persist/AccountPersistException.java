package org.sahala.mywebsite.account.account_persist;

public class AccountPersistException extends Exception {

	public AccountPersistException(String message) {  
        super(message);  
    }  
  
    public AccountPersistException(String message, Throwable throwable) {  
        super(message, throwable);  
    }  
}

package base;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import exceptions.InsufficientFundsException;

public class Account_Test {
	Account acc;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		
	}

	@Before
	public void setUp() throws Exception {
		acc = new Account(1122,20000,4.5);
	}

	@After
	public void tearDown() throws Exception {
		acc=null;
	}

	
	@Test
	public void testAccountCreationDefault() {
		Account testAccountDefault = new Account();
		assertTrue(testAccountDefault.getBalance()==0);
		assertTrue(testAccountDefault.getId()==0);
		assertTrue(testAccountDefault.getAnnualInterestRate()==0);
		assertTrue(testAccountDefault.getMonthlyInterestRate()==0);
		assertTrue(testAccountDefault.getDateCreated()!=null);
	}
	
	@Test
	public void testAccountCreationSet() {
		Account testAccountSet = new Account(13,9001,7.5);
		assertTrue(testAccountSet.getBalance()==9001.0);
		assertTrue(testAccountSet.getId()==13);
		assertTrue(testAccountSet.getAnnualInterestRate()==7.5);
		assertTrue(testAccountSet.getMonthlyInterestRate()==7.5/12);
		assertTrue(testAccountSet.getDateCreated()!=null);
	}
	@Test
	public void testSetId(){
		Account testAccountDefault = new Account();
		testAccountDefault.setId(7);
		assertTrue(testAccountDefault.getId()==7);
	}
	@Test
	public void testSetBalance(){
		Account testAccountDefault = new Account();
		testAccountDefault.setBalance(10000);
		assertTrue(testAccountDefault.getBalance()==10000.0);
	}
	@Test
	public void testSetAnnualInterestRate(){
		Account testAccountDefault = new Account();
		testAccountDefault.setAnnualInterestRate(9);
		assertTrue(testAccountDefault.getAnnualInterestRate()==9.0);
	}
	@Test
	public void testWithdraw() throws InsufficientFundsException{
		acc.withdraw(2500);
		assertTrue(acc.getBalance()==20000.0-2500.0);
	}
	@Test(expected=InsufficientFundsException.class)
	public void testWithdrawToMuch() throws InsufficientFundsException{
		assertTrue(acc.getBalance()==20000.0);
		acc.withdraw(50000);
	}
	
	@Test
	public void testDeposit(){
		acc.deposit(30000);
		assertTrue(acc.getBalance()==20000.0+30000.0);
	}
	@Test
	public void testPrint() throws InsufficientFundsException{
		acc.withdraw(2500);
		acc.deposit(3000);
		System.out.println(acc.getBalance());
		System.out.println(acc.getMonthlyInterestRate());
		System.out.println(acc.getDateCreated());
	}
	
	
}

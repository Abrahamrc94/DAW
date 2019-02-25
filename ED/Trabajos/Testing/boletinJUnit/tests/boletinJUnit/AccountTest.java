package boletinJUnit;

import static org.junit.Assert.*;

import org.junit.Test;

public class AccountTest {

	Account acc = new Account("Jose", 23, 22);
	
	@Test
	public void testDeposit() {
		
		assertEquals(false, acc.deposit(-5));
		assertEquals(true, acc.deposit(0));
	}
	
	@Test
	public void testWithdraw() {
		
		assertEquals(true, acc.withdraw(25, 20));
	}

}

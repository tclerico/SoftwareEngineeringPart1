package edu.ithaca.dragon.bank;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BankAccountTest {

    @Test
    void getBalanceTest() {
        BankAccount bankAccount = new BankAccount("a@b.com", 200);

        assertEquals(200, bankAccount.getBalance());
    }

    @Test
    void isAmountValidTest(){
        // New Tests
        assertFalse(BankAccount.isAmountValid(1.345));
        assertTrue(BankAccount.isAmountValid(1.05));
        assertFalse(BankAccount.isAmountValid(-30.5));
    }

    @Test
    void withdrawTest() {
        BankAccount bankAccount = new BankAccount("a@b.com", 200);
        bankAccount.withdraw(100);

        assertEquals(100, bankAccount.getBalance());

        // New Tests
        assertThrows(IllegalArgumentException.class, ()-> bankAccount.withdraw(150));
        // shows that the expected does not equal the actual balance
        assertNotEquals(100, bankAccount.getBalance());
        // should throw exception and not subtract from balance
        assertEquals(100, bankAccount.getBalance());

        assertThrows(IllegalArgumentException.class, ()-> bankAccount.withdraw(-20));

        bankAccount.withdraw(50);
        assertEquals(50, bankAccount.getBalance());

        assertThrows(IllegalArgumentException.class, ()-> bankAccount.withdraw(5.987));

    }

    @Test
    void isEmailValidTest(){
        assertTrue(BankAccount.isEmailValid( "a@b.com"));
        assertFalse( BankAccount.isEmailValid(""));

        // New Tests
        assertFalse(BankAccount.isEmailValid("@bbb.asda"));
        assertFalse(BankAccount.isEmailValid("a@b"));
        assertFalse(BankAccount.isEmailValid("a@.com"));
        assertTrue(BankAccount.isEmailValid("test@mail.com"));

    }

    @Test
    void constructorTest() {
        BankAccount bankAccount = new BankAccount("a@b.com", 200);

        assertEquals("a@b.com", bankAccount.getEmail());
        assertEquals(200, bankAccount.getBalance());
        //check for exception thrown correctly
        assertThrows(IllegalArgumentException.class, ()-> new BankAccount("", 100));

        // New Tests
        assertThrows(IllegalArgumentException.class, ()-> new BankAccount("neg@mail.com", -25));
        assertThrows(IllegalArgumentException.class, ()-> new BankAccount("trip@mail.com", 12.456));



    }

}
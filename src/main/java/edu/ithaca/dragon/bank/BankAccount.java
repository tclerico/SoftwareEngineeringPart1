package edu.ithaca.dragon.bank;

public class BankAccount {

    private String email;
    private double balance;

    /**
     * @throws IllegalArgumentException if email is invalid
     */
    public BankAccount(String email, double startingBalance){
        if (isEmailValid(email) && isAmountValid(startingBalance)){
            this.email = email;
            this.balance = startingBalance;
        }
        else {
            throw new IllegalArgumentException("Email address: " + email + " is invalid, cannot create account");
        }
    }

    public double getBalance(){
        return balance;
    }

    public String getEmail(){
        return email;
    }

    /**
     * @post reduces the balance by amount if amount is non-negative and smaller than balance
     * if amount is negative print error
     * if amount is greater than balance also print error
     */
    public void withdraw (double amount)  {
        if (isAmountValid(amount) && amount <= balance){
            balance -= amount;
        }
        else {
            throw new IllegalArgumentException("Invalid amount");
        }

    }

    /**
     * Checks to see if an email is valid.
     * A valid email is defined as a string containing an @ that is not the first character
     * also containing a period some # of characters after the @
     * @param email
     * @return True or False
     */
    public static boolean isEmailValid(String email){
        int amp = email.indexOf('@');
        int period = email.lastIndexOf('.');
        if (amp > 0 && period > amp+1){
            return true;
        }
        else {
            return false;
        }
    }

    /**
     * Checks to see if the input amount is valid
     * a valid amount is non-negative does not equal zero and has no more than 2 decimal places
     * @param amount
     * @return true or false
     */
    public static boolean isAmountValid(double amount){
        String[] split = String.valueOf(amount).split("\\.");
        if ( split[1].length() <= 2 && amount >= 0){
            return true;
        }else{
            return false;
        }
    }
}

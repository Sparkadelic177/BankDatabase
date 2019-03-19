import java.io.*;

interface BankInterface{
    public void deposit(String[] array);
    public void purchases(String[] array);
    public void payback(String[] array);

    //adding a new account to the list
    public Client open(String[] array);

    //removing an account from the list 
    public void close(String[] array);

    //modifying a account from the list 
    // public Client modify(String[] array);

}
import java.util.*;
import java.io.*;

public class Database implements BankInterface{ 
    HashMap<String ,Client>accounts = new HashMap<>();
    PrintWriter outputStream;
    Client person = new Client();
    Client client;


    //if the user has an exisiting account, then try a proper exception 

    // puts money into the users account for checkings
    public void deposit(String[] array){
        //getting the social security
        String ss = array[1];
        //getting the deposit
        double deposit = Double.parseDouble(array[2]);
        //get the person account in the database (hashmap)
        person = accounts.get(ss);
        if(person == null) {
            System.out.println("You dont have an account, please make one to desposit money");
            return;
        }
        person.checkings.balance += deposit; 
    }

    //adds money to the balance of the credit
    public void purchases(String[] array){
        person = accounts.get(array[1]);
        if(person == null) {
            System.out.println("You dont have an credit card account");
            return;
        }
        if(person.credit.getCredit() < Double.parseDouble(array[2])){
            System.out.print("You are going over your credit, try again");
            return;
        }
        person.credit.balance += Double.parseDouble(array[2]);
        System.out.println(person.credit.balance);
    }

    // takes money away from the checkings and subtracts it from the credit
    public void payback(String[] array){
        person = accounts.get(array[1]);
        if(person == null) {
            System.out.println("You dont have an credit card account");
            return;
        }
        if(person.checkings.balance < Double.parseDouble(array[2])){
            System.out.print("You dont have enough in your account to deposit, try again");
            return;
        }
        if(person.credit.balance < Double.parseDouble(array[2])){
            System.out.print("You are paying over your balance of " + person.credit.balance);
            return;
        }
        person.checkings.balance -= Double.parseDouble(array[2]);
        person.credit.balance -= Double.parseDouble(array[2]);
        System.out.println(person.credit.balance); 
    }

    //adding a new account to the list
    public Client open(String[] array){
        String name = array[1];
        String ss = array[2];
        double amount = Double.parseDouble(array[3]);
        Client existing;

        //if the user wants to open a credit account
        if(array[0].equals("OCCA")){
            //checking to see if the account alreay exists    
            existing = existingAccount(array, ss);
            if(existing == null){
                client = new Client(name, ss);
                accounts.put(ss,client);  
                return client;    
            }
            //if checkings exists then place the checkings data in contructor
            if(existing.checkings != null ){
                existing = new Client(existing.name, existing.socialSecurity, existing.checkings.balance, true);
                accounts.put(ss, existing); //replacing existing account
                return existing; //need to replace at the main file
            //if credit exist then open up another credit card account
            }else if(existing.credit != null){
                System.out.println("You already have an existing  Credit card account");
                return existing;
            }
        //if the user wants to open a checkings account
        }else if(array[0].equals("OCA")){ 
            existing = existingAccount(array, ss);
            if(existing == null)  {
                client = new Client(name, ss, amount, false);
                accounts.put(ss,client);  
                return client;     
            }
            if(existing.credit != null ){
                existing = new Client(existing.name, existing.socialSecurity, amount, existing.credit);
                accounts.put(ss, existing);
                return existing;
            } else if(existing.checkings != null){
                System.out.println("You already have an existing checkings account");
                return existing;
            }           
        }
        return client; 
    }

    // removing an account from the list 
    public void close(String[] array){
       person = accounts.remove(array[1]);
    }

    //modifying a account from the list 
    // public Client modify(String[] array){
        // return accounts.get(index);
    // }

    public Client existingAccount(String[] array, String ss){
            if(accounts.get(ss) == null) return null;
            if(array[1].equals(accounts.get(ss).name)){
                return accounts.get(ss);
            }
        return null;
    }

}
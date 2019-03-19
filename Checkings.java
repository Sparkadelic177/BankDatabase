public class Checkings{
    double balance;
    int accountNumber;

    //construct
    public Checkings(double balance){
        this.balance = balance; 
        accountNumber = (int)Math.floor(Math.random() * 100000);
    }

    //gettng the balance
    public double getBalance(){
        return balance;
    }

    public int  getAccountNumber(){
        return accountNumber;
    }


}
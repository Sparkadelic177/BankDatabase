public class Credit{
    double balance;
    double limit;
    int accountNumber;

    //construct
    public Credit(){ 
        balance = 0;
        limit = 500;
        accountNumber = (int)Math.floor(Math.random() * 100000);
    }

    //return balance
    public double getBalance(){
        return balance;
    }

    public double getCredit(){
        return (limit - balance);
    }

    public double getLimit(){
        return limit;
    }

    public int  getAccountNumber(){
        return accountNumber;
    }


}
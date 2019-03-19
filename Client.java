import java.util.ArrayList;

public class Client{
    String name;
    String socialSecurity;
    Checkings checkings;
    Credit credit;


    public Client(){};
    //constructor is someone wants to open a checkings only, boolean to open credit with existing checkings
    public Client(String name, String socialSecurity, double checkingsBalance, boolean creditcard){
        this.name = name;
        this.socialSecurity = socialSecurity;
        checkings = new Checkings(checkingsBalance);
        if(creditcard == true)  credit = new Credit(); 
    }

    //open checking with existing credit
    public Client(String name, String socialSecurity, double checkingsBalance, Credit card){
        this.name = name;
        this.socialSecurity = socialSecurity;
        checkings = new Checkings(checkingsBalance);
        credit = card;
    }

    //constructor if someone wants to open a credit card only
    public Client(String name, String socialSecurity){
        this.name = name;
        this.socialSecurity = socialSecurity;
        credit = new Credit();
    }



}
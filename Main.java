import java.util.*;
import java.io.*;


public class Main extends Database{
    static Main operation = new Main();  
    static Client person = new Client();
    static HashMap<String ,Client>accounts = new HashMap<>();
    static PrintWriter outputStream;
    static PrintWriter logging;
   
    
    
    // would the buffer classs slove this problem with tne stacks 
    public static void operations(String[] actions, int index){
        String[] action = actions[index].split("\\s");
        switch(action[0]){
            case "OCA":
                //when user makes an account save the user in the hashmap
                accounts.put(action[2],operation.open(action));
                logging.println("Checkings sccount opend successful for " + accounts.get(action[2]).name);
                break;
            case "OCCA":
                //when user makes an account save the user in the hashmap
                accounts.put(action[2], operation.open(action));
                logging.println("Credit Card account opend successful for " +  accounts.get(action[2]).name);
                break;
            case "DD":
                operation.deposit(action); 
                person = accounts.get(action[1]);
                if(accountChecking(action[1]) == false) return;
                logging.println( "deposit successful for " + person.name + " account of " + action[2] + " amount");
                break;
            case "PBCC":
                operation.payback(action); 
                person = accounts.get(action[1]);
                if(accountChecking(action[1]) == false) return;
                logging.println("payback successful for " + person.name + " account of " + action[2] + " amount");
                break;
            case "PWCC":
                operation.purchases(action); 
                person = accounts.get(action[1]);
                if(accountChecking(action[1]) == false) return;
                logging.println("purchase successful for " + person.name + " account of " + action[2] + " amount");
                break;
            case "CA":
                person = accounts.get(action[1]);
                if(accountChecking(action[1]) == false) return;
                operation.close(action);
                logging.println("The account named " + person.name + " has been removed");
                break;
            // case "MA":
            //     operation.modify(action);
            //     break;
            default:
                break;
        }
    
    }

    //method to check if the user had a account or not
    public static boolean accountChecking(String ss){
        person = accounts.get(ss);

        if(person == null){
            System.out.println("This person did not have an account");
            return false;
        }else return true;

    }


    public static void main(String[] args){

        Reader File_Reader = new Reader();
        String[] input = File_Reader.File_Reader();

        try{
            outputStream = new PrintWriter(new FileOutputStream("output.txt"), true);
            logging = new PrintWriter(new FileOutputStream("log.txt"), true);
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }

        //this loop gets all the text in the txt file
        for(int i = 0; i < input.length; i++){
            if(input[i] != null){
                //reads the line and sends it to the operation function
                operations(input, i);

            }
        }

        //this loop prints outs everything that stored in the database
        for(String key: accounts.keySet()){
            person = accounts.get(key);
            if(person.checkings != null && person.credit != null){
                outputStream.println(person.name + " has a checkings balance of:" + person.checkings.balance + " , and a credit balance of:" + person.credit.balance)   ;
            }else if(person.checkings != null){
                outputStream.println(person.name + " has a checkings balance of:" + person.checkings.balance);
            }else if(person.credit != null){
                outputStream.println(person.name + " has a credit balance of:" + person.credit.balance);
            }else{
                continue;
            }
        }
        
        //closess both streams.
        outputStream.close();
        logging.close();
     
    }
    
}
import java.io.*;
import java.util.*;

public class Reader{

    public String[] File_Reader(){ 

        //skip if line has a #
        //skip is line is empty
        //stop if the line is null
        int counter = 0;
        String words[] = new String[100];
        try{
           BufferedReader reader = new BufferedReader(new FileReader("input.txt"));
            String line = reader.readLine();
            while (line != null) {
                if(line.contains("#")){
                    line = reader.readLine();
                }else{
                    words[counter] = line;
                    // read next line
                    line = reader.readLine();
                    counter++;
                }
            }
            reader.close();            
        }catch (IOException e){
            e.printStackTrace();
        }
        return words;
    }


}

//wants a snapshot of the entire databse.
//eg list all clients names and their balance, a class that prints everybody in the database 
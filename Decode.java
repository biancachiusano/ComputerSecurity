import java.util.*;
import java.io.*;
import java.lang.reflect.Array;

public class Decode{

    public static void main(String[] args){
        
        System.out.print("Enter message: ");

        Scanner scan = new Scanner(System.in);
        String toDecode = scan.nextLine();

        System.out.println();
        //Perform frequency analysis
        Decoding dec = new Decoding(toDecode);
        String mostFrequent = dec.frequencyAnalysis();

    }


    
}
import java.util.*;
import java.io.*;
import java.lang.reflect.Array;

public class Decoding{

    String[] alphabet = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
    ArrayList<String> standard = new ArrayList<String>(Arrays.asList(alphabet));
   
    int max = 0;
    char letter = 'A';
    String message;

    public Decoding(String message){
        this.message = message;
    }

    public String frequencyAnalysis(){
    
        ArrayList<Character> arr_mess = new ArrayList<>();
        for(int i = 0; i < message.length(); i++){
            arr_mess.add(message.charAt(i));
        }
        
        char start =  recurse(arr_mess);
        return arrangeAlphabet(start, arr_mess);
    }

    public char recurse(ArrayList<Character> arr){
        
        if(arr.isEmpty()){
            return letter;
        }
        else{
            ArrayList<Character> newArr = new ArrayList<>();
            char current_letter = arr.get(0);
            int temp = 1;
            for(int j = 1; j < arr.size(); j++){
                if(arr.get(j) == current_letter){
                    temp++;
                }
                else{
                    newArr.add(arr.get(j));
                }
            }
     
            if(temp>max){
                max = temp;
                letter = current_letter;
            }

            return recurse(newArr);
        }
        
    }

    public String arrangeAlphabet(char start, ArrayList<Character> message){

        //Replace most frequent letter with e 

        ArrayList<String> ceasarAlph = new ArrayList<>();
        ArrayList<String> decodedMessage = new ArrayList<>();
        
        String s = Character.toString(start);
        int letterIndex = standard.indexOf(s.toLowerCase());

        int difference = letterIndex - 4;
        if(difference < 0){
            int temp_diff = standard.size() + difference;
            difference = temp_diff;
        }

        for(int i = difference; i < standard.size(); i++){ //e is at the 5th position in the standard alphabet
            
            ceasarAlph.add(standard.get(i));
        }

        int arr_diff = standard.size()-ceasarAlph.size();
        for(int j = 0; j < arr_diff; j++){ 
            ceasarAlph.add(standard.get(j));
        }

        
        // For Debugging purposes
        
        /*
        for(String st : standard){
            System.out.print(st);
        }
        System.out.println();
        for(String c : ceasarAlph){
            System.out.print(c);
        }
        System.out.println();
        */

        //switch letters 
        for(Character m: message){
            String str_m = Character.toString(m);
            int inx_m = ceasarAlph.indexOf(str_m.toLowerCase());
            decodedMessage.add(standard.get(inx_m));
        }
        
        System.out.print("The decoded message is: ");
        for(String d : decodedMessage){
            System.out.print(d);
        }
        System.out.println();
        return "hello";
    }
}
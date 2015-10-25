/*
Implement a method to perform basic string compression using the counts of
repeated characters. For example, the string aabcccccaaa would become
a2blc5a3. If the "compressed" string would not become smaller than the original
string, your method should return the original string.
*/
import java.util.*;
public class Compressor{
    public static String compressString(String input){
        // Return if null string
        if(input == null) return input;
        
        // string can't be compressed if less than 3 characters
        if(input.length() < 3) return input;
        
        StringBuilder myStr = new StringBuilder();
        char last = input.charAt(0);
        int count = 0;
        for(char c: input.toCharArray()){
            // We consider lowercase and upper case letters to be different
            if(c == last){
                count++;
            }else{
                myStr.append(last);
                myStr.append(count);
                last = c;
                count = 1;
            }
        }
        myStr.append(last);
        myStr.append(count);
        
        // Return whichever is smaller in length
        return (myStr.length() < input.length()? myStr.toString(): input);
    }
    
    public static void main(String[] args){
        System.out.println("'aabcccccaaa' compressed to - " + Compressor.compressString("aabcccccaaa"));
    }
}
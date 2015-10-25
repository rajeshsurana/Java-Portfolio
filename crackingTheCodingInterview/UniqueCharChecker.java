// To check if given string has unique characters or not
import java.util.*;
public class UniqueCharChecker{
    public static boolean isUniqueChars(String word){
        if(word.length() > 256) return false;

        boolean[] counter = new boolean[256];
        Arrays.fill(counter, false);
        for(char letter: word.toCharArray()){
            if(counter[letter])
                return false;
            else
                counter[letter] = true;
        }
        return true;
    }
    
    public static void main(String[] args){
        String str = "rajesh";
        if(UniqueCharChecker.isUniqueChars(str)){
            System.out.println(str + " : has unique characters.");
        }else{
            System.out.println(str + " : doesn't have unique characters.");
        }
    }
}
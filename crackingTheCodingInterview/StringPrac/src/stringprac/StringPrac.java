/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stringprac;

/**
 *
 * @author Rajesh
 */
public class StringPrac {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        StringPrac strDemo = new StringPrac();
        // TODO code application logic here
        // Test isUniqueChars2
        System.out.println(strDemo.isUniqueChars2("rajesh surana"));
        
        // Test isUniqueChars
        
        System.out.println(strDemo.isUniqueChars("rajesh surana"));
    }
    /*Implement an algorithm to determine if a string has all unique characters. What if
      you cannot use additional data structures?*/
    public boolean isUniqueChars2(String str){
        
        //Assuming string is in ASCII charset
        if(str.length() > 256){
            return false;
        }
        
        boolean[] char_set = new boolean[256];
        for(int i=0; i < str.length(); i++){
            int val = str.charAt(i);
            if(char_set[val]){
                return false;
            }else{
                char_set[val] = true;
            }
        }
      
        return true;
    }
    
    public boolean isUniqueChars(String str){
        
        //Assuming string contains only english alphabets
        int checker = 0;
        for(int i = 0; i < str.length(); i++){
            int val = str.toLowerCase().charAt(i) - 'a';
            if((checker & (1 << val)) > 0){
                return false;
            }else {
                checker |= (1 << val);
            }
        }
        return true;
    }
    
}

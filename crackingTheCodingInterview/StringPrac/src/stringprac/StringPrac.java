/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stringprac;

import java.util.Arrays; // isUniqueChars3
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
        System.out.println(strDemo.isUniqueChars2("rajesh surana"));//false
        System.out.println(strDemo.isUniqueChars2("rajesh"));//true
        
        // Test isUniqueChars
        System.out.println(strDemo.isUniqueChars("rajesh surana"));//false
        System.out.println(strDemo.isUniqueChars("rajesh"));//true
        
        // Test isUniqueChars3
        System.out.println(strDemo.isUniqueChars3("rajesh surana"));//false
        System.out.println(strDemo.isUniqueChars3("rajesh"));//true
        
        // Test permutation
        System.out.println(strDemo.permutation("rajesh", "ehsjra"));//true
        
        // Test permutation2
        System.out.println(strDemo.permutation("rajesh", "ehsjra "));//false
        
        // Test compress
        System.out.println(strDemo.compress("aabcccccaaa"));// a2blc5a3
        
        // Test isRotation
        System.out.println(strDemo.isRotation("waterbottLe", "erbottLewat"));//true
        System.out.println(strDemo.isRotation("waterbottLe", "erbottLewata"));//false
    }
    /*1.1 Implement an algorithm to determine if a string has all unique characters. What if
      you cannot use additional data structures?*/
    public boolean isUniqueChars2(String str){
        
        //Assuming string is in ASCII charset
        //Using boolean array of 256 size
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
        // Using one integer
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
    
    public boolean isUniqueChars3(String str){
        // Using sorting technique of arrays
        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        String sorted = new String(chars);
        for(int i = 0; i+1 < sorted.length(); i++ ){
            if(sorted.charAt(i) == sorted.charAt(i+1)){
                return false;
            }
        }
        return true; 
    }
    
    //1.3 Given two strings, write a method to decide if one is a permutation of the other.
    public String sort(String s){
        // Return sorted string
        char[] array = s.toCharArray();
        java.util.Arrays.sort(array);
        return new String(array);
    }
    
    public boolean permutation(String one, String two){
        // Decides whether two strings are permutation of each other or not
        if(one.length() != two.length()){
            return false;
        }
        return sort(one).equals(sort(two));
    }
    
    public boolean permutation2(String s, String t){
        // Checking count of each charecter in both strings
        if(s.length() != t.length()){
            return false;
        }
        char[] s_array = s.toCharArray();
        int[] letters = new int[256];
        // Count each charecter in string s
        for(char c: s_array){
            letters[c]++;
        }
        // Substract each charecter count from letters array
        for(int i = 0; i < t.length(); i++){
            if(--letters[t.charAt(i)] < 0){
                return false;
            }
        }
        return true;
    }
    
    /* 1.4 Write a method to replace all spaces in a string with '%20'. You may assume that the
        string has sufficient space at the end of the string to hold the additional characters,
        and that you are given the "true" length of the string. (Note: if implementing in Java,
        please use a character array so that you can perform this operation in place.)*/
    
    public void replaceSpaces(char[] str, int length){
        int countSpaces = 0;
        for(int i = 0; i < length; i++){
            if(str[i] == ' '){
                countSpaces++;
            }
            
        }
        int newLength = length + countSpaces * 2;
        str[newLength] = '\0';
        
        for(int i = length - 1; i >= 0; i--){
            if(str[i] == ' '){
                str[newLength - 1] = '0';
                str[newLength - 2] = '2';
                str[newLength - 3] = '%';
                newLength -= 3;
            }else{
                str[newLength - 1] = str[i];
                newLength -= 1;
            }
        }
    }
    
    /* 1.5 Implement a method to perform basic string compression using the counts of
        repeated characters. For example, the string aabcccccaaa would become
        a2blc5a3. If the "compressed" string would not become smaller than the original
        string, your method should return the original string.*/
    
    String compress(String str){
        // Return original string if compressed string is larger
        if(countCompression(str) > str.length()){
            return str;
        }
        
        StringBuffer mystr = new StringBuffer();
        int count = 1;
        char last = str.charAt(0);
        for(int i = 1; i < str.length(); i++){
            if(str.charAt(i) == last){
                count++;
            }else{
                mystr.append(last);
                mystr.append(count);
                last = str.charAt(i);
                count = 1;
            }
        }
        mystr.append(last);
        mystr.append(count);
        return mystr.toString();
    }
    
    int countCompression(String str){
        // Return zero is string is null or empty
        if(str == null || str.isEmpty()){
            return 0;
        }
        char last = str.charAt(0);
        int count = 1;
        int size = 0;
        // Count the size of compression
        for(int i = 1; i < str.length(); i++){
            if(str.charAt(i) == last){
                count++;
            }else{
                size += 1 + String.valueOf(count).length();
                last = str.charAt(i);
                count = 1;
            }
        }
        size += 1 + String.valueOf(count).length();        
        return size;
    }
    /* 1.8 Assume you have a method isSubstring which checks if one word is a substring
        of another. Given two strings, si and s2, write code to check Ifs2 is a rotation of si
        using only onecalltoisSubstring (e.g., "waterbottLe" is a rotation of "erbottLewat").*/
    
    boolean isRotation(String s1, String s2){
        int len = s1.length();
        // Check if both string are of same length and non-empty
        if(len == s2.length() && len > 0){
            String s1s1 = s1+s1;
            if(s1s1.indexOf(s2) >= 0){// s1s1.contains(s2)
                return true;
            }
        }
        return false;
    }
}


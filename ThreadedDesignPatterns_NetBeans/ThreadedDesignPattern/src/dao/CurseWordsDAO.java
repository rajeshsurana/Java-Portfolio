/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Arrays;

/**
 *
 * @author Rajesh Surana
 */
public class CurseWordsDAO {
        public static String[] getAllCurseWords(){
        String[] characterList = null;
         try (BufferedReader reader = new BufferedReader(
                new FileReader("src/resources/curseWords.txt"))){
             characterList = reader.readLine().trim().split(" ");
         }
         catch(Exception e){
             System.out.println("dao.CurseWordsDAO.getAllCurseWords(): " + Arrays.toString(e.getStackTrace()));
         }
     return characterList;            
    }
}

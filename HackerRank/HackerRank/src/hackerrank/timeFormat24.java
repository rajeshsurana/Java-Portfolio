/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hackerrank;
import java.util.*;
/**
 *
 * @author Rajesh
 */
/*  You are given time in AM/PM format. Convert this into a 24 hour format.
    Note Midnight is 12:00:00AM or 00:00:00 and 12 Noon is 12:00:00.*/

public class timeFormat24 {
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);
        String inTime = in.nextLine();
        StringBuffer sb = new StringBuffer();
        int hour = 0;
        hour = Integer.parseInt(inTime.substring(0, 2));
        if(inTime.substring(8, 10).equals("PM")){
            if(hour != 12)
                hour = (hour + 12);
        }else if(hour == 12){
            hour = 0;
        }
        if(hour < 10){
            sb.append(0);
        }
        sb.append(hour);
        sb.append(inTime.substring(2, 8));
        System.out.println(sb.toString());
    }
}

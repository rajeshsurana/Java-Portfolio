package hackerrank;
import java.util.*;

public class StairCase {

        public static void stairCase() {
       
        int height = in.nextInt();
        for(int i = 0; i < height; i++){
           for(int x=0; xheight-1;x++){
                System.out.print(" ");
            }
            for(int y=0; y<i;y++){
            System.out.print("#");
            }
            System.out.println();
        }
           

}

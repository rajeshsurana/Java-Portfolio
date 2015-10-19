import java.util.*;
public class PrimeSieve{
    public static String PrimeFinder(int n){
        boolean[] prime = new boolean[n+1];
        
        //Initially assume all elements to be prime
        Arrays.fill(prime, true);
        prime[0] = false;
        prime[1] = false;
        
        // Find prime
        for(int i=2; i*i <= n; i++){
            if(prime[i]){
                
                // Eliminate multiple of prime
                for(int j=i; j*i <= n; j++){
                    prime[i*j] = false;
                }
            }
        }
        
        // Process and return result
        StringBuilder sb = new StringBuilder();
        for(int i=2; i<= n; i++){
            if(prime[i]){
                sb.append(i);
                sb.append(" ");
            }
        }
        
        return sb.toString();
    }
    
    public static void main(String[] args){
        System.out.println(PrimeSieve.PrimeFinder(1000));
    }
}
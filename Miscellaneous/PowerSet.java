// Find powerset of given set
import java.util.*;

public class PowerSet<T>{
    
    public Set<Set<T>> findPowerSet(Set<T> originalSet){
        Set<Set<T>>  powerSet =   new HashSet<Set<T>>();
        ArrayList<T> originalList = new ArrayList<T>(originalSet);
        
        // Add one empty set
        Set<T> emptySet =  new HashSet<T>(); 
        powerSet.add(emptySet);
        
        // Now according to binary 1 value add corresponding member of original list in set
        int size = originalList.size();
        for(int i = 0; i < (1<<size); i++){
            Set<T> set = new HashSet<T>();
            for(int j=0; j < size; j++){
                if((i>>j)%2 == 1){
                    set.add(originalList.get(j));
                }
            }
            // add set to powerSet
            powerSet.add(set);
        }
        
        return powerSet;
    }
    
    public static void main(String[] args){
        PowerSet<Integer> ps = new PowerSet<Integer>();
        Set<Integer> originalSet = new HashSet<Integer>();
        originalSet.add(1);
        originalSet.add(2);
        originalSet.add(3);
        Set<Set<Integer>> powerSet = ps.findPowerSet(originalSet);
        Iterator<Set<Integer>> iter = powerSet.iterator(); 
        while(iter.hasNext()){
            System.out.println(iter.next().toString());
        }
    }
}
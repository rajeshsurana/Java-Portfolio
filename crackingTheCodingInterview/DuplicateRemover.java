/*
Write code to remove duplicates from an unsorted linked list.
*/
/*Solution-
If we use toArray of Linked list and then Sort the array we can remove
duplicates is O(nlogn) time. 
Lets do it in O(n). 
*/

import java.util.*;

public class DuplicateRemover{
    
    public static void removeDuplicates(LinkedList iLinkedList){
        // Return if empty or only one element in the list
        if(iLinkedList.size() < 2) return;
        HashMap<Integer, Boolean> hashMap = new HashMap();

        int i=0;
        for(i=0; i< iLinkedList.size(); i++){
            // Remove if already in hashmap
            Integer ele = (Integer)iLinkedList.get(i);
            if(hashMap.containsKey(ele)){
                iLinkedList.remove(i);
                i--;
            }else{
                // Put in hashmap
                hashMap.put(ele, true);
            }
        }
    }
    
    public static void main(String[] args){
        LinkedList<Integer> linkedList = new LinkedList();
        linkedList.add(7);
        linkedList.add(7);
        linkedList.add(6);
        linkedList.add(6);
        DuplicateRemover.removeDuplicates(linkedList);
        ListIterator iterator = linkedList.listIterator();
        while(iterator.hasNext()){
            System.out.print(iterator.next() + " ");
        }
    }
}
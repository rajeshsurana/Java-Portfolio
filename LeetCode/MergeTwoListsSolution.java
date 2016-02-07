/*
Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists.
*/
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class MergeTwoListsSolution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode sorted = new ListNode(0);
        ListNode head = sorted;
        while(l1!=null && l2!=null){
            if(l1.val < l2.val){
                sorted.next = l1;
                l1 = l1.next;
            }else{
                sorted.next = l2;
                l2 = l2.next;
            }
            sorted = sorted.next;
        }
        if(l1 != null){
            sorted.next = l1;
        }else if(l2 != null){
            sorted.next =l2;
        }
        return head.next;
    }
}
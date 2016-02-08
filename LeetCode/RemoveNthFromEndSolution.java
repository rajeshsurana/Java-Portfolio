/*
Given a linked list, remove the nth node from the end of list and return its head.

For example,

   Given linked list: 1->2->3->4->5, and n = 2.

   After removing the second node from the end, the linked list becomes 1->2->3->5.
Note:
Given n will always be valid.
Try to do this in one pass.
*/
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class RemoveNthFromEndSolution {
    public ListNode removeNthFromEnd(ListNode head, int n){
        ListNode first = head;
        while(n>0 && first!= null){
            first = first.next;
            n--;
        }
        ListNode second = head;
        while(first != null && first.next != null){
            first = first.next;
            second = second.next;
        }
        // first == null only if we have to remove head node
        if(first == null){
            return head.next;
        }
        second.next = second.next.next;
        return head;
    }
}
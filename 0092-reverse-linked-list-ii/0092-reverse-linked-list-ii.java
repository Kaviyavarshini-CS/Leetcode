/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(head==null || left==right){
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = null;
        ListNode current = dummy;
        for(int i=0;i<left;i++){
            prev = current;
            current = current.next;
        }
        ListNode temp = current;
        prev.next = null;
        ListNode pre = null;
        ListNode nxt = null;
        for(int i=0;i<=right-left;i++){
            nxt = current.next;
            current.next = pre;
            pre = current;
            current = nxt;
        }
        prev.next = pre;
        temp.next = current;
        return dummy.next;
    }
}
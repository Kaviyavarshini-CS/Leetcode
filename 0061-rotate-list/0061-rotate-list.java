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
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null || head.next==null || k==0){
            return head;
        }
        ListNode temp = head;
        int len = 1;
        while(temp.next!=null){
            len = len+1;
            temp = temp.next;
        }
        if(k%len==0){
            return head;
        }
        k = k%len;
        temp = head;
        ListNode prev = null;
        for(int i=0;i<len-k;i++){
            prev = temp;
            temp = temp.next;
        }
        prev.next = null;
        ListNode current = temp;
        while(temp.next!=null){
            temp = temp.next;
        }
        temp.next = head;
        return current;
    }
}
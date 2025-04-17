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
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ArrayList<Integer> A = new ArrayList<>();
        while(head!=null){
            A.add(head.val);
            head = head.next;
        }
        Collections.sort(A);
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        for(int val : A){
            ListNode nn = new ListNode(val);
            current.next = nn;
            current = nn;
        }
        return dummy.next;
    }
}
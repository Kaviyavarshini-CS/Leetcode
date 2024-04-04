/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     struct ListNode *next;
 * };
 */
struct ListNode* oddEvenList(struct ListNode* head) {
    if (head == NULL || head->next == NULL) {
        return head;
    }

    struct ListNode *odd = head;
    struct ListNode *even = head->next;
    struct ListNode *evenHead = even; // Head of even list

    while (even != NULL && even->next != NULL) {
        odd->next = even->next; // Connect odd list to next odd node
        odd = odd->next; // Move to next odd node

        even->next = odd->next; // Connect even list to next even node
        even = even->next; // Move to next even node
    }

    // Append even list to the end of odd list
    odd->next = evenHead;

    return head;
}
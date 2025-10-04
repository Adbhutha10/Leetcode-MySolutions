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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // Step 1: Find the length of the list
        int size = 0;
        ListNode temp = head;
        while (temp != null) {
            size++;
            temp = temp.next;
        }

        // Step 2: If we need to remove the first node
        if (n == size) {
            return head.next;
        }

        // Step 3: Find the node just before the one to remove
        int i = 1;
        int indexToFind = size - n;
        ListNode prev = head;
        while (i < indexToFind) {
            prev = prev.next;
            i++;
        }

        // Step 4: Remove the nth node from end
        prev.next = prev.next.next;

        // Step 5: Return head of the modified list
        return head;
    }
}

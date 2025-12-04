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
public class Solution {
        public ListNode mergeKLists(ListNode[] lists) {

            if (lists == null || lists.length == 0) {
                return null;
            }

            // same as merge sort array
            return merge(lists, 0, lists.length - 1);
        }

        public ListNode merge(ListNode[] lists, int start, int end) {

            // single list
            if (start == end) {
                return lists[start];
            }

            int mid = (end - start) / 2 + start;
            ListNode leftHalf = merge(lists, start, mid);
            ListNode rightHalf = merge(lists, mid + 1, end);

            return mergeTwoLists(leftHalf, rightHalf);
        }

        // from previous question: 21 Merge Two Sorted Lists
        public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

            ListNode dummy = new ListNode(0);
            ListNode current = dummy;

            while (l1 != null || l2 != null) {
                int v1 = (l1 == null ? Integer.MAX_VALUE : l1.val);
                int v2 = (l2 == null ? Integer.MAX_VALUE : l2.val);

                if (v1 < v2) {
                    current.next = l1;
                    l1 = l1.next;
                } else {
                    current.next = l2;
                    l2 = l2.next;
                }

                current = current.next; // now current is the new end node, but still pointing to next node
                current.next = null; // @note: key, cut this node from l1 or l2
            }

            return dummy.next;
        }
    }
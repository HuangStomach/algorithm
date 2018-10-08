/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode top = head;

        while (l1 != null || l2 != null) {
            if (l2 != null && l2.val <= l1.val) {
                ListNode temp = new ListNode(l2.val);
                head.next = temp;
                head = head.next;
                l2 = l2.next;
                continue;
            }

            if (l1 != null && l1.val <= l2.val) {
                ListNode temp = new ListNode(l1.val);
                head.next = temp;
                head = head.next;
                l1 = l1.next;
                continue;
            }
        }
        return top.next;
    }
}
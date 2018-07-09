/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null) return head;
        
        ListNode top = head;
        while (head.next != null) {
            ListNode next = head.next;
            head.next = next.next;
            next.next = top;
            top = next;
        }
        return top;
    }
}
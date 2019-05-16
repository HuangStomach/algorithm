/**
 * 两两交换链表中的节点
 * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;
        
        ListNode res = head.next;
        ListNode top = new ListNode(0);
        top.next = head;
        
        while (true) {
            ListNode before = top.next;
            if (before == null) break;
            ListNode after = before.next;
            if (after == null) break;
            before.next = after.next;
            after.next = before;
            top.next = after;
            top = before;
        }

        return res;
    }
}
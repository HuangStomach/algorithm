/**
 * 相交链表
 * 编写一个程序，找到两个单链表相交的起始节点。
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode A = headA;
        ListNode B = headB;

        while (A != B) {
            if (A == null) A = headA;
            else A = A.next;
            if (B == null) B = headB;
            else B = B.next;
        }
        return A;
    }
}

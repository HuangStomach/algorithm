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

        int a = 0;
        while (A != null) {
            A = A.next;
            a++;
        }

        int b = 0;
        while (B != null) {
            B = B.next;
            b++;
        }

        if (b > a) {
            int c = b - a;
            for (int i = 0; i < c; i++) {
                ListNode C = new ListNode(0);
                C.next = headA;
                headA = C;
            }
        }
        else {
            int c = a - b;
            for (int i = 0; i < c; i++) {
                ListNode C = new ListNode(0);
                C.next = headB;
                headB = C;
            }
        }

        while (headA != null) {
            if (headA == headB) return headA;
            headA = headA.next;
            headB = headB.next;
        }
        return null;
    }
}

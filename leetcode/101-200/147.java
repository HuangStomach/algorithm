/**
 * 对链表进行插入排序
 * 对链表进行插入排序。
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode insertionSortList(ListNode head) {
        ListNode top = new ListNode(-1);
        ListNode pre = top;
        top.next = head;

        while (head != null && head.next != null) {
            if (head.val <= head.next.val) {
                head = head.next;
                continue;
            }

            pre = top;
            while (pre.next.val < head.next.val) {
                pre = pre.next;
            }

            ListNode cur = head.next;
            head.next = cur.next;
            cur.next = pre.next;
            pre.next = cur;
        }

        return top.next;
    }
}
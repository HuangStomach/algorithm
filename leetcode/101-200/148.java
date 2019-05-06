
/**
 * 排序链表
 * O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序。
 * Definition for singly-linked list.
 * public class ListNode {
 *    int val;
 *    ListNode next;
 *    ListNode(int x) { val = x; }
 }
 */
class Solution {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode slow = head;
        ListNode fast = head;
        ListNode pre = head;

        while (fast != null && fast.next != null) {
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        pre.next = null; // 切割两处链表
        return merge(sortList(head), sortList(slow));
    }
    public ListNode merge(ListNode l1, ListNode l2) {
        if (l1 == null) return l2; // 当任一段链表发现断开，则链接
        if (l2 == null) return l1;
        if (l1.val < l2.val) {
            l1.next = merge(l1.next, l2);
            return l1;
        } else {
            l2.next = merge(l1, l2.next);
            return l2;
        }
    }
}
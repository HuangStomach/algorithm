/**
 * 删除排序链表中的重复元素 II
 * 给定一个排序链表，删除所有含有重复数字的节点，只保留原始链表中 没有重复出现 的数字。
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return head;
        ListNode node = new ListNode(head.val - 1);
        node.next = head;
        head = node;
        while (node != null) {
            if (node.next != null && node.next.next != null) {
                int val = node.next.val;
                ListNode temp = node.next;
                if (val == node.next.next.val) {
                    while (temp != null && val == temp.val) {
                        temp = temp.next;
                    }
                    node.next = temp;
                    continue;
                }
            }
            node = node.next;
        }
        return head.next;
    }
}
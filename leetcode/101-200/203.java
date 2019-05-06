/**
 * 移除链表元素
 * 删除链表中等于给定值 val 的所有节点。
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode removeElements(ListNode head, int val) {
        ListNode header = new ListNode(-1);
        header.next = head;
        ListNode node = header;
        while (node.next != null){
            if (node.next.val == val) node.next = node.next.next;
            else node = node.next;
        }
        return header.next;
    }
}
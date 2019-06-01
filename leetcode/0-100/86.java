/**
 * 分隔链表
 * 给定一个链表和一个特定值 x，对链表进行分隔，使得所有小于 x 的节点都在大于或等于 x 的节点之前。
 * 你应当保留两个分区中每个节点的初始相对位置。
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode(int x) { val = x; } }
 */
class Solution {
    public ListNode partition(ListNode head, int x) {
        Queue<ListNode> q = new LinkedList<>();
        ListNode p = new ListNode(0);
        p.next = head;
        head = p;

        while (p.next != null) {
            if (p.next.val >= x) {
                q.offer(p.next);
                p.next = p.next.next;
            } else {
                p = p.next;
            }
        }
        while (!q.isEmpty() && p != null) {
            p.next = q.poll();
            p = p.next;
        }
        p.next = null; // 一定要有这一步，否则会连接到别的点，无限循环连接，造成超出时间

        return head.next;
    }
}

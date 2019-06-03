/**
 * 反转链表 II
 * 反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。
 */
import java.util.Stack;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null) return head;

        int index = 0;
        ListNode top = new ListNode(0);
        top.next = head;

        ListNode node = top;
        while (index < m - 1) {
            index++;
            node = node.next;
        }

        ListNode temp = node;
        Stack<ListNode> stack = new Stack<>();
        while (m <= n) {
            m++;
            temp = temp.next;
            stack.push(temp);
        }

        ListNode next = temp.next;

        while (stack.size() > 0) {
            node.next = stack.pop();
            node = node.next;
        }
        node.next = next;

        return top.next;
    }
}

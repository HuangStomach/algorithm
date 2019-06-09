/**
 * 环形链表 II
 * 给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
 * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。
 */
class Solution {
    /** 
     * 算法证明：
     *    设快慢指针第一次相遇时，fast走了f步，slow走了s步，
     *    设环的长度为c，从表头到入环点需走t步，那么：
     *（1）当fast指针追上slow指针时，fast比slow多走了n个环的长度，即 f = s + n * c；
     *（2）同时，因为fast一次走2步，slow一次走1步，因此有 f = 2s；
     *    由此可得：s = n * c，f = 2 * n * c
     * 
     *    将slow退到起始点，fast不动，然后每人一次各走一步：
     * 当slow走到入环点时，它走了t（ = 0 * c + t ）步；而此时fast走了 2 * n * c + t 步，也到达了入环点
     * 说明他们正好相遇在了入环点。
     */
    public ListNode detectCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        boolean hasCycle = false;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                hasCycle = true;
                break;
            }
        }

        if (!hasCycle) {
            return null;
        }

        slow = head;
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }

        return fast;
    }
}

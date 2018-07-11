/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) return true;

        ListNode slow = head;
        ListNode fast = head;
        ListNode tail = slow;

        //快慢指针，遍历到中点位置，逆序记录前半段节点值
        while (fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
            
            ListNode temp = new ListNode(slow.val);
            temp.next = tail;
            tail = temp;
        }

        if (fast.next != null) slow = slow.next;

        while (slow != null) {
            if (tail.val != slow.val) return false;
            tail = tail.next;
            slow = slow.next;
        }
        
        return true;
    }
}
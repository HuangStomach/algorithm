/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode current = head;
        ListNode rn = head;
        ListNode pn = null;
        
        int count = 1;
        
        while (current.next != null){
            current = current.next;
            if (count < n) {
                count++;
            }
            else {
                pn = rn;
                rn = rn.next;
            }
        }
        
        if (rn == head) {
            rn = rn.next;
            head = rn;
        }
        else {
            pn.next = rn.next;
        }
        return head;
    }
}

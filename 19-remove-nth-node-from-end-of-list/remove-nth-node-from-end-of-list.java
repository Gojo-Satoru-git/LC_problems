/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int len = 0;
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode p = head;
        while(p!=null){
            p = p.next;
            ++len;
        }
        int pos = 0;
        p = dummy;
        while(pos < (len - n)){
            ++pos;
            p = p.next;
        }
        p.next = p.next == null ? null : p.next.next;
        return dummy.next;
    }
}
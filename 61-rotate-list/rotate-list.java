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
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null)return head;
        int len = 1;
        ListNode p = head ;
        while(p.next != null){
            p = p.next ;
            ++len;
        }
        k = k % len ;
        if (k == 0) return head;
        ListNode tail = p;
        ListNode temp = head;
        p = head ;
        int i = 0;
        while( i < len - k - 1){
            ++i;
            p = p.next;
        }
        head = p.next;
        tail.next = temp;
        p.next = null;
        return head;
    }
}
class Solution {
    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null) return true;
        ListNode slow = head, fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode head2 = (fast == null) ? slow : slow.next;
        ListNode prev = null, curr = head;
        while(curr != slow){
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        while(prev != null && head2 != null){
            if(prev.val != head2.val) return false;
            prev = prev.next;
            head2 = head2.next;
        }
        return true;
    }
}

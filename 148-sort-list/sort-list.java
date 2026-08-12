class Solution {
    private ListNode findMid(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    private ListNode merge(ListNode left, ListNode right) {
        ListNode dummy = new ListNode(-1);
        ListNode tail = dummy;

        while (left != null && right != null) {
            if (left.val <= right.val) {
                tail.next = left;
                left = left.next;
            } else {
                tail.next = right;
                right = right.next;
            }
            tail = tail.next;
        }
        if (left != null) tail.next = left;
        if (right != null) tail.next = right;
        return dummy.next;
    }
    private ListNode mergeSort(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode mid = findMid(head);
        ListNode rightHead = mid.next;
        mid.next = null; 
        ListNode left = mergeSort(head);
        ListNode right = mergeSort(rightHead);

        return merge(left, right);
    }

    public ListNode sortList(ListNode head) {
        return mergeSort(head);
    }
}

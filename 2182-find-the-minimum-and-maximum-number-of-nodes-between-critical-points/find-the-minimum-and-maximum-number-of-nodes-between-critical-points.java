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
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        if(head == null || head.next == null)return new int[]{-1,-1};
        ListNode p = head.next;
        ListNode prev = head;
        ListNode next = p.next;
        int firstCritical = -1;
        int lastCritical = -1;
        int secondLastCritical = -1;
        int idx = 1;
        while(next != null){
            boolean isLocalMaxima = (p.val > prev.val && p.val > next.val);
            boolean isLocalMinima = (p.val < prev.val && p.val < next.val);
            if(isLocalMaxima || isLocalMinima){
                if(firstCritical == -1){
                    firstCritical = idx;
                }else{
                    if(lastCritical == -1){
                        min = idx - firstCritical;
                    }
                    secondLastCritical = lastCritical;
                    lastCritical = idx;
                    min = (lastCritical != -1 && secondLastCritical != -1) ? Math.min(min,lastCritical - secondLastCritical) : min;
                }
            }
            ++idx;
            prev = p;
            p = next;
            next = next.next;
        }
        max = (lastCritical != -1 && firstCritical != -1) ? Math.max(max,lastCritical - firstCritical) : max;
        return max == Integer.MIN_VALUE? new int[]{-1,-1} : new int[]{min,max};
    }
}
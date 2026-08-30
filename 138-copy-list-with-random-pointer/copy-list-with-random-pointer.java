/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        Map<Node,Node> mp = new HashMap<>();
        Node p = head;
        while(p != null){
            mp.put(p,new Node(p.val));
            p = p.next;
        }
        p = head;
        while(p != null){
            Node nn = mp.get(p);
            nn.next = mp.getOrDefault(p.next,null);
            nn.random = mp.getOrDefault(p.random,null);
            p = p.next;
        }
        return mp.get(head);
    }
}
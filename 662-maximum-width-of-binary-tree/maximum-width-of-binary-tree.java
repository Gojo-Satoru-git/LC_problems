/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    class Pair{
        TreeNode node;
        long pos;
        Pair(TreeNode node, long pos){
            this.node = node;
            this.pos = pos;
        }
    }
    public int widthOfBinaryTree(TreeNode root) {
        Queue<Pair> q = new ArrayDeque<>();
        int res = 0;
        q.offer(new Pair(root,0));
        while(!q.isEmpty()){
            int size = q.size();
            long first = 0;
            long last = 0;
            for(int i = 0 ; i < size ; ++i){
                Pair p = q.poll();
                if(i == 0)first = p.pos;
                if(i == size - 1)last = p.pos;
                if(p.node.left != null)q.offer(new Pair(p.node.left,2L * p.pos + 1));
                if(p.node.right != null)q.offer(new Pair(p.node.right,2L * p.pos + 2));
            }
            res = Math.max(res,(int)(last - first)+1);
        }
        return res;
    }
}
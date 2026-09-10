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
    int res;
    private int[] f(TreeNode root){
        if(root == null)return new int[]{0,0};
        int[] leftSubtree = f(root.left);
        int[] rightSubtree = f(root.right);
        int numberOfNodes = 1 + leftSubtree[0] + rightSubtree[0];
        int sum = root.val + leftSubtree[1] + rightSubtree[1];
        int avg = Math.round(sum/numberOfNodes);
        if(root.val == avg)++res;
        return new int[]{numberOfNodes, sum};
    }
    public int averageOfSubtree(TreeNode root) {
        f(root);
        return res;
    }
}
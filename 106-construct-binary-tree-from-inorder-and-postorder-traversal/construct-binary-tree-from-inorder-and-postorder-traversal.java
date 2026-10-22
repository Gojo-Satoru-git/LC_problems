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
    int idx;
    Map<Integer,Integer> inorderIndex;
    private TreeNode f(int i,int j,int[] inorder , int[] postorder){
        if(j < i || idx < 0)return null;
        int rindex = inorderIndex.get(postorder[idx]);
        TreeNode node = new TreeNode(postorder[idx--]);
        if(i == j)return node;
        node.right = f(rindex+1,j,inorder,postorder);
        node.left = f(i,rindex-1,inorder,postorder);
        return node;
    }
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        inorderIndex = new HashMap<>();
        int n = inorder.length; 
        idx = n-1;
        for(int i =  0 ; i < n ; ++i){
            inorderIndex.put(inorder[i],i);
        }
        TreeNode root = f(0,n-1,inorder,postorder);
        return root;
    }
}
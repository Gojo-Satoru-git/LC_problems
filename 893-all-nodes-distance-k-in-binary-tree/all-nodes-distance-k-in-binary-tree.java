/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    List<Integer> res;
    private void kidnapKthChildren(TreeNode node,int k){
        if(node == null)return;
        if(k == 0){
            res.add(node.val);
            return;
        }
        kidnapKthChildren(node.left,k-1);
        kidnapKthChildren(node.right,k-1); 
    }
    public int f(TreeNode root, TreeNode target, int k) {
        if(root == null)return -1;
        if(root == target){
            kidnapKthChildren(root,k);
            return 0;
        }
        int left = f(root.left,target,k);
        if(left != -1){
            int distanceFromTarget = left + 1;
            if(distanceFromTarget == k){
                res.add(root.val);
            }else{
                kidnapKthChildren(root.right,k - distanceFromTarget - 1);
            }
            return distanceFromTarget;
        }
        int right = f(root.right,target,k);
        if(right != -1){
            int distanceFromTarget = right + 1;
            if(distanceFromTarget == k){
                res.add(root.val);
            }else{
                kidnapKthChildren(root.left,k - distanceFromTarget - 1);
            }
            return distanceFromTarget;
        }
        return -1;

    }
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        res = new ArrayList<>();
        f(root,target,k);
        return res;
    }
}
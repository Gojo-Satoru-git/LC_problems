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

    private void inorder(TreeNode root, List<Integer> nodes) {
        if (root == null) return;
        inorder(root.left, nodes);
        nodes.add(root.val);
        inorder(root.right, nodes);
    }
    private TreeNode buildBST(int left, int right, List<Integer> nodes) {
        if (left > right) return null;

        int mid = (left + right) / 2; 
        TreeNode root = new TreeNode(nodes.get(mid));
        root.left = buildBST(left, mid - 1, nodes);
        root.right = buildBST(mid + 1, right, nodes);
        return root;
    }
    public TreeNode balanceBST(TreeNode root) {
        List<Integer> nodes = new ArrayList<>();
        inorder(root, nodes);
        return buildBST(0, nodes.size() - 1, nodes);
    }
}
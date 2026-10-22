/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    private int idx;

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        preorder(root, sb);
        return sb.toString();
    }
    private void preorder(TreeNode node, StringBuilder sb) {
        if (node == null) {
            sb.append("#,");
            return;
        }

        sb.append(node.val).append(",");
        preorder(node.left, sb);
        preorder(node.right, sb);
    }
    public TreeNode deserialize(String data) {
        String[] arr = data.split(",");
        idx = 0;
        return build(arr);
    }
    private TreeNode build(String[] arr) {
        if (idx >= arr.length || arr[idx].equals("#")) {
            idx++;
            return null;
        }
        TreeNode node = new TreeNode(Integer.parseInt(arr[idx++]));
        node.left = build(arr);
        node.right = build(arr);
        return node;
    }
}

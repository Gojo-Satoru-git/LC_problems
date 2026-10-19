class Solution {
    private TreeNode traverse(TreeNode root, TreeNode rightfullRight) {
        if (root == null) return null;

        TreeNode left = root.left;
        TreeNode right = root.right;
        TreeNode leftTail = traverse(
            left,
            right != null ? right : rightfullRight
        );
        TreeNode rightTail = traverse(right, rightfullRight);
        root.left = null;
        if (left != null) {
            root.right = left;
            if (leftTail != null) {
                leftTail.right = right != null ? right : rightfullRight;
            }
        } else {
            root.right = right != null ? right : rightfullRight;
        }
        if (right != null) return rightTail;
        if (left != null) return leftTail;
        return root;
    }
    public void flatten(TreeNode root) {
        traverse(root, null);
    }
}
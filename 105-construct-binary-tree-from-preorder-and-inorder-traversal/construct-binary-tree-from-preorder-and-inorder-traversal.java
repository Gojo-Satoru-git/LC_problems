class Solution {
    HashMap<Integer, Integer> index;
    int idx;

    private TreeNode build(int i, int j, int[] preorder, int[] inorder) {
        if (i > j || idx >= preorder.length) {
            return null;
        }
        int val = preorder[idx++];
        TreeNode node = new TreeNode(val);
        int rindex = index.get(val);
        node.left = build(i, rindex - 1, preorder, inorder);
        node.right = build(rindex + 1, j, preorder, inorder);
        return node;
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        index = new HashMap<>();
        idx = 0;
        for (int i = 0; i < inorder.length; i++) {
            index.put(inorder[i], i);
        }
        return build(0, inorder.length - 1, preorder, inorder);
    }
}


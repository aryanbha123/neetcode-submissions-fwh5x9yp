class Solution {
    Map<Integer, Integer> index = new HashMap<>();
    int preIndex = 0;

    public TreeNode build(int[] preorder, int left, int right) {
        // base case
        if (left > right) return null;

        // pick current root from preorder
        int rootVal = preorder[preIndex++];
        TreeNode root = new TreeNode(rootVal);

        // find index in inorder
        int mid = index.get(rootVal);

        // build left and right subtree
        root.left = build(preorder, left, mid - 1);
        root.right = build(preorder, mid + 1, right);

        return root;
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // store inorder indices
        for (int i = 0; i < inorder.length; i++) {
            index.put(inorder[i], i);
        }

        return build(preorder, 0, inorder.length - 1);
    }
}
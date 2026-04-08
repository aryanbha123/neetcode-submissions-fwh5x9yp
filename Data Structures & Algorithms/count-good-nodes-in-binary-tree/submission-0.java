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
    int good;
    public void helper(TreeNode root, int max) {
        if(root == null) return;
        int maxi =  Math.max(root.val , max);
        if(root.val == maxi) good++;

        helper(root.left, maxi);
        helper(root.right, maxi);

        return;
    }
    public int goodNodes(TreeNode root) {
        helper(root,Integer.MIN_VALUE);
        return good;
    }
}

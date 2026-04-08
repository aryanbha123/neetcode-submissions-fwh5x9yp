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
    public boolean helper(TreeNode root,int max, int min){
        if(root == null) return true;
        if(max <= root.val || min >= root.val) return false;
        
        return helper(root.left,root.val,min) && helper(root.right,max,root.val);
    }
    public boolean isValidBST(TreeNode root) {
        return helper(root,Integer.MAX_VALUE, Integer.MIN_VALUE);
    } 
}

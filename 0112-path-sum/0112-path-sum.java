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
    public boolean hasPathSum(TreeNode root, int targetSum) {
        int total = 0;
        boolean ans = findSum(root, targetSum, total);
        return ans;
    }
    public boolean findSum(TreeNode root, int sum, int total){
        if(root==null){
            return false;
        }
        total = total + root.val;
        if(root.left==null && root.right==null){
            if(total==sum){
                return true;
            }
            else {
                return false;
            }
        }
        boolean left = findSum(root.left, sum, total);
        boolean right = findSum(root.right, sum, total);
        return left || right;
    }
}
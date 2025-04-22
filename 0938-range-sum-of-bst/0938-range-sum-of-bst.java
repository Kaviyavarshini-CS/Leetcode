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
    public int rangeSumBST(TreeNode root, int low, int high) {
        return rangeSum(root, 0, low, high);
    }
    public int rangeSum(TreeNode root, int sum, int low, int high){
        if(root==null){
            return sum;
        }
        if(root.val>=low && root.val<=high){
            sum = sum+root.val;
        }
        sum = rangeSum(root.left, sum, low, high);
        sum = rangeSum(root.right, sum, low, high);
        return sum;
    }
}
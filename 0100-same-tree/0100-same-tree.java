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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        boolean ans = check(p, q);
        return ans;
    }
    private boolean check(TreeNode p, TreeNode q){
        if(q==null && p==null){
            return true;
        }
        if(q==null || p==null){
            return false;
        }
        if(p.val!=q.val){
            return false;
        }
        boolean a = check(p.left, q.left);
        boolean b = check(p.right, q.right);
        return a&&b;
    }
}
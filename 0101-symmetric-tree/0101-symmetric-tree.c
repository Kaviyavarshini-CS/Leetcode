/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     struct TreeNode *left;
 *     struct TreeNode *right;
 * };
 */
bool parallel_traverse(struct TreeNode* a, struct TreeNode* b)
{
    if (a == NULL && b == NULL)
        return true;
 
    if (a == NULL || b == NULL)
        return false;

    if (a->val != b->val)
        return false;
    
    return parallel_traverse(a->left, b->right) && parallel_traverse(a->right, b->left);
}

bool isSymmetric(struct TreeNode* root)
{
    if (root == NULL)
        return true;
    return parallel_traverse(root->left, root->right);
}
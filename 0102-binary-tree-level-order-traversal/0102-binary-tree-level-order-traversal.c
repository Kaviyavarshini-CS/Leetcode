/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     struct TreeNode *left;
 *     struct TreeNode *right;
 * };
 */
/**
 * Return an array of arrays of size *returnSize.
 * The sizes of the arrays are returned as *returnColumnSizes array.
 * Note: Both returned array and *columnSizes array must be malloced, assume caller calls free().
 */
int get_height(struct TreeNode *root)
{
     if(!root) return 0;
     int l,r;
     l = get_height(root->left)+1;
     r = get_height(root->right)+1;
     return l>r?l:r;
}
void get_levels(struct TreeNode *root, int level, int *data)
{
    if(root)
    {
        data[level]++;
        get_levels(root->left, level+1, data);
        get_levels(root->right, level+1, data);
    }
}
void get_data(struct TreeNode *root, int level, int **data, int *idx)
{
    if(root)
    {
        data[level][idx[level]++]=root->val;
        get_data(root->left, level+1, data, idx);
        get_data(root->right, level+1, data, idx);
    }   
}
int** levelOrder(struct TreeNode* root, int* returnSize, int** returnColumnSizes)
{
    int height = get_height(root);
    *returnSize = height;
    *returnColumnSizes = (int*)calloc(height, sizeof(int));
    get_levels(root, 0, *returnColumnSizes);
    int *idx = (int*)calloc(height, sizeof(int));
    int n=0;
    for(int i=0;i<height;i++) n += (*returnColumnSizes)[i];
    int **data = (int**)malloc(sizeof(int*)*height);
    for(int i=0;i<height;i++) data[i] = (int*)malloc(sizeof(int)*(*returnColumnSizes)[i]);
    get_data(root, 0, data, idx);
    return data;
}
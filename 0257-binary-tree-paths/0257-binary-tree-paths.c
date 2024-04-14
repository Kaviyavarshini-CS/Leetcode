/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     struct TreeNode *left;
 *     struct TreeNode *right;
 * };
 */
/**
 * Note: The returned array must be malloced, assume caller calls free().
 */
void dfs(struct TreeNode *node, char *curPath, int *i, char **res, int *rIdx) {
    if(node) {
        char cval[5] = {'\0'};
        int clen = 0;
        clen += sprintf(cval + clen, "%d", node->val);
        strcpy(curPath + (*i), cval);
        (*i) += clen;
        
        if(!node->left && !node->right) {
            curPath[(*i)] = '\0';
            res[*rIdx] = calloc(sizeof(char), *i + 1);
            strcpy(res[(*rIdx)++], curPath);                
        } else {
            curPath[(*i)++] = '-';                      
            curPath[(*i)++] = '>';
    
            dfs(node->left, curPath, i, res, rIdx);
            dfs(node->right, curPath, i, res, rIdx);
            *i -= 2;                                    
        }
        (*i) -= clen;                                   
    }
}

char ** binaryTreePaths(struct TreeNode* root, int* returnSize){
    char **res = calloc(sizeof(char *), 100);
    char *curPath = calloc(sizeof(char), 305);
    int idx = 0;
    *returnSize = 0;
    
    dfs(root, curPath, &idx, res, returnSize);
    return res;
}
/**
 * Note: The returned array must be malloced, assume caller calls free().
 */
#define STACK_SIZE 100

void helper(char* s, int len, int idx, int left, int right, int pendingLeft, char*** result, char* stack, int top, int* count)
{
    int i;
    
    if(idx == len)
    {
        if(pendingLeft == 0)
        {
            stack[top] = '\0';
            for(i=0;i<*count;i++)
            {
                if(strcmp((*result)[i],stack) == 0)
                    break;
            }
            if(i==*count)
            {
                (*count)++;
                (*result) = (char**)realloc((*result),sizeof(char*)*(*count));
                (*result)[(*count)-1] = (char*)malloc(top+1);
                strcpy((*result)[(*count)-1],stack);
            }
        }
        return;
    }
    
    if(s[idx] == '(')
    {
        // skip '('
        if(left)
            helper(s, len, idx+1, left-1, right, pendingLeft, result, stack, top, count);
        // try to add
        stack[top] = s[idx];
        helper(s, len, idx+1, left, right, pendingLeft+1, result, stack, top+1, count);
    }
    else if(s[idx] == ')')
    {
        // skip ')'
        if(right)
            helper(s, len, idx+1, left, right-1, pendingLeft, result, stack, top, count);
        // try to add
        if(pendingLeft)
        {
            stack[top] = s[idx];
            helper(s, len, idx+1, left, right, pendingLeft-1, result, stack, top+1, count);
        }
    }
    else
    {
        stack[top] = s[idx];
        helper(s, len, idx+1, left, right, pendingLeft, result, stack, top+1, count);
    }
}

char** removeInvalidParentheses(char* s, int* returnSize)
{
    char** result = NULL;
    int count = 0;
    int len = strlen(s);
    char* stack = NULL;
    int top = 0;
    int pendingLeft = 0;
    int i,left=0,right=0;
    
    if(s==NULL)
    {
        *returnSize = 0;
        return NULL;
    }
    result = (char**)malloc(sizeof(char*));
    stack = (char*)malloc(STACK_SIZE*sizeof(char));
    
    for(i=0;i<len;i++)
    {
        if(s[i]=='(')
            left++;
        else if(s[i]==')')
        {
            if(left)
                left--;
            else
                right++;
        }
    }
    
    helper(s,len,0,left,right,pendingLeft,&result,stack,top,&count);
    
    *returnSize = count;
    free(stack);
    return result;
}
/**
 * Note: The returned array must be malloced, assume caller calls free().
 */
int* findDisappearedNumbers(int* nums, int numsSize, int* returnSize) {
    int m;
    for (int c = 0; c < numsSize; c++) {
        m = abs(nums[c]) - 1;
        nums[m] = -1 * abs(nums[m]);
    }

    *returnSize = 0;
    for (int c = 0; c < numsSize; c++)
        if (nums[c] > 0)
            (*returnSize)++;
    
    int *ret = (int *) calloc (*returnSize, sizeof (int));
    int s = 0;
    for (int c = 0; c < numsSize; c++)
        if (nums[c] > 0)
            ret[s++] = c + 1;
    
    return ret;
}
class Solution {
    public int minMoves(int[] nums) {
        int n = nums.length;
        int count = 0;
        Arrays.sort(nums);
        int target = nums[0];
        for(int i=1;i<n;i++){
            count = count + nums[i]-target;
        }
        return count;
    }
}
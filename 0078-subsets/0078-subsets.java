class Solution {
    public void backtrack(int start, int[] nums, List<Integer> current, List<List<Integer>> subset){
        subset.add(new ArrayList<>(current));
        for(int i=start;i<nums.length;i++){
            current.add(nums[i]);
            backtrack(i+1, nums, current, subset);
            current.remove(current.size()-1);
        }
    }
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> subset = new ArrayList<>();
        backtrack(0, nums, new ArrayList<>(), subset);
        return subset;
    }
}
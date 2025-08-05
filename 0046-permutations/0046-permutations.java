class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        findPermutations(nums, result, new ArrayList<>(), used);
        return result;
    }
    public void findPermutations(int[] nums, List<List<Integer>> result, List<Integer> current, boolean[] used){
        if(nums.length==current.size()){
            result.add(new ArrayList<>(current));
            return;
        }
        for(int i=0;i<nums.length;i++){
            if(used[i]) continue;
            current.add(nums[i]);
            used[i] = true;
            findPermutations(nums, result, current, used);
            current.remove(current.size()-1);
            used[i] = false;
        }
    }
}
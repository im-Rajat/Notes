// 90. Subsets II
// https://leetcode.com/problems/subsets-ii/


class Solution {
    
    HashSet<List<Integer>> set = new HashSet<>();
    
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        
        Arrays.sort(nums);
        generateSubsets2(0, new ArrayList<>(), res, nums);
        
        return res;
    }
    
    public void generateSubsets2(int start, List<Integer> curr, List<List<Integer>> res, int[] nums) {
        res.add(new ArrayList<>(curr));
        
        for(int i = start; i < nums.length; i++) {
            if(i > start && nums[i - 1] == nums[i]) {
                continue;
            }
            curr.add(nums[i]);
            generateSubsets2(i + 1, curr, res, nums);
            curr.remove(curr.size() - 1);
        }
    }
}

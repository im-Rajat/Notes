// 39. Combination Sum
// https://leetcode.com/problems/combination-sum/


class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        
        generateCombinationSum(0, candidates, new ArrayList<>(), res, target);
        
        return res;
    }
    
    public void generateCombinationSum(int start, int[] candidates, List<Integer> curr, List<List<Integer>> res, int target) {
        if(target == 0) {
            res.add(new ArrayList<>(curr));
            return;
        }
        
        if(target < 0) {
            return;
        }
        
        for(int i = start; i < candidates.length; i++) {
            curr.add(candidates[i]);
            generateCombinationSum(i, candidates, curr, res, target - candidates[i]);
            curr.remove(curr.size() - 1);
        }
    }
}

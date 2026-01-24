// 40. Combination Sum II
// https://leetcode.com/problems/combination-sum-ii/


class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        
        Arrays.sort(candidates);
        generateCombinationSum2(0, candidates, new ArrayList<>(), res, target);
        
        return res;
    }
    
    public void generateCombinationSum2(int start, int[] candidates, List<Integer> curr, List<List<Integer>> res, int target) {
        if(target == 0) {
            res.add(new ArrayList<>(curr));
            return;
        }
        
        if(target < 0) {
            return;
        }
        
        for(int i = start; i < candidates.length; i++) {
            if(i > start && candidates[i - 1] == candidates[i]) {
                continue;
            }
            // if(candidates[i] > target) {
            //     break;
            // }
            curr.add(candidates[i]);
            generateCombinationSum2(i + 1, candidates, curr, res, target - candidates[i]);
            curr.remove(curr.size() - 1);
        }
    }
}

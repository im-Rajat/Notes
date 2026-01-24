// 216. Combination Sum III
// https://leetcode.com/problems/combination-sum-iii/


class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        
        generateCombinations3(1, 9, new ArrayList<>(), res, k, n);
        
        return res;
    }
    
    public void generateCombinations3(int start, int end, List<Integer> curr, List<List<Integer>> res, int k, int n) {
        if(n == 0 && curr.size() == k) {
            res.add(new ArrayList(curr));
            return;
        } 
        
        for(int i = start; i <= end; i++) {
            curr.add(i);
            generateCombinations3(i + 1, end, curr, res, k, n - i);
            curr.remove(curr.size() - 1);
        }
    }
}

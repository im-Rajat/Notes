// 77. Combinations
// https://leetcode.com/problems/combinations/

class Solution {
    public List<List<Integer>> combine(int n, int k) {
        
        List<List<Integer>> res = new ArrayList<>();
        generateCombinations(1, n, new ArrayList<>(), res, k);
        
        return res;
        
    }
    
    public void generateCombinations(int s, int n, List<Integer> curr, List<List<Integer>> res, int k) {
        
        if(curr.size() == k) {
            res.add(new ArrayList(curr));
            return;
        }
        
        for(int i = s; i <= n; i++) {
            curr.add(i);
            generateCombinations(i + 1, n, curr, res, k);
            curr.remove(curr.size() - 1);
        }
    }
//     public List<List<Integer>> combine(int n, int k) {
//         List<List<Integer>> res = new ArrayList<>();

//         int[] nums = new int[n];
//         for(int i = 1; i <= n; i++) {
//             nums[i - 1] = i;
//         }

//         combination(0, nums, k, new ArrayList<>(), res);

//         return res;
//     }

//     public void combination(int index, int[] nums, int k, List<Integer> curr, List<List<Integer>> res) {
//         if(curr.size() == k) {
//             res.add(new ArrayList<>(curr));
//         }
//         else if(curr.size() > k) {
//             return;
//         }
            

//         for(int i = index; i < nums.length; i++) {
//             curr.add(nums[i]);
//             combination(i + 1, nums, k, curr, res);
//             curr.remove(curr.size() - 1);
//         }
//     }
}

// 78. Subsets
// https://leetcode.com/problems/subsets/

class Solution {
        
    public List<List<Integer>> subsets(int[] nums) {
        int len = nums.length;
        List<List<Integer>> output = new ArrayList<>();

        List<Integer> temp = new ArrayList<>();
        output.add(temp);

        int total = (int) Math.pow(2, len);

        for(int i = 1; i < total; i++) {
            temp = new LinkedList<>();
            int n = i;
            int j = len - 1;
            while(n > 0) {
                if((n & 1) == 1) {
                    temp.add(nums[j]);
                }
                n = n >> 1;
                j--;
            }
            output.add(temp);
        }

        return output;
    }
    
//     public List<List<Integer>> subsets(int[] nums) {

//         List<List<Integer>> res = new ArrayList<>();
//         generateSubsets(0, nums, new ArrayList<>(), res);

//         return res;
//     }

//     public void generateSubsets(int index, int[] nums, List<Integer> curr, List<List<Integer>> res) {
//         res.add(new ArrayList<>(curr));

//         for(int i = index; i < nums.length; i++) {
//             curr.add(nums[i]);
//             generateSubsets(i + 1, nums, curr, res);
//             curr.remove(curr.size() - 1);
//         }
//     }
    
    
//     public List<List<Integer>> subsets(int[] nums) {

//         List<List<Integer>> res = new ArrayList<>();
//         res.add(new ArrayList<>());

//         for(int num : nums) {
//             int n = res.size();
//             for(int i = 0; i < n; i++) {
//                 List<Integer> temp = new ArrayList<>(res.get(i));
//                 temp.add(num);
//                 res.add(temp);
//             }
//         }

//         return res;
//     }
    
}

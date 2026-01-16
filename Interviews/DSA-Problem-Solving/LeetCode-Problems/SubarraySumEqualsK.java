// 560. Subarray Sum Equals K
// https://leetcode.com/problems/subarray-sum-equals-k/


class Solution {
    public int subarraySum(int[] nums, int k) {
        
        int count = 0;
        int prefixSum = 0;
        
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(prefixSum, 1);
        
        for (int num : nums) {
            prefixSum = prefixSum + num;
            int remainingSum = prefixSum - k;
            
            if (map.containsKey(remainingSum)) {
                count = count + map.get(remainingSum);
            }
            
            map.put(prefixSum, map.getOrDefault(prefixSum, 0) + 1);
        }
        
        return count;
    }
}


// // n2 approch, to generate to subarrays and check if their sum is equal to K
// class Solution {
//     public int subarraySum(int[] nums, int k) {
//         int count = 0;
        
//         for(int i = 0; i < nums.length; i++) {
//             if(nums[i] == k) {
//                 count++;
//             }
//             int sum = nums[i];
//             for (int j = i + 1; j < nums.length; j++) {
//                 if (sum + nums[j] == k) {
//                     count++;
//                 }
//                 sum = sum + nums[j];
//             }
//         }
        
//         return count;
//     }
// }

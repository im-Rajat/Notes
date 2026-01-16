// Snapdeal 1st Interview - Problem Solving and Coding Round (First Missing Positive)

// 41. First Missing Positive
// https://leetcode.com/problems/first-missing-positive/


// Doing modification in the input array inself and using negative number concept
class Solution {
    public int firstMissingPositive(int[] nums) {

        int len = nums.length;

        for (int i = 0; i < len; i++) {
            if (nums[i] <= 0) {
                nums[i] = len + 1;
            }
        }

        for (int i = 0; i < len; i++) {
            int num = Math.abs(nums[i]);
            if (num <= len) {
                if (nums[num - 1] > 0) {
                    nums[num - 1] = -1 * nums[num - 1];
                }
            }
        }

        for (int i = 0; i < len; i++) {
            if (nums[i] > 0) {
                return i + 1;
            }
        }

        return len + 1;
    }
}


/*
// Putting every number at it's correct index (index - 1)
class Solution {
    public int firstMissingPositive(int[] nums) {
        
        int len  = nums.length;
        
        for (int i = 0; i < len; i++) {
            while (nums[i] > 0 && nums[i] <= len && nums[i] != nums[nums[i] - 1]) {
                int temp = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = temp;
            }
        }
        
        for (int i = 0; i < len; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
        
        return len + 1;
    }
}
*/


/*
// Using extra array to store which number is found (using it's index - 1);
class Solution {
    public int firstMissingPositive(int[] nums) {
        
        int len = nums.length;
        
        int[] arr = new int[len];
        
        for(int i = 0; i < len; i++) {
            int temp = nums[i];
            
            if (temp >= 1 && temp <= len) {
                arr[temp - 1] = 1;
            }
        }
        
        for (int i = 0; i < len; i++) {
            if (arr[i] != 1) {
                return i +1;
            }
        }
        
        return len + 1;
    }
}
*/
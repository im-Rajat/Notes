// 46. Permutations
// https://leetcode.com/problems/permutations/


class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> output = new ArrayList();
        
        boolean[] visited = new boolean[nums.length];
        generatePermutations(nums, new ArrayList<>(), output, visited);
        
        return output;
    }
    
    public void generatePermutations(int[] nums, List<Integer> curr, List<List<Integer>> output, boolean[] visited) {
        if(curr.size() == nums.length) {
            output.add(new ArrayList<>(curr));
            return;
        }
        
        for(int i = 0; i < nums.length; i++) {
            if(visited[i] == true) {
                continue;
            }
            
            curr.add(nums[i]);
            visited[i] = true;
            generatePermutations(nums, curr, output, visited);
            curr.remove(curr.size() - 1);
            visited[i] = false;
        }
    }
}

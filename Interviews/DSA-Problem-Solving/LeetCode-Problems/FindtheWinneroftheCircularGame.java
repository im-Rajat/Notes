// 1823. Find the Winner of the Circular Game
// https://leetcode.com/problems/find-the-winner-of-the-circular-game/


class Solution {
    public int findTheWinner(int n, int k) {
        // using backtracking/recursion
        
        int winner = backTracking(n, k);
        
        return winner + 1;
    }
    
    public int backTracking(int n, int k) {
        if(n == 1) {
            return 0;
        }
        
        int x = backTracking(n - 1, k);
        int y = (x + k) % n;
        
        return y;
    }
}


// class Solution {
//     public int findTheWinner(int n, int k) {
        
//         int[] arr = new int[n];
        
//         for (int i = 0; i < n; i++) {
//             arr[i] = i + 1;
//         }
        
//         int count = 0;
        
//         int i = 0;
//         while (n > 1) {
//             while(count < k) {
//                 if(i >= arr.length) {
//                     i = 0;
//                 }
//                 if (arr[i] != -1) {
//                     i++;
//                     count++;
//                 }
//                 else {
//                     i++;
//                 }
//             }
//             if(i - 1 < 0) {
//                 arr[n - 1] = -1;
//             }
//             else {
//                 arr[i - 1] = -1;
//             }
//             n--;
//             count = 0;
//         }
        
//         int result = 0;
//         for (i = 0; i < arr.length; i++) {
//             if (arr[i] != -1) {
//                 result = arr[i];
//                 break;
//             }
//         }
        
//         return result;
//     }
// }

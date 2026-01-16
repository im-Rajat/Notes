// 48. Rotate Image
// https://leetcode.com/problems/rotate-image/


class Solution {
    public void rotate(int[][] matrix) {
        
        int row = matrix.length;
        int col = matrix[0].length;
        
        // first transpose the array
        for(int i = 0; i < row; i++) {
            for(int j = i; j < col; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        
        // swap elements of each row, like 1st with last and so on
        for(int i = 0; i < row; i++) {
            int j = 0;
            int k = col - 1;
            while(j < k) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][k];
                matrix[i][k] = temp;
                j++;
                k--;
            }
        }
    }
}

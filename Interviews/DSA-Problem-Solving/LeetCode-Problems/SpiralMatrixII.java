// 59. Spiral Matrix II
// https://leetcode.com/problems/spiral-matrix-ii/


class Solution {
    public int[][] generateMatrix(int n) {
        
        int[][] matrix = new int[n][n];
        
        int rowStart = 0;
        int rowEnd = n - 1;
        int colStart = 0;
        int colEnd = n-1;
        
        int count = 1;
        
        while(rowStart <= rowEnd && colStart <= colEnd) {
            
            for(int i = colStart; i <= colEnd; i++) {
                matrix[rowStart][i] = count++;
            }
            
            rowStart++;
            
            for(int i = rowStart; i <= rowEnd; i++) {
                matrix[i][colEnd] = count++;
            }
            
            colEnd--;
            
            if(rowStart <= rowEnd) {
                for(int i = colEnd; i>= colStart; i--) {
                    matrix[rowEnd][i] = count++;
                }
            }
            
            rowEnd--;
            
            if(colStart <= colEnd) {
                for(int i = rowEnd; i >= rowStart; i--) {
                    matrix[i][colStart] = count++;
                }
            }
            
            colStart++;
        }
        
        return matrix;
    }
}

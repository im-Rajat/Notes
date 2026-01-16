// 54. Spiral Matrix
// https://leetcode.com/problems/spiral-matrix/


class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        
        int rowStart = 0;
        int rowEnd = row - 1;
        int colStart = 0;
        int colEnd = col - 1;
        
        List<Integer> result = new ArrayList<>();
        
        while(rowStart <= rowEnd && colStart <= colEnd) {
            
            for(int i = colStart; i <= colEnd; i++) {
                result.add(matrix[rowStart][i]);
            }
            
            rowStart++;
            
            for(int i = rowStart; i <= rowEnd; i++) {
                result.add(matrix[i][colEnd]);
            }
            
            colEnd--;
            
            if(rowStart <= rowEnd) {
                for(int i = colEnd; i >= colStart; i--) {
                    result.add(matrix[rowEnd][i]);
                }
            }
            
            rowEnd--;
            
            if(colStart <= colEnd) {
                for(int i = rowEnd; i >= rowStart; i--) {
                    result.add(matrix[i][colStart]);
                }
            }
            colStart++;
        }
        
        return result;
    }
}

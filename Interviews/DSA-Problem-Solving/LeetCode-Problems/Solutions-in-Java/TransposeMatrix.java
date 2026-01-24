// 867. Transpose Matrix
// https://leetcode.com/problems/transpose-matrix/


class Solution {
    public int[][] transpose(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        
        int[][] new_matrix = new int[col][row];
        
        for(int i = 0; i < row; i++) {
            for(int j = 0; j < col; j++) {
                new_matrix[j][i] = matrix[i][j];
            }
        }
        
        return new_matrix;
    }
}

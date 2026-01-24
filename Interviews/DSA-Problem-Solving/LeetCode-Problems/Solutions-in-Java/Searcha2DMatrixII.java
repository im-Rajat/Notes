// 240. Search a 2D Matrix II
// https://leetcode.com/problems/search-a-2d-matrix-ii/


class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length;
        int col = matrix[0].length;
        
        int r = 0;
        int c = col - 1;
        
        while (r < row && c >= 0) {
            if(matrix[r][c] == target) {
                return true;
            }
            else if(matrix[r][c] < target) {
                r++;
            }
            else {
                c--;
            }
        }
        
        return false;
    }
}

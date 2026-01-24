// 74. Search a 2D Matrix
// https://leetcode.com/problems/search-a-2d-matrix/

class Solution {
    public boolean searchMatrix(int[][] matrix, int target)
    {
        
        if(matrix.length == 0)
        {
            return false;
        }
        
        int row = matrix.length;
        int col = matrix[0].length;
        
        int low = 0;
        int high = (row*col) - 1;
        
        while(low <= high)
        {
            int mid = low + (high - low) / 2;
            int mid_point = matrix[mid / col][mid % col];
            
            if(mid_point == target)
            {
                return true;
            }
            else if(mid_point < target)
            {
                low = mid + 1;
            }
            else
            {
                high = mid - 1;
            }
        }
        
        return false;
        
    }
}

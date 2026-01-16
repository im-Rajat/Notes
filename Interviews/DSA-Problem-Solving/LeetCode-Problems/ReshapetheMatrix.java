// 566. Reshape the Matrix
// https://leetcode.com/problems/reshape-the-matrix/

class Solution {
    public int[][] matrixReshape(int[][] mat, int r, int c)
    {
        int r1 = mat.length;
        int c1 = mat[0].length;
        
        if(r1 * c1 != r * c)
        {
            return mat;
        }
        
        int[][] newMatrix = new int[r][c];
        
        int r2 = 0;
        int c2 = 0;
        
        for(int i = 0; i < r1; i++)
        {
            for(int j = 0; j < c1; j++)
            {
                if(c2 == c)
                {
                    r2++;
                    c2 = 0;
                }
                newMatrix[r2][c2] = mat[i][j];
                c2++;
            }
        }
        
        return newMatrix;
    }
}

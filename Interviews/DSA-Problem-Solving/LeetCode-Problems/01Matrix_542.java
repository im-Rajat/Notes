// 542. 01 Matrix
// https://leetcode.com/problems/01-matrix/

class Solution
{
    public int[][] updateMatrix(int[][] mat)
    {
        int row = mat.length;
        int col = mat[0].length;
        
        Queue<int[]> queue = new LinkedList<>();
        
        for(int i = 0; i < row; i++)
        {
            for(int j = 0; j < col; j++)
            {
                if(mat[i][j] == 0)
                {
                    queue.add(new int[]{i, j});
                }
                else
                {
                    mat[i][j] = -1;
                }
            }
        }
        
        int[][] dir = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
        
        int level = 1;
        while(!queue.isEmpty())
        {
            int size = queue.size();
            while(size-- > 0)
            {
                int[] temp = queue.poll();
                for(int[] d : dir)
                {
                    int r = temp[0] + d[0];
                    int c = temp[1] + d[1];
                    if(r < 0 || c < 0 || r >= row || c >= col || mat[r][c] != -1)
                    {
                        continue;
                    }
                    mat[r][c] = level;
                    queue.add(new int[]{r, c});
                }
            }
            level++;
        }
        
        return mat;
    }
    
}

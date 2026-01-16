// 994. Rotting Oranges
// https://leetcode.com/problems/rotting-oranges/

class Solution
{
    public int orangesRotting(int[][] grid)
    {
        int row = grid.length;
        int col = grid[0].length;
        
        Queue<int[]> queue = new LinkedList<>();
        
        int oranges = 0;
        
        for(int i = 0; i < row; i++)
        {
            for(int j = 0; j < col; j++)
            {
                if(grid[i][j] == 2)
                {
                    queue.add(new int[]{i, j});
                }
                if(grid[i][j] != 0)
                {
                    oranges++;
                }
            }
        }
        
        if(oranges == 0)
        {
            return 0;
        }
        
        int[][] dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int level = 0;
        
        while(!queue.isEmpty())
        {
            int size = queue.size();
            oranges -= size;
            while(size-- > 0)
            {
                int[] temp = queue.poll();
                for(int[] d : dir)
                {
                    int r = temp[0] + d[0];
                    int c = temp[1] + d[1];
                    
                    if(r < 0 || c < 0 || r >= row || c >= col || grid[r][c] == 0 || grid[r][c] == 2)
                    {
                        continue;
                    }
                    grid[r][c] = 2;
                    queue.add(new int[]{r, c});
                }
            }
            if(queue.size() != 0)
            {
                level++;
            }
        }
        
        if(oranges != 0)
        {
            return -1;
        }
        
        return level;
    }
}

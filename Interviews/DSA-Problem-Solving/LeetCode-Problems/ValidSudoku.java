// 36. Valid Sudoku
// https://leetcode.com/problems/valid-sudoku/submissions/

class Solution {
    public boolean isValidSudoku(char[][] board)
    {
        HashSet<String> seen = new HashSet();
        
        for(int i = 0; i < 9; i++)
        {
            for(int j = 0; j < 9; j++)
            {
                char num = board[i][j];
                if(num != '.')
                {
                    if(!seen.add(num + " found in row " + i) || 
                       !seen.add(num + " found in coloumn " + j) ||
                       !seen.add(num + " foung in sub-boxes " + i/3 + 'x' + j/3))
                    {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}

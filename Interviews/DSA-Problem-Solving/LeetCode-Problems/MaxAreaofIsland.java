// 695. Max Area of Island
// https://leetcode.com/problems/max-area-of-island/

class Solution
{
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor)
    {
        if(image[sr][sc] == newColor)
        {
            return image;
        }
        dfs(image, sr, sc, image[sr][sc], newColor);
        return image;
    }
    
    public void dfs(int[][] image, int sr, int sc, int oldColor, int newColor)
    {
        if(sr < 0 || sc < 0 || sr >= image.length || sc >= image[0].length || image[sr][sc] != oldColor)
        {
            return;
        }
        
        image[sr][sc] = newColor;
        dfs(image, sr + 1, sc, oldColor, newColor);
        dfs(image, sr - 1, sc, oldColor, newColor);
        dfs(image, sr, sc + 1, oldColor, newColor);
        dfs(image, sr, sc - 1, oldColor, newColor);
    }
    
}

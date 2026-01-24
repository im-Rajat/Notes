// 118. Pascal's Triangle
// https://leetcode.com/problems/pascals-triangle/

class Solution
{
    public List<List<Integer>> generate(int numRows)
    {
        List<List<Integer>> triangle = new ArrayList<>();
        
        if(numRows == 0)
        {
            return triangle;
        }
        
        List<Integer> first_row  = new ArrayList<>();
        first_row.add(1);
        triangle.add(first_row);
        
        for(int i = 1; i < numRows; i++)
        {
            List<Integer> prev_row = triangle.get(i - 1);
            List<Integer> new_row = new ArrayList<>();
            
            new_row.add(1);
            
            for(int j = 1; j < i; j++)
            {
                new_row.add(prev_row.get(j - 1) + prev_row.get(j));
            }
            
            new_row.add(1);
            triangle.add(new_row);
        }
        
        return triangle;
        
    }
}

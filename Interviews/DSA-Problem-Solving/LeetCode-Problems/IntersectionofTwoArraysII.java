// 350. Intersection of Two Arrays II
// https://leetcode.com/problems/intersection-of-two-arrays-ii/

class Solution
{
    public int[] intersect(int[] nums1, int[] nums2)
    {
        HashMap<Integer, Integer> hm1 = new HashMap<>();
        HashMap<Integer, Integer> hm2 = new HashMap<>();
        
        for(int i = 0; i < nums1.length; i++)
        {
            if(hm1.containsKey(nums1[i]))
            {
                hm1.put(nums1[i], hm1.get(nums1[i]) + 1);
            }
            else
            {
                hm1.put(nums1[i], 1);
            }
        }
        
        for(int i = 0; i < nums2.length; i++)
        {
            if(hm2.containsKey(nums2[i]))
            {
                hm2.put(nums2[i], hm2.get(nums2[i]) + 1);
            }
            else
            {
                hm2.put(nums2[i], 1);
            }
        }
        
        List<Integer> arr = new ArrayList<>();
        
        for(int key : hm1.keySet())
        {
            if(hm2.containsKey(key))
            {
                int temp = Math.min(hm1.get(key), hm2.get(key));
                while(temp-- > 0)
                {
                    arr.add(key);
                }
            }
        }
        
        int[] output = new int[arr.size()];
        
        for(int i = 0; i < arr.size(); i++)
        {
            output[i] = arr.get(i);
        }
        
        return output;
    }
}

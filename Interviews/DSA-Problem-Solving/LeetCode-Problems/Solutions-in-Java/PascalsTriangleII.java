// 119. Pascal's Triangle II
// https://leetcode.com/problems/pascals-triangle-ii/


// Simple formula if R and C is given and we need to find the it's value
// (R-1)C(C-1) = (r-1)Combination(c-1)

class Solution {
    public List<Integer> getRow(int rowIndex) {
        Integer[] arr = new Integer[rowIndex + 1];
        Arrays.fill(arr, 0);
        arr[0] = 1;
        
        for (int i = 1; i < rowIndex + 1; i++) {
            for (int j = i; j > 0 ; j--) {
                arr[j] = arr[j] + arr[j - 1];
            }
        }
        
        return Arrays.asList(arr);
    }
}

// class Solution {
//     public List<Integer> getRow(int rowIndex) {
//         List<Integer> result = new ArrayList<>();
        
//         if(rowIndex == 0){
//             result.add(1);
//             return result;
//         }
        
//         if(rowIndex == 1) {
//             result.add(1);
//             result.add(1);
//             return result;
//         }
        
//         int[] arr = new int[rowIndex];
//         for(int i = 0; i < rowIndex; i++) {
//             arr[i] = 1;
//         }
//         arr[0] = arr[1] = 1;
//         int temp = 0;
//         for(int i = 2 ; i <= rowIndex; i++) {
//             for(int j = 1; j < i; j++) {
//                 if(j == 1) {
//                     temp = arr[j];
//                     arr[j] = arr[j] + arr[j - 1];
//                 }
//                 else {
//                     arr[j] = arr[j] + temp;
//                     temp = arr[j] - temp;
//                 }
//             }

//         }
        
//         for(int i = 0; i < rowIndex; i++) {
//             result.add(arr[i]);
//         }
        
//         result.add(1);
        
//         return result;
//     }
// }

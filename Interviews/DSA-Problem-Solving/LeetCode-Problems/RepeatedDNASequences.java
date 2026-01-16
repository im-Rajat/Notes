// 187. Repeated DNA Sequences
// https://leetcode.com/problems/repeated-dna-sequences/


class Solution {
    public static List<String> findRepeatedDnaSequences(String s) {

       List<String> result = new ArrayList<>();
       Map<String, Integer> map = new HashMap<>();

       for (int i = 0; i + 10 <= s.length(); i++) {
           String substr = s.substring(i, i + 10);
           
           map.put(substr, map.getOrDefault(substr, 0) + 1);
           if (map.get(substr) == 2) {
               result.add(substr);
           }

           // if(map.containsKey(substr) == false) {
           //     map.put(substr, 1);
           // }
           // else {
           //     if(map.get(substr) == 1) {
           //         result.add(substr);
           //         map.put(substr, map.get(substr) + 1);
           //     }
           // }
       }

       return result;
    }
}

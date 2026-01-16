// 17. Letter Combinations of a Phone Number
// https://leetcode.com/problems/letter-combinations-of-a-phone-number/


class Solution {
    public List<String> letterCombinations(String digits) {
        LinkedList<String> output = new LinkedList<>();

        if (digits.length() == 0) {
            return output;
        }

        output.add("");

        String[] map = new String[]{"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

        for (int i = 0; i < digits.length(); i++) {
            int index = Integer.parseInt(digits.charAt(i)+"");
//            int index = Character.getNumericValue(digits.charAt(i));
            while (output.peek().length() == i) {
                String permutation = output.remove();
                for(char c : map[index].toCharArray()) {
                    output.add(permutation + c);
                }
            }
        }

        return output;
        
//         List<String> result = new ArrayList<>();
        
//         if(digits.length() == 0) {
//             return result;
//         }
        
//         HashMap<String, String> map = new HashMap();
        
//         map.put("2", "abc");
//         map.put("3", "def");
//         map.put("4", "ghi");
//         map.put("5", "jkl");
//         map.put("6", "mno");
//         map.put("7", "pqrs");
//         map.put("8", "tuv");
//         map.put("9", "wxyz");
        
//         Deque<String> deque = new ArrayDeque<>();
//         deque.add("");
        
//         for(int i = 0; i < digits.length(); i++) {
//             String digit = digits.charAt(i) + "";
//             String letters = map.get(digit);
//             int n = deque.size();

//             for(int j = 0; j < n; j++) {
//                 String curr = deque.pollFirst();

//                 for(int k = 0; k < letters.length(); k++) {
//                     String temp = curr + letters.charAt(k);
//                     deque.add(temp);
//                 }
//             }
//         }

//         while(!deque.isEmpty()) {
//             result.add((deque.poll()));
//         }
        
        
//         return result;
    }
}

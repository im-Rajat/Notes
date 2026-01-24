// 290. Word Pattern
// https://leetcode.com/problems/word-pattern/


class Solution {
    public boolean wordPattern(String pattern, String s) {

        String[] words = s.split(" ");

        HashMap<Character, String> map = new HashMap<>();
        HashMap<String, Integer> mapCheck = new HashMap<>();

        if (pattern.length() != words.length) {
            return false;
        }

        for (int i = 0; i < pattern.length(); i++) {
            char ch = pattern.charAt(i);

            if (map.containsKey(ch)) {
                String temp = map.get(ch);
                if (!temp.equals(words[i])) {
                    return false;
                }
            }
            else if (mapCheck.containsKey(words[i])) {
                return false;
            }

            map.put(ch, words[i]);
            mapCheck.put(words[i], 1);
        }

        return true;
    }
}

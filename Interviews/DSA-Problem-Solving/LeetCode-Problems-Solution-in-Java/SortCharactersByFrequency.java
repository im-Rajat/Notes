// 451. Sort Characters By Frequency
// https://leetcode.com/problems/sort-characters-by-frequency/


// Using Hashmap and Heap (Priority Queue)
class Solution {
    public String frequencySort(String s) {
        StringBuilder sb = new StringBuilder();

        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        PriorityQueue<Character> heap = new PriorityQueue<>((c1, c2) -> map.get(c2) - map.get(c1));

        for (char c : map.keySet()) {
            heap.add(c);
        }

        while (heap.isEmpty() == false) {
            char c = heap.poll();
            int count = map.get(c);
            while (count > 0) {
                sb.append(c);
                count--;
            }
        }
        
        return sb.toString();
    }
}

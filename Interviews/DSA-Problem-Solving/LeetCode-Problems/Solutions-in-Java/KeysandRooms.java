// 841. Keys and Rooms
// https://leetcode.com/problems/keys-and-rooms/


// Using Stack
class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        
        int n = rooms.size();
        
        boolean[] visited = new boolean[n];
        visited[0] = true;
        
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        
        while (stack.isEmpty() == false) {
            int curr = stack.pop();
            
            for (int key : rooms.get(curr)) {
                if (visited[key] == false) {
                    visited[key] = true;
                    stack.push(key);
                }
            }
        }
        
        for (boolean temp : visited) {
            if (temp == false) {
                return false;
            }
        }
        
        return true;
    }
}



/*// Using Recursion (DFS)
class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        
        int n = rooms.size();
        
        boolean[] visited = new boolean[n];
        
        checkVisited(visited, rooms, 0);
        
        for (int i = 0; i < n; i++) {
            if (visited[i] == false) {
                return false;
            }
        }
        
        return true;
    }
    
    public void checkVisited(boolean[] visited, List<List<Integer>> rooms, int i) {
        if (visited[i] == true) {
            return;
        }
        
        visited[i] = true;
        List<Integer> curr = rooms.get(i);
        
        for (int j = 0; j < curr.size(); j++) {
            checkVisited(visited, rooms, curr.get(j));
        }
    }
}*/

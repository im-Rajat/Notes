// 232. Implement Queue using Stacks
// https://leetcode.com/problems/implement-queue-using-stacks/

class MyQueue {
    private Stack<Integer> s1 = new Stack<>();
    private Stack<Integer> s2 = new Stack<>();
    
    public MyQueue() {
        
    }
    
    public void push(int x) {
        s1.push(x);
    }
    
    public int pop() {
        if(s2.isEmpty()) {
            while(!s1.isEmpty()) {
                s2.push(s1.pop());
            }
        }
        return s2.pop();
        
    }
    
    public int peek() {
        if(s2.isEmpty()) {
            while(!s1.isEmpty()) {
                s2.push(s1.pop());
            }
        }
        return s2.peek();
    }
    
    public boolean empty() {
        return s1.isEmpty() && s2.isEmpty();
    }
//     Stack<Integer> s1 = new Stack<>();
//     Stack<Integer> s2 = new Stack<>();
    
//     public MyQueue() {
        
//     }
    
//     public void push(int x) {
//         while(!s1.isEmpty()) {
//             s2.push(s1.pop());
//         }
        
//         s1.push(x);
        
//         while(!s2.isEmpty()) {
//             s1.push(s2.pop());
//         }
//     }
    
//     public int pop() {
//         return s1.pop();
        
//     }
    
//     public int peek() {
//         return s1.peek();
//     }
    
//     public boolean empty() {
//         return s1.isEmpty();
//     }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */

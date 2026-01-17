# DSA and Problem Solving

## Patterns to Solve Leetcode Problem:

- Two-Pointer Pattern
- Sliding Window
    - **Purpose**: Solves problems like finding the largest substring without repeating characters, maximum sum subarray of size K, and largest substring with K distinct characters
    - **How it works**: Uses two pointers, left and right, to define a "window" within an array or string. The right pointer expands the window, and when a condition (e.g., repeating character) is met, the left pointer shrinks the window
- Top K Elements
    - **Purpose**: Used for problems like finding the K largest/smallest numbers in an array or K most frequent numbers. It also appears in some sliding window problems
    - **How it works**: Instead of sorting (which is O(n log n)), it uses a heap data structure to maintain the K largest elements seen so far. Elements are added to the heap, and if the heap size exceeds K, the minimum element is removed
    - **Time Complexity**: O(n log K)
- Backtracking
    - **Purpose**: Explores all possible solutions step by step. When an invalid state is reached, it "backtracks" to explore other paths. Commonly implemented using recursion.
    - **Example Problem**: Combination Sum. Given a list of positive numbers and a target sum, find all unique combinations that add up to the target, allowing numbers to be picked more than once.
    - **Applications**: Word Ladder, Permutations, Sudoku Solver.
- Dynamic Programming
    - **Purpose**: A more thoughtful approach to exploring solutions compared to backtracking. It breaks down a problem into smaller subproblems and builds solutions from the bottom up.
    - **Example Problem**: Combination Sum. The video explains how knowing solutions to smaller subproblems (e.g., combinations for target sum - 1, target sum - 2) can help build the solution for the main target sum.
- Subset Pattern
- Modified Binary Search
- Binary Tree DFS (Depth-First Search) & Binary Tree BFS (Breadth-First Search)
    - **Purpose**: Both are used for graph traversal and are very similar.
    - **DFS**: Starts from a vertex and explores as far as possible along each branch before backtracking. Implemented using a stack
    - **BFS**: Explores neighboring vertices first before moving to deeper unvisited vertices. Implemented using a queue.
    - **Applications**: BFS is used to find the shortest path between two vertices. Dijkstra's algorithm is a related algorithm for shortest path. Topological Sort is closely related to DFS and is essential for coding interviews

## Coding / Problem Solving Tricks

- If input array is sorted then:
    - Binary Search
    - Two Pointers
- If asked for all permutations/subsets then:
    - Backtracking
- If given a tree/graph then:
    - DFS
    - BFS
- If given a linked list then:
    - Two Pointers
- If recursion is banned then:
    - Stack
- If must solve in-place then:
    - Swap corresponding values
    - Store one or more different values in the same pointer
- If asked for maximum/minimum subarray/subset/options then:
    - Dynamic Programming
- If asked for top/least K items then:
    - Heap
    - QuickSelect
- If asked for common strings then:
    - Map
    - Trie
- Else:
    - Map/Set for O(1) time and O(n) space
    - Sort input for O(n log n) time and O(1) space

## Topic wise Questiones based on Topics

- Strings : https://leetcode.com/discuss/study-guide/1333049/Collections-of-string-questions-pattern-for-upcoming-placement-2021
- Dynamic Programming (DP) : https://leetcode.com/discuss/general-discussion/662866/dp-for-beginners-problems-patterns-sample-solutions
- Binary Search : https://leetcode.com/discuss/general-discussion/691825/Binary-Search-for-Beginners-Problems-or-Patterns-or-Sample-solutions
- Greedy : https://leetcode.com/discuss/general-discussion/669996/greedy-for-beginners-problems-sample-solutions
- Graph : https://leetcode.com/discuss/general-discussion/655708/graph-for-beginners-problems-pattern-sample-solutions/
- DP for Beginners [Problems | Patterns | Sample Solutions] : https://leetcode.com/discuss/general-discussion/662866/Dynamic-Programming-for-Practice-Problems-Patterns-and-Sample-Solutions

## DSA/Coding :

- Grind 75 Questions : https://www.techinterviewhandbook.org/grind75
- Amazon Final Interview Questions : https://leetcode.com/discuss/interview-question/488887/Amazon-Final-Interview-Questions-or-SDE1
- Blind 75, Grind 75, Grind 169, Neetcode 150 and SQL 45 : https://leetcode.com/discuss/general-discussion/3691891/Leetcode-Lists-for-Blind-75-Grind-75-Grind-169-Neetcode-150-and-SQL-45
- Top 10 DS Interview Questions : https://www.crio.do/blog/data-structures-interview-questions/
- DSA Beginner : https://github.com/SagarKumar04/December-2021-Beginner-DSA
- A2Z DSA Sheet : https://github.com/ManishK4514/Strivers-A2Z-DSA-Sheet/tree/main
- Low Level Design of Splitwise : https://leetcode.com/discuss/study-guide/2154270/low-level-design-of-splitwise

## References

- [8 patterns to solve 80% Leetcode problems](https://www.youtube.com/watch?v=xo7XrRVxH8Y)
- [Top 5 Algorithms](https://www.youtube.com/watch?v=EM8IgIIiOdY)
- [70 Leetcode problems in 5+ hours (every data structure)](https://www.youtube.com/watch?v=lvO88XxNAzs)

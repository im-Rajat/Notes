// https://leetcode.com/problems/minimum-add-to-make-parentheses-valid/


// you can use includes, for example:
// #include <algorithm>

// you can write to stdout for debugging purposes, e.g.
// cout << "this is a debug message" << endl;

int solution(string &S) {
    // write your code in C++14 (g++ 6.2.0)
    int open_brackets, close_brackets;
    
    open_brackets = 0;
    close_brackets = 0;

    for (char c : S) {
        if (c == '(') {
            open_brackets++;
        }
        else if (open_brackets > 0) {
            open_brackets--;
        }
        else {
            close_brackets++;
        }
    }

    return open_brackets + close_brackets;
}

// https://leetcode.com/problems/robot-room-cleaner/
// https://leetcode.com/discuss/interview-question/1373943/microsoft-oa-sde-2


// you can use includes, for example:
// #include <algorithm>
#include <bits/stdc++.h>

// you can write to stdout for debugging purposes, e.g.
// cout << "this is a debug message" << endl;

unordered_map<string, bool> visited;
unordered_set<string> st;

void dfs(int i, int j, int dir, vector<string> grid) {
    int m = grid.size();
    int n = grid[0].size();
    if(i == m || i == -1 || j == n || j == -1) {
        if(i == m) dfs(i-1, j, 2, grid);
        else if(i == -1) dfs(i+1, j, 0, grid);
        else if(j == n) dfs(i, j-1, 1, grid);
        else if(j == -1) dfs(i, j+1, 3, grid);
        return;
    }
    
    string key = to_string(i) + "_" + to_string(j) + "_" + to_string(dir);
    if(visited.find(key) != visited.end()) return;
    
    visited[key] = true;
    if(grid[i][j] != 'X') {
        string k = to_string(i) + "_" + to_string(j);
        st.insert(k);
        if(dir == 0) dfs(i, j+1, 0, grid);
        else if(dir == 1) dfs(i+1, j, 1, grid);
        else if(dir == 2) dfs(i, j-1, 2, grid);
        else if(dir == 3) dfs(i-1, j, 3, grid);
    }
    else {
        if(dir == 0) dfs(i, j-1, 1, grid);
        else if(dir == 1) dfs(i-1, j, 2, grid);
        else if(dir == 2) dfs(i, j+1, 3, grid);
        else if(dir == 3) dfs(i+1, j, 0, grid);
    }
    return;
}

int solution(vector<string> &R) {
    // write your code in C++14 (g++ 6.2.0)

    dfs(0, 0, 0, R);

    return st.size();

    // for (int i = 0; i < R.size(); i++) {
    //     cout<<R[i]<endl;
    // }

    // int row = R.size();
    // string str = R.front();
    // int col = str.length();

    // string arr[row][col];

    // for(int r = 0; r < row; r++) {
    //     string s = R[r];
    //     for (int i = 0; i < s.length(); i++) {
    //         arr[r][i] = s[i];
    //     }
    // }

    // for (int r = 0; r < row; r++) {
    //     for (int c = 0; c < col; c++) {
    //         cout<<arr[r][c];
    //     }
    //     cout<<endl;
    // }

    // int count = 0;
    // int r = 0;
    // int c = 0;

    // int dir = 1;

    // while (1) {
    //     if (dir == 1) {
    //         if (c + 1 < col) {

    //         }
    //     }


    //     if (arr[r][c] == '.') {
    //         count++;
    //         arr[r][c] = 'c';
    //         if (dir == 1) {
                
    //         }
    //     }
    //     else if
    // }

    // return 0;
}

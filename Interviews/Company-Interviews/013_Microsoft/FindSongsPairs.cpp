#include <bits/stdc++.h>
using namespace std;


int songsPair(int a[], int n) {
    map<int, int> m;
    int count = 0;

    for (int i = 0; i < n; i++) {
        int duration = a[i] % 60;
        
        if (m.find((60 - duration)%60) != m.end()) {
            count = count + m[60 - duration];
            m[duration] = m[duration] + 1;
        }
        else {
            m[duration] = 1;
        }
    }

    for (auto x : m) {
        cout<<x.first<<" "<<x.second<<endl;;
    }

    return count;
}

int main() {

    int A[10] = {10, 50, 110, 20, 40, 60, 120, 170, 180, 80};
    int result = songsPair(A, 10);
    // 10 50, 10 110, 10 170, 60 120, 20 40, 60 180

    cout<<result<<endl;

    return 0;
}

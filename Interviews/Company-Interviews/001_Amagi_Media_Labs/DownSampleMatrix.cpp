#include <bits/stdc++.h>
using namespace std;


int main()
{
    int n;
    cin>>n;

    int a[n][n];

    for (int r = 0; r < n; r++) {
        for (int c = 0; c < n; c++) {
            cin>>a[r][c];
        }
    }

    int l = n/2;

    int result[l][l];

    // int r1 = 0;
    // int c1 = 0;

    for (int r = 0; r < n; r = r + 2) {
        for (int c = 0; c < n; c = c + 2) {
            int n1 = a[r][c];
            int n2 = a[r + 1][c];
            int n3 = a[r][c + 1];
            int n4 = a[r + 1][c + 1];

            int avg = (n1 + n2 + n3 + n4) / 4;

            result[r/2][c/2] = avg;
            
            // cout<<"avg : "<<avg<<endl;
            // result[r1][c1] = avg;

            // if (c1 + 1 >= l) {
            //     r1 = r1 + 1;
            //     c1 = 0;
            // }
            // else {
            //     c1 = c1 + 1;
            // }

        }
    }

    for (int r = 0; r < l; r++) {
        for (int c = 0; c < l; c++) {
            cout<<result[r][c]<<" ";
        }
        cout<<endl;
    }



}
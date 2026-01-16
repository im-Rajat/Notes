#include <bits/stdc++.h>
using namespace std;
 
void func(int a[], int n) {
    int pre[n];
    int suf[n];
 
    pre[0] = 1;
 
    // cout<<"pre : "<<endl;
    for (int i = 1; i < n; i++) {
        pre[i] = pre[i - 1] * a[i - 1];
        // cout<<pre[i]<<" ";
    }
 
    suf[n - 1] = 1;
 
    // cout<<endl<<"suff : "<<endl;
    for (int i = n - 2; i >= 0; i--) {
        suf[i] = suf[i + 1] * a[i + 1];
        // cout<<suf[i]<<" ";
    }
 
    // cout<<endl;
    int result[n];
 
    for (int i = 0; i < n; i++) {
        result[i] = pre[i] * suf[i];
    }
 
    for (int i = 0; i < n; i++) {
       cout<<result[i]<<" ";
    }
 
    return;
}
 
int main()
{
    int n;
    cin>>n;
 
    int a[n];
 
    for (int i = 0; i < n; i++) {
        cin>>a[i];
    }
 
    func(a, n);
}
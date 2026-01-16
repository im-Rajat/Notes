// Endovision AI 1st round question (Find the missing number from the given series of N sequentional numbers)


#include <bits/stdc++.h>
using namespace std;

int main()
{
    int n;
    cin>>n;

    int a[n-1];

    for(int i = 0; i < n-1; i++)
    {
        cin>>a[i];
    }

    int totalSum = (n * (n + 1)) / 2;
    // cout<<"totalSum = "<<totalSum;
    int sum = 0;
    for(int i = 0; i < n-1; i++)
    {
        sum = sum + a[i];
    }

    // cout<<"\nSum = "<<sum;

    int missingNumber = totalSum - sum;
    cout<<"Mising Number : "<<missingNumber;
}
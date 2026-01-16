// Thales Group Managerial Interview (Reverse words in a given String)
// https://www.geeksforgeeks.org/find-element-appears-array-every-element-appears-twice/


#include <bits/stdc++.h>
using namespace std;


int findSingle(int arr[], int len)
{
    int ans = arr[0];
    for(int i = 1; i < len; i++)
    {
        ans = ans ^ arr[i];
    }

    return ans;
}

int main()
{
    int len = 7;
    int arr[len] = {1, 2, 8, 5, 1, 5, 2};

    int ans = findSingle(arr, len);
    cout<<ans<<endl;

    return 0;
}
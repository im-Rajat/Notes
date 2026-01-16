// Thales Group Managerial Interview (Reverse words in a given String)
// https://www.geeksforgeeks.org/find-element-appears-array-every-element-appears-twice/


#include <bits/stdc++.h>
using namespace std;

void countOccurence(int arr[], int len)
{
    unordered_map<int, int> um;
    for(int i = 0; i < len; i++)
    {
        um[arr[i]]++;
    }
    for(auto i : um)
    {
        cout<<i.first<<" -> "<<i.second<<endl;
    }
}

int main()
{
    int len = 10;
    int arr[len] = {1, 2, 8, 5, 1, 5, 2, 1, 5, -5};

    countOccurence(arr, len);
    
    return 0;
}
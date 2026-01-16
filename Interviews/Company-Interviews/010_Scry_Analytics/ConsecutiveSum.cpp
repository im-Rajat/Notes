// Scry Analytics 1st round question (List all the numbers between [X, Y] such that the consecutive sum from X can be achieved as Y)


#include <bits/stdc++.h>
using namespace std;

vector<int> consecutiveSum(int a, int b)
{
    vector<int>consecutiveNumber;   // creating a vector for storing the results
    int start, end, sum;
    start = end = sum = a;

    while(start <= b/2)
    {
        if(sum < b)
        {
            end = end + 1;
            sum = sum + end;    // calculating the sum
        }
        else if(sum > b)
        {
            sum = sum - start;  // if sum is greater, substrating number from starting
            start = start + 1;
        }
        else if(sum == b)   // sum found
        {
            consecutiveNumber.push_back(start);     // storing number in vector
            // cout<<start<<" ";
            // for(int i = start; i <=end ; i++)
            // {
            //     cout<<i<<" ";
            // }
            // cout<<endl;
            sum = sum - start;
            start = start + 1;
        }
    }

    consecutiveNumber.push_back(b);     // adding b also, as it itself a sum.

    return consecutiveNumber;
}

int main()
{
    int a, b;
    cout<<"Enter the 2 Numbers (Space Seperated) : ";
    cin>>a>>b;
    vector<int>consecutiveNumber;   // creating a vector for storing the results
    consecutiveNumber = consecutiveSum(a, b);
    printf("Numbers between [%d, %d] with consecutive sum from %d to %d are :\n", a, b, a, b);
    for(int i = 0; i<consecutiveNumber.size(); i++)
    {
        cout<<consecutiveNumber[i]<<" ";
    }
}
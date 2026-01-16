// HPE 1st Technical Interview (Set / Clear Bit)
// https://www.geeksforgeeks.org/set-clear-and-toggle-a-given-bit-of-a-number-in-c/


#include <stdio.h>

int setBit(int n, int k)
{
    return (n | (1 << (k - 1)));
}

int clearBit(int n, int k)
{
    return (n & (~(1 << (k - 1))));
}

int main()
{
    int n = 5;
    int k = 1;

    printf("%d\n", setBit(n, k));
    printf("%d\n", clearBit(n, k));

    return 0;
}
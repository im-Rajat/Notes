// Thales Group 1st Technical Interview (Count number of set bits of a given number)
// https://www.geeksforgeeks.org/count-set-bits-in-an-integer/


#include <stdio.h>

void countSetBits(int num)
{
    int count = 0;
    while(num > 0)
    {
        count = count + (num & 1);
        num = num>>1;
    }

    printf("%d\n", count);
}

int main()
{
    countSetBits(5);
    countSetBits(8);
    countSetBits(15);
    countSetBits(0);
    countSetBits(127);

    return 0;
}
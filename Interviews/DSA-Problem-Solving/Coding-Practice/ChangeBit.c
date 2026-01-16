#include <stdio.h>
#include <stdlib.h>

void changeBit(int num, int bit)
{
    int temp = 1;
    if(bit == 1)
    {
        num = num | 1;
        printf("%d\n", num);
        return;
    }
    while(bit>1)
    {
        temp = 2 * temp;
        bit--;
    }

    num = num | temp;

    printf("%d\n", num);
}

int main()
{
    changeBit(10, 3);

    return 0;
} 
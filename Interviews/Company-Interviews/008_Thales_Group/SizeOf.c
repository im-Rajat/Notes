// Calculate size of a variable without using sizeof
// https://www.geeksforgeeks.org/how-to-find-size-of-array-in-cc-without-using-sizeof-operator/


#include <stdio.h>

#define my_sizeof(type) (char*)(&type + 1) - (char*)(&type)

int main()
{
    int arr[] = {1, 2, 3, 4, 5};
    int size = sizeof(arr)/sizeof(arr[0]);
    int my_size = (my_sizeof(arr))/(my_sizeof(arr[0]));

    printf("%d %d", size, my_size);

    return 0;
}
// HPE 3rd Managerial/Technical Interview (Double Allocate)
// Create an m size array which contains pointer to n size arrays

#include <stdio.h>

void doubleAllocate(int m, int n) {
    // int arr[m][n];
	int *(arr)[m];

	int i;
	for(i = 0; i < m; i++) {
        int temp[n];
        int *tempPtr = temp;
        arr[i] = tempPtr;
    }
    for(i = 0; i < m; i++) {
        printf("%d ", arr + i);
    }
}

int main()
{
    doubleAllocate(6, 4);

    return 0;
}
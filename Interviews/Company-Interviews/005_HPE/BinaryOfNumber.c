// HPE 3rd Managerial/Technical Interview (Binary representation of a given number)
// https://www.geeksforgeeks.org/binary-representation-of-a-given-number/


#include <stdio.h>

// using recursion
void binaryRecursive(unsigned int n) {
	if( n > 1) {
		binaryRecursive(n / 2);
	}
	printf("%d", n % 2);
}

// this function will print in reverse order
void binaryReverse(unsigned int n) {
    while(n > 0) {
        printf("%d", n % 2);
        n = n / 2;
    }
}

// using bit manipulation
void binaryBitManipulation(unsigned int n) {
    for(int i = 31; i >=0 ; i--) {
        printf("%d", (n >> i) & 1);
    }
    // unsigned int i;
    // for(i = 1 << 31; i > 0; i = i / 2) {
    //     if(n & i) {
    //         printf("1");
    //     }
    //     else {
    //         printf("0");
    //     }
    // }
}

int main()
{
    int n = 10;
    binaryRecursive(10);
    printf("\n");

    binaryReverse(10);
    printf("\n");

    binaryBitManipulation(10);
    printf("\n");

    return 0;
}
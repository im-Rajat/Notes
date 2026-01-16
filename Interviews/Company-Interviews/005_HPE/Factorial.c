// HPE 1st Technical Interview (Example of Recursion)
// https://www.geeksforgeeks.org/program-for-factorial-of-a-number/


#include <stdio.h>

int factorial(int n);

int main()
{
    int res = factorial(5);
    printf("%d\n", res);
}

int factorial(int n) {
	if(n == 0) {
	    return 1;
	}

	return n * factorial(n-1);
}
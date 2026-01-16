// HPE 1st Technical Interview (Remove the duplicate elements from an array)
// https://www.geeksforgeeks.org/java-program-to-remove-duplicate-elements-from-the-array/

// Without using extra Space (https://www.javatpoint.com/remove-duplicate-elements-from-an-array-in-c)


#include <stdio.h>

int main()
{
    int a[7] = {11, 14, 15, 11, 14, 16, 17};
    int len = 7;

    int i, j, k;

    for(i =0; i < len; i++) {
        for(j = i + 1; j < len; j++){
            if(a[i] == a[j]) {
		        for(k = j; k < len - 1; k++){
                    a[k] = a[k + 1];
                }
                len--;
                j--;
		    }
        }
    }	

    for(i = 0; i < len; i++) {
        printf("%d ", a[i]);
    }
}
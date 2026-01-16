// HPE 3rd Managerial/Technical Interview (Pointers)
// What's the output of this pointer program?


#include <stdio.h>

void func(int* c) {
    // printf("&c = %d\n", &c);
    int d = 10;
    c = &d;
}

int main()
{
    int a = 5;
    int *b = &a;

    func(b);
    printf("a = %d, *b = %d\n", a, *b);
    // printf("&b = %d\n", &b);

    return 0;
}
#include <bits/stdc++.h>
using namespace std;

void add(int *a, int *b, int *sum)
{
	int res = *a;
	res += *b;
	sum  = &res;
}

int main()
{
	int a = 3;
	int b = 5;
	//int *res = malloc(sizeof(int*));
    int res;

	add(&a, &b, &res);
    printf("%d+%d=%d\n", a, b, res);
    // free(res);
}

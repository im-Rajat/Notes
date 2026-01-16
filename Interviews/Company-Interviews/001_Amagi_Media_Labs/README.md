# Interview Questions - Amagi Media Labs


**Round 1 : Online screening test** :
- MCQs mix of C, C++ and Python.
- Some MCQs carry negative marking.
- 1 coding question.


**Round 2 : Technical Interview - DSA/Coding/Problem Solving** :
- Problem 1 : Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].
The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
input = [1, 2, 3, 4]
output = [24, 12, 8, 6]
Without using division operator
In O(n) time complexity
Solution : @ProductofArrayExceptSelf.cpp

- Problem 2 : Down sample a N*N matrix to N/2*N/2. Assume N even
   E.g. Input
           1   2   1   2
           2   1   2   1
           2   5   1   3
           5   2   3   1
           
        Output
           1    1
           3    2
           
    Downsample by doing integer average of all 2x2.
Solution : @DownSampleMatrix.cpp

- Problem 3 : Simulate an unfair dice
Soltion : @SimulateUnfairDice.cpp


**Round 3 : Technical Interview - DSA/Coding/Problem Solving** :
- Problem 1 : We are getting an instantaneous loudness level from some source along with a timestamp. Write a function to find linear average loudness in the last  5 secs.
Example: 
T      L      loudness
1      10    10/1
1.2   12    (10+12)/2
2.6   8      (10+12+8)/3
6.5   9      (12+8+9)/3
Solution : @Timestamp.txt

- Problem 2 : Given a pointer related function, will that work? any bug is there?
Function : @Pointer.txt
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
            Int res;
	add(&a, &b, &res);
    	printf("%d+%d=%d\n", a, b, res);
    	free(res);
}



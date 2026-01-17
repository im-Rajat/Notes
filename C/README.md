# C Tutorial

## Variables

```c
char ch = 'a';
// some code
ch = 'l';

int number = 5;       // integer variable
number = 5.5;         // error
double number;        // error
```


## Output

```c
int testInteger = 5;
printf("Number = %d", testInteger);

float number1 = 13.5;
double number2 = 12.4;

printf("number1 = %f\n", number1);
printf("number2 = %lf", number2);

char chr = 'a';
printf("character = %c", chr);
```


## I/O Multiple Values

```c
scanf("%d%f", &a, &b);
```


## Scanning a String in C

```c
char str[20];
scanf("%[^\n]", str);
// Or
gets(str);
```


## The `sizeof` Operator

```c
sizeof(a)
```

- Size of int = 4 bytes
- Size of float = 4 bytes
- Size of double = 8 bytes
- Size of char = 1 byte


## if...else Ladder

```c
if (test expression1) {
   // statement(s)
}
else if(test expression2) {
   // statement(s)
}
...
else {
   // statement(s)
}
```


## for Loop

```c
for (i = 1; i < 11; ++i) {
    printf("%d ", i);
}
```


## while Loop

```c
while (i <= 5) {
    printf("%d\n", i);
    ++i;
}
```


## do...while Loop

```c
do {
    printf("Enter a number: ");
    scanf("%lf", &number);
    sum += number;
} while(number != 0.0);
```


## break Statement

The `break` statement ends the loop immediately when it is encountered.

```c
break;
```

Almost always used with `if...else` inside the loop.

## continue Statement

The `continue` statement skips the current iteration of the loop and continues with the next iteration.

```c
continue;
```

Almost always used with `if...else` inside the loop.

## switch Statement

```c
// Program to create a simple calculator
#include <stdio.h>

int main() {
    char operation;
    double n1, n2;

    printf("Enter an operator (+, -, *, /): ");
    scanf("%c", &operation);
    printf("Enter two operands: ");
    scanf("%lf %lf", &n1, &n2);

    switch(operation) {
        case '+':
            printf("%.1lf + %.1lf = %.1lf", n1, n2, n1 + n2);
            break;
        case '-':
            printf("%.1lf - %.1lf = %.1lf", n1, n2, n1 - n2);
            break;
        // operator doesn't match any case constant +, -, *, /
        default:
            printf("Error! operator is not correct");
    }
}
```


## goto Statement

```c
for (i = 1; i <= maxInput; ++i) {
    printf("%d. Enter a number: ", i);
    scanf("%lf", &number);

    // go to jump if the user enters a negative number
    if (number < 0.0) {
        goto jump;
    }
    sum += number;
}

jump:
average = sum / (i - 1);
printf("Sum = %.2f\n", sum);
printf("Average = %.2f", average);
```


## Functions

```c
#include <stdio.h>
void functionName() {
    // ... .. ...
}

int main() {
    // ... .. ...
    functionName();
    // ... .. ...
}
```


## Storage Class

Every variable in C has two properties: type and storage class.

- Type refers to the data type.
- Storage class determines scope, visibility, and lifetime.

**Types of storage class:**

- Automatic: by default local variable
- External: variable declared in another file
- static
- Register


### Register Variable

```c
register int x;
```

Register variables were supposed to be faster.

### Static Variable

```c
static int i;
```

Value persists until the end of the program.

## Arrays

```c
int data;

int mark = {19, 10, 8, 17, 9};
int mark[] = {19, 10, 8, 17, 9};
mark[2] = -1;
scanf("%d", &mark);

// Input and store in array
for (int i = 0; i < 5; ++i) {
    scanf("%d", &values[i]);
}

// Print elements of array
for (int i = 0; i < 5; ++i) {
    printf("%d\n", values[i]);
}
```


## Multidimensional Arrays

```c
float x[3];
float y;

// Initialization
int c[2] = {{1, 3, 0}, {-1, 5, 9}};
int c[][3] = {{1, 3, 0}, {-1, 5, 9}};
int c[2] = {1, 3, 0, -1, 5, 9};

int test[2] = {
    {{3, 4, 2, 3}, {0, -3, 9, 11}, {23, 12, 23, 2}},
    {{13, 4, 56, 3}, {5, 9, 3, 5}, {3, 1, 4, 9}}
};

void displayNumbers(int num[][2]) {
    // code
}
```


## Pointers

**Address in C:** If you have a variable `var`, `&var` gives its address.

**Pointers store addresses:**

```c
int *p1;
int *p2;

int* pc, c;
c = 5;
pc = &c;
printf("%d", *pc);  // Output: 5
```


### Relationship Between Arrays and Pointers

```c
int x[4];
int i;

for(i = 0; i < 4; ++i) {
    printf("&x[%d] = %p\n", i, &x[i]);
}
printf("Address of array x: %p", x);
```

- Difference of 4 bytes between two consecutive elements (for int).
- `&x` and `x` are the same address.
- `&x[i]` is equivalent to `x+i`; `x[i]` is equivalent to `*(x+i)`.

```c
for(i = 0; i < 6; ++i) {
    // Equivalent to scanf("%d", &x[i]);
    scanf("%d", x+i);

    // Equivalent to sum += x[i]
    sum += *(x+i);
}
```


### Pass Addresses to Functions

```c
swap(&n1, &n2); // Pass the addresses of n1 and n2
void swap(int* n1, int* n2) { // Passing by Pointer
    int temp;
    temp = *n1;
    *n1 = *n2;
    *n2 = temp;
}
```

```c
swap(x, y); // Passing by Reference (Not possible in C; only in C++)
void swap(int& x, int& y) {
    int z = x;
    x = y;
    y = z;
}
```


### Passing Pointers to Functions

```c
#include <stdio.h>
void addOne(int* ptr) {
    (*ptr)++; // adding 1 to *ptr
}

int main() {
    int* p, i = 10;
    p = &i;
    addOne(p);

    printf("%d", *p); // 11
    return 0;
}
```

> **Note:** True **pass-by-reference** using the `&` symbol in the function signature (`void swap(int& x, int& y)`) is a feature of C++, not C.


## Dynamic Memory Allocation

To allocate memory dynamically, use `malloc()`, `calloc()`, `realloc()`, and `free()`, defined in `<stdlib.h>`.

### malloc()

Reserves a block of memory.

```c
ptr = (castType*) malloc(size);
ptr = (float*) malloc(100 * sizeof(float));
```


### calloc()

Allocates and initializes to zero.

```c
ptr = (castType*) calloc(n, size);
ptr = (float*) calloc(25, sizeof(float));
```


### free()

Frees dynamically allocated memory.

```c
free(ptr);
```


### realloc()

Changes size of previously allocated memory.

```c
ptr = realloc(ptr, x);
```


## Strings

A string is a sequence of characters terminated with `\0`.

```c
char c[] = "c string";

char s;
char c[] = "abcd";
char c[50] = "abcd";
char c[] = {'a', 'b', 'c', 'd', '\0'};
char c[5] = {'a', 'b', 'c', 'd', '\0'};
```

```c
char c[100];
c = "C programming"; // Error! array type is not assignable.
// Use strcpy() to copy the string
```


### scanf() to Read a String

```c
char name[20];
printf("Enter name: ");
scanf("%s", name);
printf("Your name is %s.", name);

// Scan a sentence
char str[20];
scanf("%[^\n]", str);
// Or
gets(str);
```


### How to Read a Line of Text?

```c
char name[30];
printf("Enter name: ");
fgets(name, sizeof(name), stdin);  // read string
printf("Name: ");
puts(name);    // display string
return 0;
```

*Note: gets() is removed from standard C due to security risk (buffer overflow).*

### Strings and Pointers

```c
char name[] = "Harry Potter";
printf("%c", *name);      // Output: H
printf("%c", *(name+1));  // Output: a
```


### Commonly Used String Functions (string.h)

- `strlen()`  : length of string
- `strcpy()`  : copy string
- `strcmp()`  : compare strings
- `strcat()`  : concatenate strings
- `strlwr()`  : convert to lowercase
- `strupr()`  : convert to uppercase


### gets() and puts()

```c
char name;
printf("Enter name: ");
gets(name);     // Read string
printf("Name: ");
puts(name);     // Display string
return 0;
```


## Structures (`struct`)

### Syntax

```c
struct structureName {
  dataType member1;
  dataType member2;
  ...
};
```

**Example:**

```c
struct Person {
  char name[50];
  int citNo;
  float salary;
};
```

Create struct variables:

```c
struct Person person1, person2, p[20];
```

Access members using `.` for variable and `->` for pointer.

### Keyword `typedef`

Simplifies declaring variables.

```c
typedef struct Distance {
  int feet;
  float inch;
} distances;

int main() {
  distances d1, d2;
}
```


### Nested Structures

```c
struct complex {
  int imag;
  float real;
};

struct number {
  struct complex comp;
  int integers;
} num1, num2;
```


### Pointers to Struct

```c
struct person
{
   int age;
   float weight;
};

struct person *personPtr, person1;
personPtr = &person1;

printf("Enter age: ");
scanf("%d", &personPtr->age);

printf("Enter weight: ");
scanf("%f", &personPtr->weight);

printf("Displaying:\n");
printf("Age: %d\n", personPtr->age);
printf("weight: %f", personPtr->weight);

// personPtr->age == (*personPtr).age
// personPtr->weight == (*personPtr).weight
```

Allocate memory for n struct persons:

```c
ptr = (struct person*) malloc(n * sizeof(struct person));
```


### Passing Structs to Functions

```c
struct student {
   char name[50];
   int age;
};

struct student s1;

printf("Enter name: ");
// read string input from the user until \n is entered; \n is discarded
scanf("%[^\n]%*c", s1.name);

printf("Enter age: ");
scanf("%d", &s1.age);

display(s1); // passing struct as argument

void display(struct student s) {
    printf("\nDisplaying information\n");
    printf("Name: %s", s.name);
    printf("\nAge: %d", s.age);
}
```


### Returning Struct from Function

```c
struct student getInformation() {
  struct student s1;

  printf("Enter name: ");
  scanf ("%[^\n]%*c", s1.name);

  printf("Enter age: ");
  scanf("%d", &s1.age);

  return s1;
}

struct student s;
s = getInformation();
```


### Passing Struct by Reference

```c
typedef struct Complex {
    float real;
    float imag;
} complex;

complex c1, c2, result;
addNumbers(c1, c2, &result);

void addNumbers(complex c1, complex c2, complex *result) {
    result->real = c1.real + c2.real;
    result->imag = c1.imag + c2.imag;
}
```


## Unions

```c
union car {
  char name[50];
  int price;
};

int main() {
  union car car1, car2, *car3;
  return 0;
}

// or

union car {
  char name[50];
  int price;
} car1, car2, *car3;
```

**Access members:** Use `.` for variable, `->` for pointer.

- Size is that of largest element.
- All members share the same memory.


## Enums

```c
enum flag {const1, const2, ..., constN};

// Changing default values
enum suit {
    club = 0,
    diamonds = 10,
    hearts = 20,
    spades = 3,
};

enum boolean {false, true};
enum boolean check; // declaring an enum variable

enum week {Sunday, Monday, Tuesday, Wednesday, Thursday, Friday, Saturday};

int main() {
    enum week today;
    today = Wednesday;
    printf("Day %d", today + 1);
    return 0;
}
```


## Preprocessor and Macros

**Compilation Flow:**
C Source Code → Preprocessor → Compile

The C preprocessor transforms your program before compilation by including files, macro expansion, etc.

All preprocessor directives begin with `#`.

```c
#define PI 3.14
```

**Include header files:**

```c
#include <stdio.h>
```

**Macros using `#define`:**

```c
#define c 299792458 // speed of light

#define PI 3.1415
#define circleArea(r) (PI*r*r)
```

**Conditional Compilation:**

```c
#ifdef MACRO
   // conditional codes
#endif
```


## Standard Library Functions

**Square root using `sqrt()` function:**

```c
#include <math.h>

root = sqrt(num);
```


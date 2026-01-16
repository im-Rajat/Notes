// Endovision AI 2nd round question (Design a Data Structure SpecialStack that supports all the stack operations like push(), pop(), 
// isEmpty(), isFull() and an additional operation getMin() which should return minimum element from the SpecialStack.
// All these operations of SpecialStack must be O(1). To implement SpecialStack, you should only use standard Stack data structure
// and no other data structure like arrays, list, . etc. )
// https://www.geeksforgeeks.org/design-and-implement-special-stack-data-structure/


#include <bits/stdc++.h>
using namespace std;

class Stack
{
    private:
        static const int max = 1000;
        int s[max];
        int top;
    
    public:
        Stack()
        {
            top = -1;
        }

        bool isEmpty()
        {
            if(top == -1)
            {
                return true;
            }
            else
            {
                return false;
            }
        }

        bool isFull()
        {
            if(top == max - 1)
            {
                return true;
            }
            else
            {
                return false;
            }
        }

        void push(int value)
        {
            if(isFull())
            {
                cout<<"Stack Overflow\n";
            }
            else
            {
                top++;
                s[top] = value;
            }
        }

        int pop()
        {
            if(isEmpty())
            {
                cout<<"Stack Underflow\n";
                abort();
            }
            else
            {
                int pop_value = s[top];
                top--;
                return pop_value;
            }
        }
};

class SpecialStack : public Stack
{
    private:
        Stack min;
    
    public:
        void push(int value)
        {
            if(isEmpty())
            {
                Stack::push(value);
                min.push(value);
            }
            else
            {
                Stack::push(value);
                int temp_min = min.pop();
                min.push(temp_min);
                if(value < temp_min)
                {
                    min.push(value);
                }
                else
                {
                    min.push(temp_min);
                }
            }
        }

        int pop()
        {
            int pop_value = Stack::pop();
            min.pop();
            return pop_value;
        }

        int getMin()
        {
            int min_value = min.pop();
            min.push(min_value);
            return min_value;
        }
};


int main()
{
    SpecialStack ss;
    ss.push(2);
    ss.push(10);
    ss.push(3);
    ss.push(0);
    ss.push(9);
    cout<<ss.getMin()<<endl;
    ss.pop();
    cout<<ss.getMin()<<endl;
    ss.pop();
    cout<<ss.getMin()<<endl;

    return 0;
}
// Endovision AI 1st round question (Check if given string of parenthesis is balanced or not)


#include <bits/stdc++.h>
using namespace std;

bool isBalanced(string str)
{
    stack<char> s;
    int i = 0;
    if(str[0] == '(' || str[0] == '['  || str[0] == '{')
    {
        s.push(str[i]);
    }
    else
    {
        return false;
    }


    for(i = 1; i < str.length(); i++)
    {
        if(str[i] == '(' || str[i] == '['  || str[i] == '{')
        {
            s.push(str[i]);
        }
        else
        {
            if(s.empty())
            {
                return false;
            }
            char a = s.top();
            if(a == '(' && str[i] == ')')
            {
                s.pop();
            }
            else if(a == '{' && str[i] == '}')
            {
                s.pop();
            }
            else if(a == '[' && str[i] == ']')
            {
                s.pop();
            }
            else
            {
                cout<<"Hello";
                return false;
            }
        }
    }

    if(s.empty())
    {
        return true;
    }
    else
    {
        return false;
    }
}

int main()
{
    string str;
    cin>>str;
    bool ans = isBalanced(str);
    cout<<ans;

}
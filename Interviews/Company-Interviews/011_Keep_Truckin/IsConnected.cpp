// KeepTruckin 2nd round question (If 2 given strings are connected or not, if not connect them)


#include <bits/stdc++.h>
using namespace std;

vector<set<string>> v;

void printData()
{
    for(int i = 0; i < v.size(); i++)
    {
        for(auto it : v[i])
        {
            cout<<it<<" ";
        }
        cout<<endl;
    }
}

bool isConnected(string a, string b)
{
    int n = v.size();
    if(n == 0)
    {
        set<string> s;
        s.insert(a);
        s.insert(b);
        v.push_back(s);
        return false;
    }

    int ai = -1, bi = -1;
    for(int i = 0; i < v.size(); i++)
    {
        auto it1 = v[i].find(a);
        auto it2 = v[i].find(b);

        if(it1 != v[i].end() && it2 != v[i].end())
        {
            return true;
        }
        else if(it1 == v[i].end() && it2 == v[i].end())
        {
            if(i == v.size() - 1)
            {
                set<string> newtemp;
                newtemp.insert(a);
                newtemp.insert(b);
                v.push_back(newtemp);
                return false;
            }
        }
        else if(it1 != v[i].end())
        {
            ai = i;
        }
        else if(it2 != v[i].end())
        {
            bi = i;
        }
    }

    if(ai != -1 && bi != -1)
    {
        if(ai < bi)
        {
            v[ai].insert(v[bi].begin(), v[bi].end());
            v.erase(v.begin() + bi);
        }
        else if(ai > bi)
        {
            v[bi].insert(v[ai].begin(), v[ai].end());
            v.erase(v.begin() + ai);
        }
    }

    if(ai == -1)
    {
        v[bi].insert(a);
    }
    else if(bi == -1)
    {
        v[ai].insert(b);
    }

    // cout<<count<<endl;

    return false;
}

int main()
{
    bool ans;
    ans = isConnected("a", "b");
    printData();
    cout<<"ans : "<<ans<<"\n\n";

    ans = isConnected("b", "a");
    printData();
    cout<<"ans : "<<ans<<"\n\n";

    ans = isConnected("c", "a");
    printData();
    cout<<"ans : "<<ans<<"\n\n";

    ans = isConnected("d", "e");
    printData();
    cout<<"ans : "<<ans<<"\n\n";

    ans = isConnected("e", "c");
    printData();
    cout<<"ans : "<<ans<<"\n\n";

    ans = isConnected("e", "x");
    printData();
    cout<<"ans : "<<ans<<"\n\n";

    ans = isConnected("a", "x");
    printData();
    cout<<"ans : "<<ans<<"\n\n";

    ans = isConnected("f", "xas");
    printData();
    cout<<"ans : "<<ans<<"\n\n";

    ans = isConnected("a", "xas");
    printData();
    cout<<"ans : "<<ans<<"\n\n";

    return 0;
}
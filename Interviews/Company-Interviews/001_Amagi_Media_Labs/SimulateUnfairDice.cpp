#include <bits/stdc++.h>
using namespace std;


int main()
{
    double num = double( 0 + (rand() % 9));

    num = num / 10;

    if (num < 0.1) {
        cout<<1;
    }
    else if (num < 0.2) {
        cout<<2;
    }
    else if (num < 0.3) {
        cout<<3;
    }
    else if (num < 0.4) {
        cout<<4;
    }
    else if (num < 0.5) {
        cout<<6;
    }
    else {
        cout<<5;
    }

}
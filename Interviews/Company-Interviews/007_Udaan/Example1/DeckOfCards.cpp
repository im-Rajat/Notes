// Reference : https://www.youtube.com/watch?v=f5vvgHX9coI&ab_channel=BradleySward


#include <bits/stdc++.h>
#include "Deck.h"
using namespace std;


int main()
{
    Deck deck;
    deck.Shuffle();
    deck.Print();
    cout<<endl;

    Card* card = deck.TopCard();
    card->Print();
    cout<<endl;

    deck.PopCard();
    deck.Print();
    cout<<endl;

    system("pause");

    return 0;
}
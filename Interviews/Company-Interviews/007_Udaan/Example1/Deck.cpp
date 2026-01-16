#include <iostream>
#include <algorithm>
#include "Deck.h"
using namespace std;

Deck::Deck() : deck()
{
    // deck.reserve(52);
    for(Card::Ranks r = Card::TWO; r <= Card::ACE; r = static_cast<Card::Ranks>(static_cast<int>(r) + 1))
    {
        for(Card::Suits s = Card::HEARTS; s <= Card::SPADES; s = static_cast<Card::Suits>(static_cast<int>(s) + 1))
        {
            // cout<<r<<" "<<s<<endl;
            // Card* card = new Card(r, s);
            // card->Print();
            // cout<<endl;
            // deck.push_back(new Card(r, s));
            deck.push_front(new Card(r, s));
        }
    }
}

Deck::~Deck()
{
    for(Card* card : deck)
    {
        delete card;
    }
    deck.clear();
}

void Deck::Print()
{
    for(Card* card : deck)
    {
        card->Print();
        cout<<" ";
    }
}

void Deck::Shuffle()
{
    random_shuffle(deck.begin(), deck.end());
}

Card* Deck::TopCard()
{
    return deck.front();
}

void Deck::PopCard()
{
    deck.push_back(deck.front());
    deck.erase(deck.begin());
}
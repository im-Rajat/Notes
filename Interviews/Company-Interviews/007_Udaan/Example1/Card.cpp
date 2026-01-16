#include <iostream>
#include "Card.h"
using namespace std;

Card::Card(Ranks RANK, Suits SUIT) : Rank(RANK), Suit(SUIT)
{
    // Nothing here...
}

Card::~Card()
{
    // Nothing here...
    // A virtual distructor is only here so that i make sure i ever derive from this i don't have any memory leaks of any kind
}

Card::Ranks Card::GetRank()
{
    return Rank;
}

Card::Suits Card::GetSuit()
{
    return Suit;
}

int Card::GetFaceValue()
{
    if(Rank <= TEN)
    {
        return static_cast<int>(Rank);
    }

    if(Rank <= KING)
    {
        return 10;
    }

    return 11;
}

void Card::Print()
{
    if(Rank <= TEN)
        cout << Rank;
    else if(Rank == JACK)
        cout << "J";
    else if(Rank == QUEEN)
        cout << "Q";
    else if(Rank == KING)
        cout << "K";
    else
        cout << "A";

    if(Suit == HEARTS)
    {
        cout << "H";
    }
    else if(Suit == DIAMONDS)
    {
        cout << "D";
    }
    else if(Suit == CLUBS)
    {
        cout << "C";
    }
    else if(Suit == SPADES)
    {
        cout << "S";
    }
}
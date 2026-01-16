#pragma once

#include <vector>
#include <deque>
#include "Card.h"
using namespace std;

class Deck
{
    public:
        Deck();
        ~Deck();

        void Print();
        void Shuffle();

        Card* TopCard();
        void PopCard();

    private:
        // vector<Card*> deck;
        deque<Card*> deck;
};
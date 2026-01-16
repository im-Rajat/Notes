#pragma once

class Card
{
    public:
        enum Suits
        {
            HEARTS = 3,
            DIAMONDS,
            CLUBS,
            SPADES
        };

        enum Ranks
        {
            TWO = 2,
            THREE,
            FOUR,
            FIVE,
            SIX,
            SEVEN,
            EIGHT,
            NINE,
            TEN,
            JACK,
            QUEEN,
            KING,
            ACE
        };

        Card(Ranks RANK, Suits SUIT);
        virtual ~Card();

        Ranks GetRank();
        Suits GetSuit();

        virtual int GetFaceValue();

        void Print();

    private:
        Ranks Rank;
        Suits Suit;

};
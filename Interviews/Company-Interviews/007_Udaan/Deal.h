#pragma once

#include<bits/stdc++.h>
using namespace std;

class Deal
{
    private:
        int dealNumber;
        int numOfItems;
        int maxTime;        // in minutes
    public:
        Deal(int dealNumber, int numOfItems, int maxTime);
        ~Deal();
        void updateItems(int update_items);
        void updateTime(int update_time);
        void endDeal();
        void PrintDeal();
        int getDealNumber();
};
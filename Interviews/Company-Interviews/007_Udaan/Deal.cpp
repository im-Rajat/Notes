#include "Deal.h"

Deal::Deal(int dealNumber, int numOfItems, int maxTime) : dealNumber(dealNumber), numOfItems(numOfItems), maxTime(maxTime) 
{

}

Deal::~Deal()
{

}

void Deal::updateItems(int update_items)
{
    this->numOfItems = this->numOfItems + update_items;
}

void Deal::updateTime(int update_time)
{
    this->maxTime = this->maxTime + update_time;
}

void Deal::PrintDeal()
{
    cout<<"Deal Number : "<<this->dealNumber<<endl;
    cout<<"Number of Items : "<<this->numOfItems<<endl;
    cout<<"Max Time : " <<this->maxTime<<endl;
    cout<<endl;
}

void Deal::endDeal()
{
    this->numOfItems = 0;
    this->maxTime = 0;
}

int Deal::getDealNumber()
{
    return dealNumber;
}
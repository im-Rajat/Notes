#include "Deal.h"
#include "User.h"

int main()
{
    int data;
    cout<<"Enter 1 (Dealer), Enter 2 (User), Enter 0 (Exit): ";
    cin>>data;
    vector<Deal> vec;
    while(data!=0)
    {
        if(data == 1)
        {
            int data2;
            cout<<"Enter 1 (Create a Deal)\n";
            cout<<"Enter 2 (Update item of deal)\n";
            cout<<"Enter 3 (Update time of deal)\n";
            cout<<"Enter 4 (End a Deal)\n";
            cout<<"Enter 5 (View a Deal)\n";
            cin>>data2;

            if(data2 == 1)
            {
                int a, b, c;
                cout<<"Enter Deal No, Max Items, Max Time : ";
                cin>>a>>b>>c;
                Deal deal(a, b, c);
                vec.push_back(deal);
            }
            else if(data2 == 2)
            {
                int a, b;
                cout<<"Enter Deal number, num of items to add : ";
                cin>>a>>b;
                for(auto i = vec.begin(); i!=vec.end(); i++)
                {
                    if(i->getDealNumber() == a)
                    {
                        i->updateItems(b);
                    }
                }
                
            }
            else if(data2 == 3)
            {
                int a, b;
                cout<<"Enter Deal number, time to addon : ";
                cin>>a>>b;
                for(auto i = vec.begin(); i!=vec.end(); i++)
                {
                    if(i->getDealNumber() == a)
                    {
                        i->updateTime(b);
                    }
                }
            }
            else if(data2 == 4)
            {
                
            }
            else if(data2 == 5)
            {
                int a;
                cout<<"Enter Deal number : ";
                cin>>a;
                for(auto i = vec.begin(); i!=vec.end(); i++)
                {
                    if(i->getDealNumber() == a)
                    {
                        i->PrintDeal();
                    }
                }
            }
        }
        else if(data == 2)
        {
            int id;
            cout<<"Enter your id: ";
            cin>>id;

            User user(id);
            int dealnum;
            cout<<"Enter deal num";
            cin>>dealnum;

            for(auto i = vec.begin(); i!=vec.end(); i++)
                {
                    if(i->getDealNumber() == dealnum)
                    {
                        cout<<"Deal exist, details : \n";
                        i->PrintDeal();
                        
                    }
                }

            

        }
        cout<<"Enter 1 (Dealer), Enter 2 (User), Enter 0 (Exit): ";
        cin>>data;
    }

    

    

    // Deal deal1(1, 20, 120);
    // deal1.PrintDeal();
    // deal1.updateItems(10);
    // deal1.PrintDeal();
    // deal1.updateTime(30);
    // deal1.PrintDeal();
    
    // Deal deal2(2, 100, 60);
    // deal2.PrintDeal();
    // deal2.updateItems(-50);
    // deal2.PrintDeal();

}
// KeepTruckin 1st round question (Reverse Linked List using Recursion)


#include <bits/stdc++.h>
using namespace std;

class Node      // using class instead of struct
{
    public:
        int data;
        Node* next;
        Node(int data, Node *next)
        {
            this->data = data;
            this->next = next;
        }
};

void printReverseLinkedList(Node* head)
{
    if(head->next != NULL)
    {
       printReverseLinkedList(head->next);
    }
    cout<<head->data<<" ";
}



int main()
{
    Node *n1 = new Node(1, NULL);
    // n1->next = NULL;

    Node *n2 = new Node(2, n1);
    // n2->next = n1;

    Node *n3 = new Node(3, n2);
    // n3->next = n2;

    Node *n4 = new Node(4, n3);
    // n4->next = n3;

    Node *n5 = new Node(5, n4);
    // n5->next = n4;

    printReverseLinkedList(n5);
}
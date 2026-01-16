// KeepTruckin 1st round question (Reverse Linked List using Recursion)


#include <bits/stdc++.h>
using namespace std;

struct Node
{
    int data;
    Node* next;
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
    Node *n1 = new Node();
    n1->data = 1;
    n1->next = NULL;

    Node *n2 = new Node();
    n2->data = 2;
    n2->next = n1;

    Node *n3 = new Node();
    n3->data = 3;
    n3->next = n2;

    Node *n4 = new Node();
    n4->data = 4;
    n4->next = n3;

    Node *n5 = new Node();
    n5->data = 5;
    n5->next = n4;

    printReverseLinkedList(n5);
}
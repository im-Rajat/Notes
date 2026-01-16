//  Thales Group 1st Technical Interview (Reverse a Linked List)


#include <stdio.h>
#include <stdlib.h>

struct Node
{
    int data;
    struct Node* next;
};

void printLinkedList(struct Node* head)
{
    struct Node* temp = head;
    while(temp!=NULL)
    {
        printf("%d ", temp->data);
        temp = temp->next;
    }
}

struct Node* reverseLinkedList(struct Node* head)
{
    struct Node* curr = head;
    struct Node* prev = NULL;
    struct Node* next = NULL;

    while(curr!=NULL)
    {
        next = curr->next;
        curr->next = prev;
        prev = curr;
        curr = next;
    }

    head = prev;
    return head;
    // printf("\n");
    // printLinkedList(head);
}

int main()
{
    struct Node* a = (struct Node*)malloc(sizeof(struct Node));
    a->data = 5;
    a->next = NULL;

    struct Node* b = (struct Node*)malloc(sizeof(struct Node));
    b->data = 4;
    b->next = a;

    struct Node* c = (struct Node*)malloc(sizeof(struct Node));
    c->data = 3;
    c->next = b;

    struct Node* d = (struct Node*)malloc(sizeof(struct Node));
    d->data = 2;
    d->next = c;

    struct Node* e = (struct Node*)malloc(sizeof(struct Node));
    e->data = 1;
    e->next = d;

    struct Node* head = e;
    printLinkedList(head);
    printf("\n");

    struct node *new_head = reverseLinkedList(e);
    printLinkedList(new_head);
}
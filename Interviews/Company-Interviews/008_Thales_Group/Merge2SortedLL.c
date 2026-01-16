// Thales Group 2nd Technical Interview (Merge 2 sorted linked list)
// https://www.geeksforgeeks.org/merge-two-sorted-lists-place/


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
    while(temp != NULL)
    {
        printf("%d ", temp->data);
        temp = temp->next;
    }
}

struct Node* mergeRecursive(struct Node* head1, struct Node* head2)
{
    if(head1 == NULL)
    {
        return head2;
    }
    if(head2 == NULL)
    {
        return head1;
    }

    if(head1->data < head2->data)
    {
        head1->next = mergeRecursive(head1->next, head2);
        return head1;
    }
    if(head1->data > head2->data)
    {
        head2->next = mergeRecursive(head1, head2->next);
        return head2;
    }

}



int main()
{
    struct Node* l1n1 = (struct Node*)malloc(sizeof(struct Node));
    l1n1->data = 7;
    l1n1->next = NULL;

    struct Node* l1n2 = (struct Node*)malloc(sizeof(struct Node));
    l1n2->data = 5;
    l1n2->next = l1n1;

    struct Node* l1n3 = (struct Node*)malloc(sizeof(struct Node));
    l1n3->data = 3;
    l1n3->next = l1n2;

    struct Node* l1n4 = (struct Node*)malloc(sizeof(struct Node));
    l1n4->data = 1;
    l1n4->next = l1n3;

    struct Node* head1 = l1n4;

    struct Node* l2n1 = (struct Node*)malloc(sizeof(struct Node));
    l2n1->data = 8;
    l2n1->next = NULL;

    struct Node* l2n2 = (struct Node*)malloc(sizeof(struct Node));
    l2n2->data = 6;
    l2n2->next = l2n1;

    struct Node* l2n3 = (struct Node*)malloc(sizeof(struct Node));
    l2n3->data = 4;
    l2n3->next = l2n2;

    struct Node* l2n4 = (struct Node*)malloc(sizeof(struct Node));
    l2n4->data = 2;
    l2n4->next = l2n3;

    struct Node* head2 = l2n4;

    printLinkedList(head1);
    printf("\n");
    printLinkedList(head2);
    printf("\n");

    struct Node* newHead = mergeRecursive(head1, head2);
    printLinkedList(newHead);
    
    return 0;
}
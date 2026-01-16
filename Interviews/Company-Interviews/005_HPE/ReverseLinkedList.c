// HPE 1st Technical Interview (Reverse Linked List)
// https://www.geeksforgeeks.org/reverse-a-linked-list/


#include <stdio.h>
#include <stdlib.h>

struct Node {
    int data;
    struct Node* next;
};

void printLinkedList(struct Node* head) {
    while(head != NULL) {
        printf("%d ", head->data);
        head = head->next;
    }
}

struct Node* reverseLinkedList(struct Node *head) {
    struct Node* prev = NULL;
    struct Node* curr = head;
    struct Node* next = NULL;

	while(curr != NULL) {
        next = curr->next;
        curr->next = prev;
        prev = curr;
        curr = next;
	}

	return prev;
}

int main()
{
    struct Node* n1 = (struct Node*)malloc(sizeof(struct Node));
    struct Node* n2 = (struct Node*)malloc(sizeof(struct Node));
    struct Node* n3 = (struct Node*)malloc(sizeof(struct Node));
    struct Node* n4 = (struct Node*)malloc(sizeof(struct Node));
    struct Node* n5 = (struct Node*)malloc(sizeof(struct Node));

    n5->data = 5;
    n4->data = 4;
    n3->data = 3;
    n2->data = 2;
    n1->data = 1;

    n1->next = n2;
    n2->next = n3;
    n3->next = n4;
    n4->next = n5;
    n5->next = NULL;

    printLinkedList(n1);
    printf("\n");
    struct Node* newHead = reverseLinkedList(n1);
    printLinkedList(newHead);

    return 0;
}
// HPE 2nd Technical Interview (Insert in sorted linked list)
// https://www.geeksforgeeks.org/given-a-linked-list-which-is-sorted-how-will-you-insert-in-sorted-way/


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

struct Node* sortedInsert(struct Node* head, int n) {

	struct Node* curr = head;
	struct Node* newNode = (struct Node*)malloc(sizeof(struct Node));

    newNode->data = n;
	newNode->next = NULL;
	
	if(n <= curr->data) {
        head = newNode;
        newNode->next = curr;
        return head;
	}

	while(curr->next != NULL) {
		if(curr->data <= n && n < curr->next->data) {
			newNode->next = curr->next;
			curr->next = newNode;
			return head;	
		}
		curr = curr->next;
	}

	curr->next = newNode;
	return head;
}

int main()
{
    struct Node* n1 = (struct Node*)malloc(sizeof(struct Node));
    struct Node* n2 = (struct Node*)malloc(sizeof(struct Node));
    struct Node* n3 = (struct Node*)malloc(sizeof(struct Node));
    struct Node* n4 = (struct Node*)malloc(sizeof(struct Node));
    struct Node* n5 = (struct Node*)malloc(sizeof(struct Node));

    n5->data = 10;
    n4->data = 8;
    n3->data = 4;
    n2->data = 2;
    n1->data = 0;

    n1->next = n2;
    n2->next = n3;
    n3->next = n4;
    n4->next = n5;
    n5->next = NULL;

    struct Node* newHead;

    printLinkedList(n1);
    printf("\n");

    newHead = sortedInsert(n1, 3);
    printLinkedList(newHead);
    printf("\n");

    newHead = sortedInsert(n1, -1);
    printLinkedList(newHead);
    printf("\n");
    
    newHead = sortedInsert(n1, 100);
    printLinkedList(newHead);
    printf("\n");

    return 0;
}
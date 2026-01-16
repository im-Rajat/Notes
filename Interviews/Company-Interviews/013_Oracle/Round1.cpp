#include <iostream>
using namespace std;


bool linkedlist_loop (struct node* head) {
    struct node* slow = head;
    struct node* fast = head;

    while (fast != null && fast->next != null) {
        if (slow == fast) {
           slow = head;

           while (slow != fast) {
                slow = slow->next;
                fast = fast->next;
           }

           slow->next = NULL;
        }
        slow = slow->next;
        fast = fast->next->next;
    }

    return false;
}

// 1 -> 2 -> 3 -> 4-> 5    ->    3

int main()
{
    int len = 6;
    int a[6] = {3, 4, 2, 4, 8, 5};
    int key = 4;

    int newlen = deleteKey(a, key, len);
    cout<<newlen<<endl;

    for (int i = 0; i < len; i++) {
        cout<<a[i]<<" ";
    }

    return 0;
}

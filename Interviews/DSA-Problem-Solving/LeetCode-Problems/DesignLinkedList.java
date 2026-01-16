// 707. Design Linked List
// https://leetcode.com/problems/design-linked-list/


class MyLinkedList {

    private Node head;
    private int size;

    public class Node {
        int val;
        Node next;

        Node() {}
        Node(int val) {
            this.val = val;
            this.next = null;
        }
        Node(int val, Node next) {
            this.val = val;
            this.next = next;
        }
    }

    public MyLinkedList() {
        this.size = 0;
        this.head = null;
    }

    public int get(int index) {
        if (index < 0 || index >= size) {
            return -1;
        }

        Node curr = head;
        for(int i = 0; i < index; i++) {
            curr = curr.next;
        }

        return curr.val;
    }

    public void addAtHead(int val) {
        Node newNode = new Node(val);
        newNode.next = this.head;
        this.head = newNode;
        this.size++;
    }

    public void addAtTail(int val) {
        Node newNode = new Node(val);

        if (this.size == 0) {
            addAtHead(val);
            return;
        }
        
        Node curr = head;
        while (curr.next != null) {
            curr = curr.next;
        }
        curr.next = newNode;
        this.size++;
    }

    public void addAtIndex(int index, int val) {
        if (index < 0 || index > this.size) {
            return;
        }

        if (index == 0) {
            addAtHead(val);
        }
        else if (index == this.size) {
            addAtTail(val);
        }
        else {
            Node newNode = new Node(val);
            Node curr = head;
            for(int i = 0; i < index - 1; i++) {
                curr = curr.next;
            }

            newNode.next = curr.next;
            curr.next = newNode;
            this.size++;
        }
    }

    public void deleteAtIndex(int index) {
        if (index < 0 || index >= this.size) {
            return;
        }
        if (index == 0) {
            this.head = this.head.next;
        }
        else {
            Node curr = head;
            for (int i = 0; i < index - 1; i++) {
                curr = curr.next;
            }

            curr.next = curr.next.next;
        }
        this.size--;
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */

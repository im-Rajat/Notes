// HPE 2nd Technical Interview (Binary search tree traversals)
// https://www.geeksforgeeks.org/tree-traversals-inorder-preorder-and-postorder/
// https://www.geeksforgeeks.org/level-order-tree-traversal/


#include <stdio.h>
#include <stdlib.h>

struct TreeNode {
    int data;
    struct TreeNode* left;
    struct TreeNode* right;
};

void preOrder(struct TreeNode* root) {
    if(root == NULL) {
        return;
    }
    printf("%d ", root->data);
    preOrder(root->left);
    preOrder(root->right);
}

void inOrder(struct TreeNode* root) {
    if(root == NULL) {
        return;
    }
    inOrder(root->left);
    printf("%d ", root->data);
    inOrder(root->right);
}

void postOrder(struct TreeNode* root) {
    if(root == NULL) {
        return;
    }
    postOrder(root->left);
    postOrder(root->right);
    printf("%d ", root->data);
}

void levelOrder(struct TreeNode* root) {
    // Can Solve using Queue
}

int main()
{ 
//    	     4
//	  2		        6
// 1	 3	     5	   7
    struct TreeNode* n1 = (struct TreeNode*)malloc(sizeof(struct TreeNode));
    struct TreeNode* n2 = (struct TreeNode*)malloc(sizeof(struct TreeNode));
    struct TreeNode* n3 = (struct TreeNode*)malloc(sizeof(struct TreeNode));
    struct TreeNode* n4 = (struct TreeNode*)malloc(sizeof(struct TreeNode));
    struct TreeNode* n5 = (struct TreeNode*)malloc(sizeof(struct TreeNode));
    struct TreeNode* n6 = (struct TreeNode*)malloc(sizeof(struct TreeNode));
    struct TreeNode* n7 = (struct TreeNode*)malloc(sizeof(struct TreeNode));

    n4->data = 4;
    n2->data = 2;
    n1->data = 1;
    n3->data = 3;
    n6->data = 6;
    n5->data = 5;
    n7->data = 7;

    n1->left = n1->right = NULL;
    n3->left = n3->right = NULL;
    n5->left = n5->right = NULL;
    n7->left = n7->right = NULL;
    n2->left = n1;
    n2->right = n3;
    n6->left = n5;
    n6->right = n7;
    n4->left = n2;
    n4->right = n6;

    preOrder(n4);
    printf("\n");
    inOrder(n4);
    printf("\n");
    postOrder(n4);
    printf("\n");
    levelOrder(n4);
    printf("\n");

    return 0;
}
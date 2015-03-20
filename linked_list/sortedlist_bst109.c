#include <stdio.h>
#include <stdlib.h>

struct ListNode{
  int val;
  struct ListNode *next;
};

struct TreeNode{
  int val;
  struct TreeNode *left;
  struct TreeNode *right;
};

int find_mid(int start, int end){

  int result = (end-start+1)/2;

  return start+result;
}

struct TreeNode* ary_mintree(struct TreeNode** root, int start, int end, int* ary_ptr){

  int mid = find_mid(start, end);
//  printf("MID=%d, start=%d, end=%d\n", mid, start, end);
  *root = (struct TreeNode*)malloc(sizeof(struct TreeNode));
  (*root)->val = *(ary_ptr+mid);
  (*root)->left = (*root)->right = NULL;

  if(mid-1 >= start){
    ary_mintree(&(*root)->left, start, mid-1, ary_ptr);
  }

  if(end >= mid+1){
    ary_mintree(&(*root)->right, mid+1, end, ary_ptr);
  }

  return *root;
}

void print_preorder(struct TreeNode* root){

  if(root){
    print_preorder(root->left);
    printf("Tree %d\n", root->val);
    print_preorder(root->right);
  }

}

int* tran_listary(struct ListNode *head, int len){

  int i = 0;
  struct ListNode* clone = head;
  int* ary = (int*)malloc(len*sizeof(int));
  while(clone != NULL){
    *(ary+i) = clone->val;
    i++;
    clone = clone->next;
  }

  return ary;
}

struct TreeNode* sortedListToBST(struct ListNode *head) {

  if(head == NULL) return NULL;

  int len = 0;
  struct ListNode* clone = head;
  while(clone != NULL){
    len++;
    clone = clone->next;
  }
  int* ary = tran_listary(head, len);

  struct TreeNode* tree = NULL;
  ary_mintree(&tree, 0, len-1, ary);

  free(ary);
  free(head);

  return tree;
}

void release(struct TreeNode* root){

  if(!root) return;
  release(root->left);
  release(root->right);
  free(root);

}

int main(){

    struct ListNode* head = (struct ListNode*)malloc(sizeof(struct ListNode));
    head->val = -1;
    head->next = NULL;
    struct ListNode* current = head;
    int i;
    for(i=0; i<12; i++){
      struct ListNode* node = (struct ListNode*)malloc(sizeof(struct ListNode));
      node->val = i;
      node->next = NULL;
      current->next = node;
      current = node;
    }

    struct TreeNode* tree = sortedListToBST(head);
    print_preorder(tree);
    release(tree);

    return 0;
}

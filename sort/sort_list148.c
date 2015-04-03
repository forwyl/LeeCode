#include <stdio.h>
#include <stdlib.h>
struct ListNode{
  int val;
  struct ListNode *next;
};

void divide(struct ListNode *head, struct ListNode **left, struct ListNode **right){

  struct ListNode *slow;
  struct ListNode *fast;

  if (head == NULL || head->next == NULL){
    *left = head;
    *right = NULL;
    return;
  }

  slow = fast = head;
  while(fast->next != NULL && fast->next->next != NULL){
    slow = slow->next;
    fast = fast->next->next;
  }
  *left = head;
  *right = slow->next;
  slow->next = NULL;

}

struct ListNode *merge(struct ListNode *left, struct ListNode *right){

  if(left == NULL){
    return right;
  }else if(right == NULL){
    return left;
  }

  struct ListNode *result = NULL;

  if(left->val <= right->val){
    result = left;
    result->next = merge(left->next, right);
  }else{
    result = right;
    result->next = merge(left, right->next);
  }

  return result;

}

struct ListNode *sortList(struct ListNode *head){

  if (head == NULL || head->next == NULL) return head;
  struct ListNode *left;
  struct ListNode *right;
  divide(head, &left, &right);

  return merge(sortList(left), sortList(right));

}

void print_list(struct ListNode *head){

  struct ListNode *current = head;
  while(current != NULL){
    printf("value:%d\n", current->val);
    current = current->next;
  }

}

void free_list(struct ListNode *head){

  struct ListNode *tmp;
  while (head != NULL){
    tmp = head;
    head = head->next;
    free(tmp);
  }

}

int main(){

  struct ListNode* head = (struct ListNode*)malloc(sizeof(struct ListNode));
  head->val = -1;
  head->next = NULL;
  struct ListNode* current = head;
  int i;
  for(i=0; i<5; i++){
    struct ListNode* node = (struct ListNode*)malloc(sizeof(struct ListNode));
    node->val = (rand()%10)+1;
    node->next = NULL;
    current->next = node;
    current = node;
  }
  printf("-----Before------\n");
  print_list(head);
  sortList(head);
  printf("-----After------\n");
  print_list(head);
  free_list(head);

  return 0;

}


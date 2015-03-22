#include <stdio.h>
#include <stdlib.h>

struct ListNode {
  int val;
  struct ListNode *next;
};

struct ListNode *partition(struct ListNode *head, int x) {

  if(head == NULL || head->next == NULL)
    return head;

  struct ListNode *previous = head;
  struct ListNode *current = previous->next;
  struct ListNode *bigger_head = NULL;
  struct ListNode *bigger_current = NULL;
  struct ListNode *smaller_head = NULL;
  struct ListNode *smaller_current = NULL;

  if(previous->val < x){
    smaller_head = previous;
    smaller_current = smaller_head;
  }else{
    bigger_head = previous;
    bigger_current = bigger_head;
  }

  while(1){
    if(current->val < x){
      if(smaller_head == NULL){
        smaller_head = current;
        smaller_current = smaller_head;
      }else{
        smaller_current->next = current;
        smaller_current = current;
      }
    }else{
      if(bigger_head == NULL){
        bigger_head = current;
        bigger_current = bigger_head;
      }else{
        bigger_current->next = current;
        bigger_current = current;
      }
    }

//    printf("current:%d \n", current->val);
    if(current->next != NULL){
      previous = current;
      current = current->next;
    }else{
      break;
    }
  };

  if(smaller_current != NULL)
    smaller_current->next = NULL;

  if(bigger_current != NULL)
    bigger_current->next = NULL;

  if(smaller_head == NULL){
    head = bigger_head;
  }else{
    smaller_current->next = bigger_head;
    head = smaller_head;
  }

  return head;
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
  head->val = 1;
  head->next = NULL;
  struct ListNode* current = head;
  int i;
  for(i=0; i<10; i++){
    struct ListNode* node = (struct ListNode*)malloc(sizeof(struct ListNode));
    node->val = (rand()%10)+1;
    node->next = NULL;
    current->next = node;
    current = node;
  }
  print_list(head);
  printf("----\n");
  head = partition(head, 4);
  print_list(head);
  free_list(head);

  return 0;
}

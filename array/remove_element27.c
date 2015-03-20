#include <stdio.h>
#include <stdlib.h>

int removeElement(int A[], int n, int elem) {

  if(n == 0) return 0;

  int i, counter;
  counter = 0;
  for(i=0; i<n; i++){
    if(A[i] == elem){
      ++counter;
    }else{
      A[i-counter] = A[i];
    }
  }

  for(i=0; i<n; i++){
    printf("index:%d, value:%d\n", i, A[i]);
  }

  return n - counter;

}

int main(){

    int A[] = {0,2,3,2,5};
    printf("length: %d\n", removeElement(A, 5, 2));

    return 0;

}

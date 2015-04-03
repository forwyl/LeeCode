#include <stdio.h>
#include <stdlib.h>

void sortColors(int A[], int n) {

  int count_ary[3] = {0, 0, 0};
  int i, k;
  for(i=0; i<n; i++){
    count_ary[A[i]]++;
  }

  for(i=0, k=0; i<n; ++k){
    while(count_ary[k]--)
      A[i++] = k;
  }

  for(i=0; i<n; i++){
    printf("value:%d\n", A[i]);
  }

}

int main(){

  int A[] = {2, 0, 0, 0, 0, 0, 1};
  sortColors(A, sizeof(A)/sizeof(int));

  return 0;

}

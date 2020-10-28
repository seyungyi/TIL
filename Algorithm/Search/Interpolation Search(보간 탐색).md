# Interpolation Search (보간 탐색)

- 개념 
  - 사전에서 단어를 찾는 것처럼 특정 단어가 있을 만한 부분으로 탐색 범위를 제한해 검색하는 방법. 따라서 저장된 데이터들이 미리 정렬된 형태 여야 함

- 과정
  1. 찾고자 하는 자료에서 첫 번째 위치를 left, 마지막 위치를 right로
  2. 중간값 위치 middle을 구한다.
     - middle = left + (right-left) * (key-a[left]) / (a[right]-a[left])
  3. 중간값 arry[middle]가 원하는 값과 같으면 검색을 종료
     - (array[middle]>원하는 값) left = middle+1
     - (array[middle]<원하는 값) right = middle-1
  4. left <= right이면 3. 과정 반복
- 구현(c)

```c
#include <stdio.h>
int inter_search(int a[], int n, int key){
    int left, right, middle;
    left = 0;
    right = n-1;
    while(left<=right){
        middle = left+(right-left)*(key-a[left]) / (a[right]-a[left]);
        if(key>a[middle]) left = middle+1;
        else if(key<a[middle]) right = middle-1;
        else return middle;
    } 
    return -1;
}
```


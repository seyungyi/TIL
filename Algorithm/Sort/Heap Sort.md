#  Heap Sort Algorithm

- 자료구조 '힙(Heap)'
  - 완전 이진 트리의 일종, 우선순위 큐를 위해 만들어진 자료구조
  - 최댓값, 최솟값을 쉽게 추출할 수 있는 자료구조
- 힙 정렬의 개념
  - 최대 힙 트리나 최소 힙 트리를 구성해 정렬하는 방법
  - 내림차순 정렬을 위해서는 최대 힙을, 오름차순 정렬을 위해서는 최소 힙을 구성하면 된다.
  - 과정 설명(내림차순)
    1. 정렬해야 할 n개의 요소들로 최대 힙을 만든다.
    2. 한 번에 하나씩 요소를 힙에서 꺼내서 배열의 위부터 저장한다.
    3. 삭제되는 요소들(최댓값 먼저)은 값이 감소되는 순서로 정렬된다.

- 최대 힙 정렬 구현(java, 내림차순)

  **최대 힙의 삽입**

  	1. 힙에 새로운 요소가 들어오면, 일단 새로운 노드를 힙의 마지막 노드에 이어서 삽입
   	2. 새로운 노드를 부모 노드들과 교환해서 힙의 성질을 만족

  ```java
  void insertMaxHeap(int x){
      maxHeap[++heapSize] = x;
      for(int i = heapsize; i>1; i/=2){
          if(maxHeap[i/2] < maxHeap[i])
              swap(i/2, i);
          else
              break;
      }
  }
  ```

  **최대 힙의 삭제**

  1. 최대 힙에서 최댓값은 ㄹ트노드이므로 루트 노드가 삭제
  2. 삭제된 루트 노드에는 힙의 마지막 노드를 대입
  3. 힙을 재구성

  ```java
  void deleteMaxHeap(){
      if(heapSize==0)
          return 0;
      int item = maxHeap[1];
       maxHeap[1] = maxHeap[heapSize];
      maxHeap[heapSize--] = 0;
      for(int i = 1; i*2<=heapSize;){
          if(maxHeap[i] > maxHeap[i*2] && maxHeap[i] > maxHeap[i*2+1]){
              break;
          }else if(maxHeap[i*2] > maxHeap[i*2+1]){
              swap(i, i*2);
              i = i*2;
          }else{
              swap(i, i*2+1);
              i = i*2+1;
          }
      }
      return item;
  }
  ```

  **힙 정렬**

  1. 1차원 배열로 쉽게 구현(부모가 i라면 왼쪽 자식은 2 * i, 오른쪽 자식은 2 * i+1이 인덱스)
  2. 정렬해야할 n개의 요소들을 1차원 배열에 기억한 후 최대 힙 삽입을 통해 차례대로 삽입
  3. 최대 힙으로 구성된 배열에서 최댓값부터 삭제

  ```java
  void heapSort()
  ```

  

<https://mygumi.tistory.com/310>

<https://gmlwjd9405.github.io/2018/05/10/algorithm-heap-sort.html>
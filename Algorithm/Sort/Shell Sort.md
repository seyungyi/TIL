# Shell Sort Algorithm

- 'Donald L. Shell'이 제안한 방법, 삽입 정렬을 보완한 알고리즘
- 삽입 정렬이 거의 정렬되어 있는 리스트에 대해 비교적 빠르다는 점에서 착안
  - 삽입 정렬은 한 번에 한 요소의 위치만 결정되기 때문에 비효율적

- 셸 정렬의 과정

  1. 먼저 정렬해야 할 리스트를 일정한 기준에 따라 분류
  2. 연속적이지 않은 여러 개의 부분 리스트를 생성(보통 부분리스트를 나누는 길이를 전체/2로 하지만 n/3+1이 더 빠르다고 알려져 있다)
  3. 각 부분 리스트를 삽입 정렬을 이용하여 정렬
  4. 모든 부분 리스트가 정렬되면 다시 전체 리스트를 더 적은 개수의 부분 리스트로 만든 후에 알고리즘을 반복
  5. 부분 리스트의 개수가 1이 될 때까지 위 과정을 반복

- 셸 정렬의 구현(java)

  - 정렬해야 할 리스트의 각 k번째 요소를 추출해서 부분 리스트를 만든다. 이때, k를 간격(interval)이라고 한다.
    - 간격의 초기값 : 정렬할 값의 수 / 2 or /3+1 ...
    - 생성된 부분 리스트의 개수는 interval과 같다.
  - 각 회전마다 간격 k를 줄인다. 즉, 하나의 부분 리스트에 속한 값들의 개수는 증가한다.
    - 간격은 홀수가 좋다.
  - 간격 k가 1이 될 때까지 반복한다.

  ```java
  void intervalSort(int arr[], int begin, int end, int interval){
      int data = 0;
      int j;
      for(int i = begin+interval; i<=end; i=i+interval){
          data=arr[i];
          for(j=i-interval; j>=begin&&data<arr[j];j-=interval)
              arr[j+interval]=arr[j];
          arr[j+interval] = data;    
      }
  }
  void shellSort(int[] arr, int size){
  	int interval;
      for(interval = size/3+1; interval>0; interval=interval/3+1){
          if((interval%2)==0)
              interval++;//홀수로
          for(int i = 0; i<interval;i++){
              intervalSort(arr, i, size-1, interval);
          }       
      }
  }
  ```

- 셸 정렬의 특징
  - 장점
    - 연속적이지 않은 부분 리스트에서 자료의 교환이 일어나면 더 큰 거리를 이동. 따라서 교환되는 요소들이 삽입 정렬보다는 최종 위치에 있을 가능성이 높아진다. -> 연산의 횟수를 줄이는 데 기여
    - 부분 리스트는 어느 정도 정렬이 된 상태이기 때문에 부분 리스트의 개수가 1이 되면 셸 정렬은 기본적으로 삽입 정렬을 수행하는 것이지만 삽입 정렬에 비해 속도가 점점 더 빠르게 수행
    - 알고리즘이 간단해 프로그램으로 쉽게 구현 가능
- 셸 정렬의 시간 복잡도
  - 최악 : O(n^2)
  - 최선 : O(nlog2n)
  - 평균 : O(n^1.5)
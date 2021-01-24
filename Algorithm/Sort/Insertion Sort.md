# Insertion Sort Algorithm

- 자료 배열의 모든 요소를 앞에서부터 차례대로 이미 정렬된 배열 부분과 비교하여 자신의 위치를 찾아 삽입함으로써 정렬
- 매 순서마다 해당 원소를 삽입할 수 있는 위치를 찾아 해당 위치에 넣는다.
- 삽입 정렬의 개념
  - 두번째 자료부터 그 앞(왼쪽)의 자료들과 비교하여 삽입할 위치를 지정한 후 자료를 뒤로 옮기고 지정한 자리에 자료를 삽입하여 정렬하는 알고리즘

- 삽입 정렬의 구현(java)

  ```java
  void insertionSort(int[] arr){
      int temp;
      int aux;
      for(int i = 1; i<arr.length;i++){
          temp = arr[i];
          aux = i-1;
          while(aux>=0)&&(arr[aux]>temp)){
              arr[aux+1] = arr[aux];
              aux--;
          }
          arr[aux+1] = temp;
      }
  }
  ```

- 시간 복잡도

  - O(n^2)

- 삽입 정렬의 특징

  - 장점 
    - 안정적인 정렬 방법
    - 레코드의 수가 적은 행렬이나 레코드가 대략 정렬되어 있는 행렬을 정렬할 경우에 삽입 정렬이 매우 효율적일 수 있다.
  - 단점
    - 비교적 많은 레코드들의 이동을 포함
    - 레코드 수가 많고 레코드 크기가 클 경우에 적합하지 않다.
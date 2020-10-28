# Counting Sort Algorithm

- 계수 정렬 : 숫자가 등장한 횟수를 세서 그 기준으로 정렬하는 방법

- 구현

  - 정렬되지 않은 배열을 A, 각 등장 횟수를 센 배열을 B, 정렬된 배열을 C

  1. A의 숫자들을 세서 B를 초기화시킨다.
  2. B의 값들을 누적해서 합한 후 누적합 배열로 만든다.
  3. A를 뒤에서부터 보는데 A의 값을 인덱스로 하는 누적합 배열 B를 본다.
  4. B의 값을 index로 하는 배열 C에 A의 값을 삽입
  5. B의 값을 -1한다.

  ```c++
  #include <iostream>
  int main(void){
      int arr[size]={};
      //횟수 배열을 만든다.
      //최댓값이 max라면 크기 max+1의 배열 생성
      int count[max+1];
      for(int i=0; i<max+1; i++)
          count[i] = 0;
      for(int i=0; i<size; i++)
          count[arr[i]]++;
      //횟수배열을 누적한 배열로 만든다.
      for(int i=1; i<max+1; i++)
          count[i] += count[i-1];
      //누적합을 기준으로 정렬
      //최소 1번 이상 나오기 때문에 정렬배열의 인덱스는 1부터
      //따라서 정렬 배열는 size+1
      int sort[size+1], index;
      for(int i=0; i<size+1; i++)
          sort[i] = 0;
      for(int i=0; i<size; i++){
          index = count[arr[i]];
          sort[index] = arr[i];
          count[arr[i]]--;
      }
  }
  ```

- 시간복잡도
  - 최상 : O(n+k) k는 데이터 중 max값
  - 최악 : k의 시간 복잡도에 따라 O(n^2) or O(n^3)
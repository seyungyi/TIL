# Radix Sort Algorithm

- 정의	

  - 기수(Radix) : 주어진 데이터를 구성하는 기본 요소
  - LSD(Least Significant Digit) 방식의 정렬
    - 가장 작은 자릿수부터 정렬을 진행
    - 가장 큰 자릿수깢 비교해야 된다는 단점
    - 코드 구현이 MSD에 비해 간결
  - MSD(Most Significant Digit) 방식의 정렬
    - 가장 큰 자릿수부터 정렬을 진행
    - 코드 구현은 LSD에 비해 추가작업(정렬상태확인)이 필요
    - 중간에 정렬이 완료될 수 있다는 장점

- 특징

  - 정렬 순서 순서상 앞서고 뒤섬의 판단을 위한 비교연산을 안함
  - 정렬 대상의 모든 길이가 동일해야 가장 효율적
    - 다를 경우 빈 공간을 메꿔야 하는 추가 작업 발생 -> 성능저하
  - 정렬 대상의 자리수를 기준으로 '버킷'이라는 공간에 큐를 이용

  - 정렬 대상 숫자들의 위치가 뒤바뀌지 않는 stable sort 알고리즘을 적용해야 한다.

  - 시간 복잡도 : O(dn) (d는 가장 큰 데이터의 자리수)

  - 장점 : 비교연산을 하지 않고 시간 복잡도도 낮아 정수와 같은 자료의 정렬 속도가 매우 빠르다.
  - 단점 : 데이터 전체 크기에 기수 테이블의 크기만한 메모리가 더 필요

- 구현

  - c언어

  ```c
  /*p : data의 최대 자리수
   *k : 몇 진법인지 */
  void rxSort(int *data int size, int p, int k){
      int *counts, *temp;
      int index, pval, i, j, n;
      if((counts = (int*)malloc(k*sizeof(int)))==NULL)
          return;
      if((temp = (int*)malloc(size*sizeof(int)))==NULL)
          return;
      for(n=0; n<p; n++){
          for(i=0;i<k;i++)
              counts[i] = 0;
          pval = (int)pow((double)k, (double)n);
          for(j=0; j<size; j++){
              index = (int)(data[j]/pval) % k;
              counts[index] = counts[index] + 1;
          }
          //계수 정렬을 위해 카운트 누적합을 구한다. 
          for(i=1; i<k; i++)
              counts[i] = counts[i]+counts[i-1];
          //카운트를 사용해 각 항목의 위치를 결정
          //계수정렬 방식
          for(j=size-1; j>=0; j--){
              index = (int)(data[j]/pval) % k;
              temp[counts[index]-1] = data[j];
              counts[index] = counts[index]-1;
          }
          memcpy(data, temp size*sizeof(int));
      }
      free(counts);
      free(temp);
  }
  ```

  - c++

  ```c++
  #include <iostream>
  #include <queue>
  
  void rxSort(int* arr, int size){
      std::queue<int> radix[10];
      int max = arr[0];
      int p = 1;
      
      for(int i=1; i<size; i++)
          if(max<arr[i]) max=arr[i];
      while(max/10){
          p*=10;
          max/=10;
      }
      int mod=10;
      int pMin = 1;
      while(pMin<=p){
          for(int i=0; i<size; i++)
              radix[(arr[i]%mod)/pMin].push(arr[i]);
          for(int i=0,j=0;i<10;){
              if(radix[i].size()){
                  arr[j++] = radix[i].front();
                  radix[i].pop();
              }else
                  i++;
          }
          pMin*=10;
          mod*=10;
      }  
  }
  
  ```

  
























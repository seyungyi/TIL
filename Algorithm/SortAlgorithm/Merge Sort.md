# Merge Sort Algorithm

- 1945년 '존 폰 노이만'이 제안한 방법

  일반적으로 이 정렬은 안정 정렬에 속하며, 분할 정복 알고리즘의 하나이다.

   - 분할 정복 방법
     	- 문제를 작은 문제로 분리하고 각각을 해결한 다음, 결과를 모아서 원래의 문제를 해결하는 방법.
     - 대개 순환 호출을 이용하여 구현

- 합병 정렬 알고리즘의 개념

  - 하나의 리스트를 두 개의 균등한 크기로 분할하고 부분 리스트를 정렬한 다음, 두 개의 정렬된 부분 리스트를 합하여 전체가 정렬된 리스트가 되게 하는 방법
  - 합병 정렬의 단계
    - 분할(divide) : 입력 배열을 같은 크기의 2개의 부분 배열로 분할
    - 정복(conquer) : 부분 배열을 정렬한다. 부분 배열의 크기가 충분히 작지 않으면 순환 호출을 이용하여 다시 분할 정복 방법을 적용
    - 결합(combine) : 정렬된 부분 배열들을 하나의 배열에 합병

- 합병 정렬의 구현(java, 내림차순)

  - 리스트의 길이가 0 또는 1이면 이미 정렬된 것으로 본다. 그렇지 않은 경우에는 
  - 정렬되지 않은 리스트를 절반으로 잘라 비슷한 크기의 두 부분 리스트로 나눈다.
  - 각 부분 리스트를 재귀적으로 합병 정렬을 이용해 정렬한다. -> mergerSort() 
  - 두 부분 리스트를 다시 하나의 정렬된 리스트로 합병한다. -> mergerTwoArea()

```java
	public static void mergeSort(String[] arr, int left, int right) {
		if(left< right) {
			int mid = (left+right)/2;
			mergeSort(arr, left, mid);
			mergeSort(arr, mid+1, right);
			
			mergeTwoArea(arr, left, mid, right);
		}
	}
	public static void mergeTwoArea(String[] arr, int left, int mid, int right) {
		int idxL = left;
		int idxR = mid+1;
		String temp[] = new String[arr.length];
		int idx = left;
		
		while(idxL<=mid&&idxR<=right) {
			if(arr[idxL]<=arr[idxR]) {
				temp[idx++] = arr[idxL++];
			}else {
				temp[idx++] = arr[idxR++];
			}
		}
		if(idxL>mid)
			for(;idxR<=right; idx++, idxR++)
				temp[idx] = arr[idxR];
		else
			for(;idxL<=mid;idx++, idxL++)
				temp[idx] = arr[idxL];
		
		for(int i = left; i<=right; i++)
			arr[i] = temp[i];
	}
```

- 합병 정렬 알고리즘의 특징

  - 단점

    - 레코드를 배열로 구성하면, 임시 배열이 필요
    - 이 경우 레코드들의 크기가 큰 경우 이동횟수가 많아지므로 시간적 낭비가 크다.

  - 장점 

    - 안정적인 정렬 방법 : 데이터의 분포에 영향을 덜 받는다. 정렬되는 시간이 O(nlog2 n)으로 동일
    - 만일 LinkedList로 구현한다면, 링크 인덱스만 변경되므로 데이터의 이동은 무시할 수 있을 정도로 작아진다. -> 제자리 정렬(in-place sorting)로 구현 가능
    - 만약 큰 크기의 레코드를 정렬할 경우에 Linked List를 사용한다면, 다른 어떤 정렬 방법보다 효율적

    
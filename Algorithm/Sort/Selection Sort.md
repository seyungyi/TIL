# Selection Sort Algorithm

- 제자리 정렬 알고리즘의 하나
  - 입력 배열 외에 다른 추가 메모리를 요구하지 않는다.
- 해당 순서에 원소를 넣을 위치는 이미 정해져 있고, 어떤 원소를 넣을지 선택하는 알고리즘
- 선택 정렬의 개념
  - n번째 자료를 n+1번째 자료부터 마지막 자료까지 차례대로 비교하여 가장 작은 값을 찾아 n번째에 놓는 과정을 반복하여 정렬을 수행 

- 선택 정렬 구현(java, 오름차순)
  1. 주어진 배열 중에서 최솟값을 찾는다.
  2. 그 값을 맨 앞에 위치한 값과 교체한다.
  3. 맨 처음 위치를 뺀 나머지 리스트를 같은 방법으로 교체한다.
  4. 하나의 원소만 남을 때 까지 위의 과정을 반복한다.

```java
public int[] sort(int[] data){
    int minIdx, temp;
    for(int i= 0;i < data.length-1;i++){
        minIdx = i;
        for(int j = i+1; j<data.length;j++){
			if(data[j]<data[minIdx])
                minIdx = j;
        }
        temp = data[minIdx];
        data[minIdx] = data[i];
        data[i] = temp;
    }
    return data;
    
}
```

- 선택 정렬의 특징

  - 장점 : 자료 이동 횟수가 미리 결정된다.

  - 단점

    - 안정성을 만족하지 않는다.

      즉, 값이 같은 레코드가 있는 경우에 상대적인 위치가 변경될 수 있다.

  - 시간 복잡도

    - O(n^2)
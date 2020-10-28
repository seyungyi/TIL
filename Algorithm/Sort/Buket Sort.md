# Buket Sort Algorithm

- 수많은 버킷에 배열 요소들을 분산시킴으로써 동작하는 정렬 알고리즘

  - 각 버킷은 그 뒤로 개별 정렬되는데, 이는 다른 정렬 알고리즘이나 버킷 정렬 알고리즘을 수행

- 수행

  1. 비어있는 버킷들(데이터들의 개수와 동일한 개수)의 배열을 배치
  2. 분산 : 원래의 배열을 살펴보고 각 객체를 버킷에 담는다.
  3. 비어있지 않은 각 버킷을 정렬
  4. 수집 : 순서대로 버킷을 방문하여 모든 요소를 원래의 배열에 위치시켜 놓는다.

- 구현(python)

  ```python
  def buket_sort(seq):
  	#make buckets
      buckets = [[]for _ in range(len(seq))]
      #assign values
      for value int seq:
          bucket_index = value * len(seq) // (max(seq)+1)
          buckets[buckets_index].append(value)
      sorted_list = []
      for bucket in buckets:
          sorted_list.extend(quick_sort(bucket))
      return sorted_list
  
  def quick_sort(ARRAY):
      ARRAY_LENGTH = len(ARRAY)
      if(ARRAY_LENGTH<=1):
          return ARRAY
      else:
          PIVOT = ARRAY[0]
          GREATER = [element for element in ARRAY[1:] if element > PIVOT]
          LESSER = [element for element in ARRAY[1:] if element <= PIVOT]
          return quick_sort(LESSER) + [PIVOT] + quick_sort(GREATER)
  ```

- 시간 복잡도

  - comparison sort의 계산 복잡성은 최소 O(n log n)이다. 버킷 정렬은 부석 대상 데이터의 분포 특성을 활용해 계산 복잡성을 O(n) 수준으로 개선시키려는 것을 목적으로 한다.
# Heap

### 힙(heap)이란?

- 완전 이진 트리의 일종, 우선순위 큐를 위하여 만들어진 자료구조
- 여러개의 값들 중에서 최댓값이나 최솟값을 빠르게 찾아내도록 만들어진 자료구조 
- 일종의 반정렬 상태(느슨한 정렬 상태)를 유지
  - 부모 노드 의 키 값이 자식 노드의 값보다 항상 큰/작은 이진 트리
- 중복된 값을 허용

### heap의 종류

- 최대 힙(max heap)
  - 부모 노드의 키 값이 자식 노드의 키 값보다 크거나 같은 완전 이진 트리
  - key(부모 노드) >= key(자식 노드)
- 최소 힙(min heap)
  - 부모 노드의 키 값이 자식 노드의 키 값보다 작거나 같은 완전 이진 트리
  - key(부모 노드) <= key(자식 노드)

### heap의 구현

- 힙을 저장하는 표준적인 자료구조는 배열이다.
- 구현을 쉽게 하기 위해 배열의 첫번째 인덱스인 0은 사용하지 않는다.
- 특정 위치의 노드 번호는 새로운 노드가 추가되어도 변하지 않는다.
- 힙에서의 부모 노드와 자식 노드의 관계
  - 왼쪽 자식의 인덱스 = (부모의 인덱스) * 2
  - 오른쪽 자식의 인덱스 = (부모의 인덱스) * 2 + 1
  - 부모의 인덱스 = (자식의 인덱스) / 2

```c
#define MAX_ELEMENT 200

typedef struct{
    int key;
}element;

typedef struct{
    element heap[MAX_ELEMENT];
    int heapSize;
}HeapType;
```

### heap의 삽입

1. 힙에 새로운 요소가 들어오면, 새로운 노드를 힙의 마지막 노드에 이어서 삽입

2. 새로운 노드를 부모 노드들과 교환해서 힙의 성질을 만족시킨다

- c언어

```c
void insertMaxHeap(HeapType *h, element item){
    int i;
    i = ++(h->heapSize);
    while((i!=1)&&(item.key > h->heap[i/2].key)){
        h->heap[i] = h->heap[i/2];
        i /= 2;
    }
    h->heap[i] = item;
}
```

- java

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

### heap의 삭제

1. 최대 힙에서 삭제연산은 최댓값을 가진 요소를 삭제라는 것이고,  최댓값은 루트노드이므로 루트노드가 삭제된다
2. 삭제된 루트 노드에는 힙의 마지막 노드를 가져온다.
3. 힙을 재구성한다.

- c언어

```c
element deleteMaxHeap(HeapType *h){
    int parent, child;
    element item, temp;
    
    item = h->heap[1];
    temp = h->heap[(h->heapSize)--];
    parent = 1;
    child = 2;
    
    while(child <= h->heapSize){
        if((child < h->heapSize) && ((h->heap[child].key) < h->heap[child+1].key)){
            child++;
        }
        if(temp.key >= h->heap[child].key){
            break;
        }
        h->heap[parent] = h->heap[child];
        parent = child;
        child *= 2;
    }
    h->heap[parent] = temp;
    return item;
}
```

- java

```java
int deleteMaxHeap(){
    if(heapSize == 0)
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

### heap sort 알고리즘의 개념 요약

- 최대 힙 트리나 최소 힙 트리를 구성해 정렬을 하는 방버
- 내림차순 정렬 위해서는 최대힙을, 오름차순 정렬을 위해서는 최소힙을 구성
- 과정
  1. 정렬해야할 n개의 요소들로 최대 힙(완전 이진 트리 형태)을 생성(내림차순)
  2. 한 번에 하나씩 요소를 힙에서 꺼내서 배열의 뒤부터 저장
  3. 삭제되는 요소들(최댓값부터)은 값이 감소되는 순서로 정렬

**내림차순 정렬을 위한 최대 힙의 구현**

- 힙은 1차원 배열로 구현
- 정렬해야 할 n개의 요소들을 1차원 배열에 기억, 최대 힙 삽입을 통해 차례대로 삽입
- 최대 힙으로 구성된 배열에서 최댓값부터 삭제

**힙 정렬 알고리즘의 예제 및 c언어 코드**

- 배열의 자료를 내림차순으로 정렬하는 코드

```c
void heapSort(element a[], int n){
    int i;
    HeapType h;
    init(&h);
    for(i=0; i<n;i++)
        insertMaxHeap(&h, a[i]);
    for(i=(n-1);i>=0;i--)
        a[i] = deleteMaxHeap(&h);
}
```

**힙 정렬 알고리즘의 특징** 

- 장점
  - 시간 복잡도가 좋은 편
  - 힙 정렬이 가장 유용한 경우는 전체 자료를 정렬하는 것이 아니라 가장 큰 값 몇개만 필요할 때이다.

**힙 정렬의 시간 복잡도**

- 힙 트리의 전체 높이가 거의 log2(n)이므로 하나의 요소를 힙에 삭입/삭제할 때 힙을 재정비하는 시간이 log2(n)만큼 소요
- 요소의 개수가 n개이므로 전체적으로 O(nlog2(n))의 시간이 걸린다.
- T(n) = O(nlog2(n));
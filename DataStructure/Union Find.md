# Union Find

[개요]

- 상호배타적으로 이루어진 집합을 효율적으로 표현하기 위해 만들어진 자료구조
- 서로 다른 두 개의 집합을 병합하는 Union 연산과 집합의 원소가 어떤 집합에 속해있는지 판단하는 Find 연산을 지원하기 때문에 Union-Find라 이름 붙음
- 1964년 처음 고안, Kruskal 알고리즘에서 원소 간의 연결 여부를 판단하는 데 사용

[설명]

- n은 모든 원소의 개수
- 원시적 형태
  - ArrayList에 상호 배타적 집합을 표현하기 위한 가장 간단한 방법
    - 배열의 각 요소에 집합의 고유 번호를 넣는것
    - 배열의 원소에 접근하는 것만으로 속한 집합을 알 수 있게 되므로 Find 연산은 항상 O(1)의 시간 복잡도 -> 효율적
    - union연산을 수행하기 위해 ArrayList의 모든 원소를 순회하며 각 원소가 속한 집합의 고유 번호를 바꿔 주어야 하므로 항상 O(n)의 시간 복잡도

※ Didjoint Set

 - 서로 중복되지 않는 부분 집합들로 나눠진 원소들에 대한 정보를 저장하고 조작하는 자료구조
   	- 공통 원소가 없는(상호 배타적인) 부분 집합들로 나눠진 원소들에 대한 자료구조
   	- 서로소 집합 자료구조
- 각 집합을 표현하기 위해 연결 리스트를 사용 각 리스트의 헤드 부분에는 해당 집합의 대표 원소를 저장
- 서로소 집합 숲(Disjoint-set forest)
  - 각 집합이 트리로 표현되는 자료구조, 각 노드들은 부모 노드를 참조

- 기본적 형태
  - Disjoint Set(서로소 집합)에서는 트리를 특이한 용도로 사용, 트리의 구조 자체가 의미를 가지는 경우가 많은 반면 Disjoint Set에서는 트리의 구조와는 상관 없이 단 하나의 최상위 노드에만 관심을 가진다.
  - 이 최상위 노드는 각 집합을 대표하는 대표자 역할
  - Disjoint set를 트리로 표현하기 위해서는 먼저 ArrayList의 각 원소에 자신의 인덱스 값이 들어가 있는 초기 상태가 필요. 이 상태에서 각 원소에 들어가 있는 값은 각 원소의 부모를 의미
  - Find 연산
    - 재귀적으로 트리를 거슬러 올라가 최상위 노드의 값을 반환
    - 트리 형태의 Disjoint set에서 최상위 노드는 각 집합과 1대1 대응되므로, Find 연산을 통해 각 집합을 알 수 있다.
    - 상수 시간에 가까운 정도의 시간이 소요
    - 최적화
      - 수행할 때마다 매번 트리를 거슬러 올라가는 낭비
      - 보완 : Find연산에서 방문하는 각 노드마다 결과값을 반환하기 전에 ArrayList의 해당 원소의 값을 결과값으로 저장 -> 경로 압축 효과
  - Union 연산
    - Find 연산을 수행한 후 두 개의 최상위 노드의 부모를 다른 하나의 최상위 노드로 바꾸어 트리를 병합
    - 시간에 영향을 미치는 것은 Find연산 뿐이므로, 시간 복잡도는 Find 연산과 동일
    - 최적화
      - 최악의 경우에 트리를 편중시킬 수 있다는 문제
      - 해결 : ArrayList를 하나 더 만들어서 트리의 대략적인 깊이를 저장(rank). Union 연산을 수행할 때는 rank가 큰 트리에 rank가 작은 트리를 합치도록 변경 -> 트리의 깊이 감소

[연산]

- make-set(x)
  - 초기화, x를 유일한 원소로 하는 새로운 집합을 생성
- union(x, y)
  - 합하기, x와 y가 속한 두 집합을 합치는 연산
- find(x)
  - 찾기, x가 어떤 집합에 속해 있는지 찾는 연산
- 배열 vs. 트리
  1. 배열
     - Array[i] : i번 원소가 속하는 집합의 번호(루트 노드의 번호)
     - make-set(x)
       - Array[i] = i 와 같이 각자 다른 집합 번호로 초기화
     - union(x, y)
       - 배열의 모든 원소를 순회, y의 집합 번호를 x의 집합 번호로 변경(O(N))
     - find(x)
       - 한 번만에 x가 속한 집합 번호를 찾는다.(O(1))
  2. 트리
     - 같은 집합 = 하나의 트리, 집합 번호 = 루트 노드
     - make-set(x)
       - 각 노드는 모두 루트 노드, N개의 루트 노드 생성 및 자기 자신으로 초기화
     - union(x, y)
       - z, y의 루트 노드를 찾고 다르면 y를 x의 자손으로 넣어 두 트리를 합
       - O(N)보다 작으므로 find연산이 전체 수행 시간을 지배
     - find(x)
       - 노드의 집합 번호는 루트 노드이므로 루트노드를 확인하여 같은 집합인지 확인
       - 트리의 높이와 시간 복잡도가 동일 (최악은 O(N-1))

[예시]

전체 집합이 있을 때 구성 원소들이 겹치지 않도록 분할하는 데 자주 사용

- Kruskal MST 알고리즘에서 새로 추가할 간선의 양끝 정점이 같은 집합에 속해 있는지(사이클 형성 여부 확인)에 대해 검사하는 경우
- 백준 1717, 4195

 ※ 참고 : 분할(Parition)

- 임의의 집합을 분할한다는 것은 각 부분 집합이 아래의 두 가지 조건을 만족하는 Disjoint Set이 되도록 쪼개는 것
  1. 분할된 부분 집합을 합치면 원래의 전체 집합
  2. 분할된 부분 집합끼리는 겹치는 원소가 없다.

- 구현

  - 유사코드

  ```javascript
  ArrayList list = []
  Function additem():
  	list.append([list.length, 0])
  
  Function find(index):
  	if list[index][0] == index:
      	return index
  	else:
      	return find(list[index][0])
  
  Function union(a, b):
  	roota = self.find(a)
  	rootb = self.find(b)
  	list[roota][0] = list[rootb][0]
  	
  ```

  - 최적화 구현(java)

    최악의 상황 (일렬인 트리)

    - 트리 구조가 완전 비대칭
    - 연결 리스트 형태
    - 트리의 높이가 최대
    - 원소의 개수가 N일 때, 트리의 높이가 N-1이므로 union과 find(x)의 시간 복잡도가 모두 O(N)
    - 배열로 구현하는 것보다 비효율적

    find 연산 최적화

    - 경로 압축(Path Compression)
    - 시간 복잡도: O(log N)

    ```java
    int root[MAX_SIZE];
    for(int i = 0; i<MAX_SIZE;i++)
        root[i] = i;
    int find(int x){
        if(root[x] == x)
            return x;
        else{
            //find 하면서 만난 모든 값의 부모 노드를 root로 만든다.
            return root[x] = find(root[x]);
        }
    }
    ```

    union 연산 최적화

    - union-by-rank(height)
    - rank에 트리의 높이를 저장
    - 항상 높이가 더 낮은 트리를 높은 트리 밑에 삽입

    ```java
    int root[MAX_SIZE];
    int rank[MAX_SIZE];
    for(int i = 0; i<MAX_SIZE;i++){
        root[i] = i;
        rank[i] = 0;
    }
    int find(int x){//위와 동일
    }
    
    void union(int x, int y){
        x = find(x);
        y = find(y);
        
        if(x == y)
            return;
       
        //union-by-rank
        if(rank[x] < rank[y]){
            root[x] = y;
        }else {
            root[y] = x;
            if(rank[x] == rank[y])
                rank[x]++;//만약 같다면 합친 후 (x의 높이 + 1)
        } 
    }
    ```

    

  


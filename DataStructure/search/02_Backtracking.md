#  Backtracking

- 퇴각검색(Backtracking) : 1950년대의 미국 수학자 D. H. 레머가 지은 용어

  - DFS 기법에 Pruning 기법을 적용해 Promising 검토와 Back Tracking 을 활용해 탐색 성능을 개선한 알고리즘
  - 한정 조건을 가진 문제를 풀려는 전략
  - Pruning 기법 : 유망하지 않은 노드를 포함한 경로를 더이상 고려하지 않도록 가지치기 표시를 하는 기법
    - 유망성 : 조건을 만족하는가 아닌가 
  - 중요한 것은 "배제"
  - 주로 Stack을 사용하며 Stack에 값을 넣기 전에 유망성을 검사

- 순서

  1. 깊이 우선 탐색을 수행, 상태 공간 트리를 활용하여 Pre Order 방식으로 해를 찾는다.
  2. 방문한 Node를 포함하여 Promising(유망성)을 판단
  3. 유망하면 방문한 Node의 서브트리로 이동 1번을 반복
  4. 유망하지 않으면 반문한 Node에 Pruning 후 상위 Node로 백트래킹 후 1번 반복

  

문제 

- n-queen problem
- 백준 6603


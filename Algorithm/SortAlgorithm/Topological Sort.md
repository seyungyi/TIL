# Topological Sort Algorithm

- 그래프 정렬로 정점들을 변의 방향을 거스르지 않도록 나열하는 것. 그렇기에 위상정렬이 가능하려면 DAG(Directed Acyclic Graph, 방향성이 있으며 사이클이 없는 그래프)여야 한다.

  - DFS를 사용하여 구현하거나 indegree배열을 사용하여 구현 가능

  - 하나의 방향 그래프에는 여러 위상 정렬이 가능
  - 정렬 과정에서 선택되는 정점의 순서를 위상 순서(Topological Order)라고 한다.
  - 정렬 과정에서 그래프에 진입 차수가 0인 정점이 없다면, 알고리즘은 중단되고 이러한 그래프로 표현된 문제는 실행이 불가능

- 기본적인 방법

  1. 집입 차수가 0인 정점(즉, 들어오는 간선의 수 가 0)을 선택
     - 집입 차수가 0인 정점이 여러 개 존재할 경우 어느 정점을 선택해도 무방
     - 초기에 간선의 수가 0인 모든 정점을 큐에 삽입
  2. 선택된 정점과 여기에 부속된 모든 간선을 삭제
     - 선택된 정점을 큐에서 삭제
     - 선택된 정점에 부속된 모든 간선에 대해 간선의 수를 감소
  3. 위의 과정을 반복해서 모든 정점이 선택, 삭제되면 알고리즘 종료

- 구현(java/백준 2252번과 관렬)

  ```java
  static int N;//그래프 정점의 수
  static int M;//간선의 수
  //매개변수:가중치가 없는 그래프, 인접 리스트
  static void topologicalSort(ArrayList<ArrayList<Integer>> graph, int[] cntOfLink){
      Queue<Integer queue = new LinkedList();
      //1번
      for(int i=1; i<N; i++){
          if(cntOfLink[i] == 0)
              queue.add(i);
      }
      //2번 반복
      for(int i=0; i<N; i++){
          int v = queue.remove();//정점 2-1
          System.out.println(v + " "); 
          for(int nextV:graph.get(v)){
              cntOfLink[nextV]--; //2-2
              if(cntOfLink[nextV]==0) // 1-2
                  queue.add(nextV);
          }
      }
  }
  ```

- 관련 문제

  - 백준 2252, 1766, 2056, 1516
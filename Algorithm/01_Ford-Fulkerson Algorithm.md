# Ford-Fulkerson Algorithm

**네트워크 플로우(Network flow)**

- 그래프의 경로의 길이가 아닌 , '용량'의 관점에서 바라보는 시점.

- 용어
  - Source : 네트워크의 시작(A) / Sink : 네트워크의 도착지(E)
  - c(a,b) : 정점 a에서 b로 가는 용량, 항상 0 이상
  - f(a,b) : a에서 b로 흐르는 유량. 실수치 함수
  - c(a,b)-f(a,b) = r(a,b) : a에서 b로 보낼 수 있는 잔여 용량
  
- 특성
  - 용량의 제한(capacity constraint) : f(a,b) <= c(a,b)
  - 유량의 대칭(skew symmetry) : f(a,b) = -f(a,b)
  - 유량의 보존(flow conservation) : f(a,b)들의 합 = 0 => 각 정점에 들어오고 나가는 유량의 합은 같다
  
- cancellation : 그래프에 표시된 유량들을 양의 순 유량(positive net flow)로 표기하는 과정

- residual network : u에서 v로의 residual capacity는 다음과 같다.
  $$
  \mathbf{c}_f(u,v) = c(u,v) - f(u,v)
  $$
  어떤 유량 그래프G가 주어졌을 때 G의 *residual network* G<sub>f</sub> 의 엣지는 cancellation과정을 거쳐 도출된 양의 순 유량을 바탕으로 계산된다.

- augmenting path(증가 경로) : residual network G<sub>f</sub>상에서 s에서 t로 가는 경로

**포드 풀커슨 알고리즘**

- 최초의 네트워크 유량 알고리즘, 개념과 구현이 간단

- 네트워크의 모든 간선의 유량을 0으로 시작, Source에서 Sink로 보낼 수 있는 경로로 유량을 보내기를 반복

- 중요점 : 유량의 상쇄

  - ex) 최대 유량을 찾는 경우, A-B-D로 유량을 보냈는데, 알고 보니 A-B-C-D가 더 최대 유량이였다. 잔여 용량이 없기 때문에 더 이상 보낼 수 없고, 최대값을 찾는 것에 실패

  - 위와 같은 문제점을 없애기 위해 유량을 보낼 때 Back-Edge를 만들어 줘야 한다.

    - B->A의 용량 => c(B,A) = 0, 즉 B에서 A로 보낼 수 없는 상황
    - A->B로 유량을 1 보냈다고 하자. => f(A,B) = 1 = -f(B,A)
    - 잔여용량 = r(B,A) = c(B,A) - f(B,A) = 0 - (-1) = 1, 즉 하나를 보낼 수 있다.

    =>즉, 유량 하나를 보내는 것은 역으로 유량을 하나 보낼 수 있게 해주는 작업과 같다는 말

  - 결과적으로 모든 네트워크를 모델링을 한 후에 BackEdge를 흘러가는 유량 만큼 만들어 준다. DFS, BFS를 가능할 때까지 반복
  
- 개념

  - residual network를 활용해 최대 유량을 구하는 기법이다.
  - residual network G<sub>f</sub>가 주어졌다고 보자
  - 다음 Gf에서 DFS나 BFS 방식으로 s에서 t로 가는 경로(증가 경로)를 하나 찾는다.
  - 찾은 경로의 반대 방향으로 최대 유량만큼을 흘려 보내는 엣지를 만든다.(augmenting path+cancellation)
  - s에서 t로 가는 경로가 존재하지 않을 때까지 위 두 단계를 반복한다.
  - 의사 코드

  > for each edge (u,v) ∈ E[G]
  > 	do f[u, v] ​<-​ 0
  >          f[v, u] <-​ 0
  >  while thoro exists a path p from s to t in the residual network G<sub>f</sub>
  >
  > ​    do c<sub>f</sub>(p) ​<-​ min{ c<sub>f</sub>(u,v) : (u,v) is in p}
  >
  > ​        for each edge (u,v) in p
  >
  > ​            do f[u, v] ​<- ​ f[u, v] + c<sub>f</sub>(p)
  >
  > ​                 f[v, u]  <- -f[u, v]

- 이 알고리즘에서 증가 경로를 찾는 방법은 기본적으로 DFS이다. DFS의 시간 복잡도는 O(V+E)이다. 문제의 답이 f이고 모든 용량 단위가 정수라고 할 때 한 번 경로를 찾았을 때 유량이 최소 1씩은 보내지므로, 증가 경로를 찾는  루프는 최대 f번 실행된다.

  따라서 포드 풀커슨 알고리즘의 시간 복잡도는 최악의 경우 O((V+E)f)인데, 보통 V보다 E가 크므로 O(Ef)라 축약한다.

  이 시간 복잡도를 개선한 알고리즘 에드몬드 카프 알고리즘으로 증가경로를 BFS를 사용해서 찾는 알고리즘이다. 이 알고리즘의 시간복잡도는 최대 O(VE^2)이다.

**최소컷 최대 유량 정리(Min-cut Max-flow Theorem)**

- 컷(cut) 

  -  Source와 Sink가 다른 집합에 속하도록 그래프의 정점들을 두 개의 집합으로 나눈 것. 

  - Source가 속한 집합은 S, Sink가 속한 집합을 T라고 두고, S->T로 보내는 총 유량(value of flow)을 컷 S,T의 유량이라고 정의

  - 속성

    - 컷의 유량은 Source->Sink의 유량과 같다

    - 컷의 유량 <= 컷의 용량 

      -> 네트워크에서 용량이 가장 작은 컷을 찾아내는 문제를 최소 컷(min cut) 문제라 함

      -> 최소 컷 : 용량과 유량이 같은 컷을 찾는다.

- 즉, 최소컷을 찾기 위해서는 최대 유량을 찾으면 된다.

**구현**

잔여 용량이 없을 때까지, 즉 보낼 수 있는 유량이 없을 때까지 BFS 또는 DFS 반복

[관련 백준문제](https://blog.naver.com/PostView.nhn?blogId=kks227&logNo=220804885235)
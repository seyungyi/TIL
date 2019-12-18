# Graph Search

- 하나의 정점으로부터 시작하여 차례대로 모든 정점들을 한 번씩 방문하는 것

1. 깊이 우선 탐색(DFS, Depth-First Search)

   - 어떤 한 노드에서 시작해서 다음 분기(branch)로 너어가기 전에 해당 분기를 완벽하게 탐색하는 방법
     - 즉, 넓게(wide) 탐색하기 전에 깊게(deep) 탐색하는 것
     - 모든 노드를 방문하고자 하는 경우에 이 방법을 선택
     - BFS보다 조금 더 간단, 속도 자체는 느리다.
   - 특징
     - 순환 알고리즘의 형태
     - 전위 순회(Pre-Order Traversals)를 포함한 다른 형태의 트리 순회는 모두 DFS의 한 종류이다
     - 이 방법을 사용해서 그래프를 탐색할 경우, 어떤 노드를 방문했었는지 여부를 반드시 검사해야 한다.(검사하지 않으면 무한루프의 가능성 )

   - 과정

     1. a노드(시작 노드)를 방문, 방문한 노드는 방문했다고 표시

     2. a와 인접한 노드들을 차례로 순회, 없으면 종료

     3. a와 이웃한 노드b를 방문했다면, a와 인접한 또 다른 노드를 방문하기 전에 b의 이웃 노드들을 전부 방문해야 한다.

        (b를 시작 노드로 DFS를 다시 시작)

     4. b의 분기를 전부 완벽하게 탐색한 후에 a의 다른 이웃 노드를 방문

         아직 방문이 안 된 정점이 없으면 종료, 있으면 다시 그 정점을 시작 정점으로 DFS를 시작
   
   - 구현
   
     - 방법 : 순환 호출 이용, 
   
       ​		   명시적인 스택 이용: 방문한 정점들을 스택에 저장하였다가 다시 꺼내어 작업
   
     - 순환 호출을 이용한 DFS 의사코드(pseudocode)
   
     ```
     void  search(Node root){
         if(root == null) return;
         visit(root);
         root.visited = true;
         for each(Node n in root.adjacent){
             if(n.visited == false)
                 search(n);
         }
     }
     ```
   
     - 순환 호출을 이용한 DFS구현(JAVA)
   
     ```JAVA
     class Graph{
         private int cnt;
         private LinkedList<Integer> ajd[];
         Graph(int cnt){
             this.cnt = cnt;
             adj = new LinkedList[cnt];
             for(int i = 0; i<cnt; i++)
                 adj[i] = new LinkedList();
         }
         void addEdge(int cnt, int data){
             adj[cnt].add(data);
         }
         void utilDFS(int v, boolean visited[]){
             int n;
             visited[v] = true;
             System.out.print(v+" ");
             Iterator[Integer] i = adj.listIterator();
             while(i.hasNext()){
                 n = i.next();
                 if(!visited[n])
                     utilDFS(n, visited);
             }
         }
         void startDFS(int v){
             boolean visited[] = new boolean[cnt];
             utilDFS(cnt, visited);
         }
         void startDFS(){
             boolean visited[] = new boolean[cnt];
             for(int i = 0; i<cnt;i++)
                 if(visited[i]==false)
                     utilDFS(i, visited);
         }
     }
     ```
   
   - 시간 복잡도
   
     - DFS는 그래프(정점의 수:n, 간선의 수:e)의 모든 간선을 조회
       - 인접 리스트로 표현된 그래프 : O(n+e)
       - 인접 행렬로 표현된 그래프 : O(n^2)
     - 그래프 내에 적은 숫자의 간선만을 가지는 희소 그래프(Sparse Graph)의 경우 인접 행렬보다 인접 리스트를 사용하는 것이 유리

2. 너비 우선 탐색(BFS, Breadth-First Search)

   - 임의의 노드에서 시작해서 인접한 노드를 먼저 탐색하는 방법

     - 시작 정점으로부터 가까운 정점을 먼저 방문하고 멀리 떨어져 있는 정점을 나중에 방문하는 방법
     - 깊게(deep) 탐색하기 전에 넓게(wide) 탐색하는 것
     - 두 노드 사이의 최단 경로 혹은 임의의 경로를 찾고 싶을 때 사용
     - DFS보다 복잡하다.

   - 특징

     - 직관적이지 않은 면이 있다. 
     - 재귀적으로 동작하지 않는다.
     - 그래프 탐색의 경우 어떤 노드를 방문했었는지 여부를 반드시 검사해야 한다.
     - 방문한 노드들을 차례로 저장한 후 꺼낼 수 있는 자료구조인 큐를 사용
     - 'Prim', 'Dijkstra' 알고리즘과 유사

   - 과정

     깊이가 1인 모든 노드를 방문하고 나서 그 다음에는 깊이가 2인 모든 노드를, 그 다음에는 깊이가 3인 모든 노드를 방문하는 식으로 계속 방문하다가 더 이상 방문할 곳이 없다면 탐색한다

     1. a 노드를 방문(방문한 노드 체크)

        큐에 방문된 노드를 삽입, a 노드의 이웃노드들을 모두 방문한 다음에 이웃의 이웃들을 방문

     2. 큐에서 꺼낸 노드와 인접한 노드들을 모두 차례로 방문

        큐에서 꺼낸 노드를 방문하고 인접한 노드들을 모두 방문, 없다면 큐의 앞에서 노드를 꺼낸다.
        
        큐에 방문된 노드를 삽입
        
     3. 큐가 소진될때까지 계속한다.
     
   - 구현
   
     - 방법 : 자료구조 큐Queue를 이용
     - BFS 의사코드(pseudocode)
   
     ```java
     void search(Node root){
         Queue queue = new Queue();
         root.marked = true;
         queue.enqueue(root);
         while(!queue.isEmpty()){
             Node r = queue.dequeue();
             visit(r);
             foreach(Node n in r.adjacent){
                 if(n.marked == false){
                     n.marked = true;
                     queue.enqueue(n);
                 }
             }
         }
     }
     ```
   
     - BFS 구현(java)
   
     ```java
     class Graph{
     	private int cnt;
         private LinkedList<Integer> adj[];
         Graph(int cnt){
     		this.cnt = cnt;
             adj = new LinkedList[cnt];
             for(int i = 0; i<cnt; i++)
                 adj[i] = new linkedList();
         }
         void addEdge(int v, int data){
             adj[v].add(data);
         }
         void startDFS(int s){
             LinkedList<Integer> queue= new boolean[cnt];
             int n;
             visited[s] = true;
             queue.add(s);
             while(queue.size()!=0){
                 s=queue.pull();
                 Iterator<Integer> it = adj[s].listIterator();
                 while(it.hasNext()){
                   n = i.next();
                     if(!visited[n]){
     					visited[n] = true;
                         queue.add(n);
                     }
                 }
             }
          }
     }
     ```
   
   - 시간 복잡도
   
     - 정점의 수:n, 간선의 수:e
       - 인접 리스트로 표현된 그래프 : O(n+e)
       - 인접 행렬로 표현된 그래프 : O(n^2)
     - 그래프 내에 적은 숫자의 간선만을 가지는 희소 그래프(Sparse Graph)의 경우 인접 행렬보다 인접 리스트를 사용하는 것이 유리

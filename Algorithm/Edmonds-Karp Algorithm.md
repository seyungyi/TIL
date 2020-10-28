# Edmonds-Karp Algorithm

- BFS를 이용하여 네트워크 플로우 source에서 sink까지 흘러글어가는 총 유량을 구할 수 있는 알고리즘
- 시간 복잡도는 O(VE^2)

- 구현(c)

  ```c
  #define MAX 1005
  #define INF 987654321
  #define MOD 31991
  using namespace std;
  typedef long long 1l;
  typedef pair<int, int> pi;
  
  int n, c, total = 0, flow[MAX][MAX], capacity[MAX][MAX];
  
  char a, b;
  vector<int> v[MAX];
  queue<int> q;
  bool visit[MAX][MAX];
  int f(char ch){
      return ch-'A';
  }
  int main(){
      int source = f('A'), sink = f('Z');
      scanf("%d", &n);
      for(int i = 0; i<n;i++){
          scanf(" %c %c %d", &a, &b, &c);
          int q = f(a), w = f(b);
          capacity[q][w] += c;
          capacity[w][q] += c;
          v[f(a)].push_back(f(b));
          v[f(b)].push_back(f(a));
      }
      
      while(1){
          int prev[MAX];
          fill_n(&prev[0], MAX, -1);
          
          q.push(source);
          while (!q.empty()){
              int cur = q.front();
              q.pop();
              for (int k = 0; k < v[cur].size(); k++){
                  int next = v[cur][k];
               if (prev[next] == -1 && capacity[cur][next] - flow[cur][next] > 0){
                      prev[next] = cur;
                      q.push(next);
                      if (next == sink)
                          break;
                  }
              }   
           }  
          if (prev[sink] == -1)
             break;  int tmp = sink, possible_flow = INF;
          for (int i = sink ; i != source; i = prev[i])
              possible_flow = min(possible_flow, capacity[prev[i]][i] - flow[prev[i]][i]);
   
          for (int i = sink ; i != source; i = prev[i]) {
              flow[prev[i]][i] += possible_flow;
              flow[i][prev[i]] -= possible_flow;
          }
          total += possible_flow;
      }
      printf("%d\n", total);
      return 0;
  }
  ```

  
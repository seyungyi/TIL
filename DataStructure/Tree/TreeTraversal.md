# TreeTraversal

'트리 순회 알고리즘' : 트리를 순회하는 방법

- 아래 구현에 사용될 class Node

```java
class Node{
    private int data;
    private Node left;
    private Node right;
    public Node(int data){
        this.data = data;
    }
    public int getData(){
        return data;
    }
    public void setData(int data){
        this.data = data;
    }
     public Node getLeft(){
        return left;
    }
    public void setLeft(Node Left){
        this.left = left;
    }
     public Node getRight(){
        return right;
    }
    public void setRight(Node right){
        this.right = right;
    }
}
```

1. 전위 순회

   - 그래프의 깊이 우선 탐색과 같다.
   - 루트노드의 순회가 가장 먼저, 다음 왼쪽 서브노드의 순회가 행해진다.
   - 전위 순회 방법
     1. 루트 노드를 순회한다.
     2. 왼쪽 서브트리를 순회한다.
     3. 오른쪽 서브트리를 순회한다.
   - java코드

   ```java
   static public void preorder(Node n){
       if(n != null){
           System.out.println(n.getData+" ");
           preorder(n.getLeft());
           preorder(n.getRight());
       }
   }
   ```

   

2. 중위 순회

   - 이진 트리에서만 할 수 있는 순회 알고리즘
   - 루트 노드의 순회가 왼쪽 서브트리와 오른쪽 서브트리의 중간에 행해진다.

   - 중위 순회 방법
     1. 왼쪽 서브트리를 중위 순회한다.
     2. 루트노드를 순회한다.
     3. 오른쪽 서브트리를 중위순회한다.
   - java코드

   ```java
   static public void inorder(Node n){
       if(n != null){
           inorder(n.getLeft());
           System.out.println(""+n.getData());
           inorder(n.getRight());
       }
   }
   ```

3. 후위 순회

   - 왼쪽 서브트리, 오른쪽 서브트리를 순회하고 루트노드의 순회가 가장 마지막에 행해진다.
   - 후위 순회 방법
     1. 왼쪽 서브트리를 후위순회한다.
     2. 오른쪽 서브트리를 후위순회한다.
     3. 루트노드를 순회한다.
   - java코드

   ```java
   static public void postorder(Node n){
       if(n != null){
           postorder(n.getLeft());
           postorder(n.getRight());
           System.out.println(n.getData()+" ");
       }
   }
   ```

1. 레벨 순서 순회

   - 그래프의 너비 우선 탐색과 같다.
   - 레벨 순서 순회 방법
     1. 우선 루트 노드를 큐에 삽입한다. 
     2. 큐에 있는 노드들을 삭제하고 노드를 방문한다.
     3. 삭제한 노드의 왼쪽 서브트리와 오른쪽 서브트리가 null이 아닌 경우에 순서대로 큐에 삽입한다.
     4. 큐가 공백이 될 때까지 위를 반복한다.
   - class Queue

   ```java
   class Queue{
       private Node[] q;
       private int rear;
       private int front;
       public Queue(int n){
           q = new Node[n]
           rear = front = -1;
       }
       public boolean isEmpty(){
           if(front == rear) 
               return true;
           else
               return false;
       }
       public void enqueu(Node item){
           if(rear == q.length-1){
               System.out.println("Qeueu Full");
               return;
           }else{
               rear = rear+1;
               q[rear] = item;
           }
       }
       public Node dequeue(){
           if(isEmpty()){
               System.out.println("Queue Empty");
               return null;
           }else{
               front = front+1;
               return q[front];
           }
       }
   }
   ```

   - 레벨 순회식 구현 - java

   ```java
   static public void levelorder(Node node){
       Queue q = new Queue(10);
       que.enqueue(node);
       Node n;
       while(!que.isEmpty()){
       	n = que.dequeue();
           if(n!=null){
      	 		System.out.println(n.getData());
           	que.enqueue(n.getLeft());
           	que.enqueue(n.getRight());
       	}
       }
   }
   ```

5. 이진 검색 트리(Binary Search Tree)

   - 이진 검색은 일자로 나열된 정렬된 데이터에서 원하는 데이터를 빠르게 찾는 방법으로 최악의 경우에 O(log n)을 보장한다. 

   - 이진 검색 트리는 이진 검색에 용이하게 데이터를 다음과 같은 방법으로 이진트리로 구성하는 것

     1. 일렬로 나열된 데이터들 중 가장 중앙에 위치한 하나의 데이터를 m이라고 하고, m 왼쪽에 위치한 데이터들을 l, 오른쪽에 위치한 데이터들을 r이라고 하자.
     2. l과 r이 m을 부모로 가지는 트리를 구성한다.
     3. l과 r에 대해서도 각각 같은 방법으로 트리를 구성한다.

   - 이진 검색

     - 이분 탐색과 동일한 알고리즘. 오름차순으로 정렬된 자료를 기준으로 한다. 

     - 이진 검색 트리의 루트노드부터 방문하며, 다음 순서에 따라 노드를 방문한다.

       -방문한 노드가 찾는 값이라면 검색 성공.

       -방문한 노드가 단말노드이고 찾는 값이 아니라면 검색 실패

       -방문한 노드가 단말 노드가 아니고 찾는 값이 아니라면

       1. 방문한 노드의 값을 x, 찾는 값을 v라고 할 때, x < v

          방문한 노드의 오른쪽 자식을 방문

       2. x > v

          방문한 노드의 왼쪽 자식을 방문

     - 노드가 저장된 값에 특정한 규칙이 있어야 한다.

   - 이진 탐색 트리의 탐색 알고리즘 구현  - java

   ```java
   public static void search(Node node, char key){
       if(node == null){
           System.out.println("탐색 실패");
           return;
       }
       if(node.getData() == key){
           System.out.println("탐색 성공");
           return;
       }
       if(node.getData()<key){
           search(node.getRight(), key);
       }else{
           search(node.getLeft(), key);
       }
   }
   ```

   - 이진 탐색 트리의 삽입 구현 - java

     - 먼저 트리에 x를 key값으로 가지는 원소가 있는지 확인하기 위해 탐색 key 값을 x로 하여 탐색을 수행

       만일 key값 x를 가진 원소가 있어야 할 곳에 없어서 탐색을 실패하면 x를 key값으로 가진 원소가 트리에 없다는 것이기 때문에 탐색을 종료된 시점에 원소를 삽입

   ```java
   public static void insert(Node node, char key){
       Node p = node;
       Node q = null;
       while(p != null){
           if(key == q.getData()){
               System.out.println("실패: key값이 있음");
               return;
           }
           q = p;
           if(p.getData()<key){
               p = p.getRight();
           }else{
               p = p.getLeft();
           }
       }
       Node newNode = new Node(key);
       if(node == null)
           node = newNode;
       else if(key < q.getData())
           q.setLeft(newNode);
       else
           q.setRight(newNode);
   }
   ```

   - 이진 탐색 트리의 삭제 구현 - java

     - 우선 삭제하려는 키값을 가진 원소를 트리에서 찾는다.

       삭제할 원소를 성공적으로 찾으면 수행해야 될 삭제 원산은 이 원소가 가진 자식의 수(0, 1, 2)에 따라 3가지 경우가 있다.

       1. 자식이 없는 리프 노드의 삭제
          - 말단 노드의 경우 부모 노드의 해당 링크 필드를 null로 만들면 된다.
       2. 자식이 하나인 노드의 삭제
          - 이 경우에는 삭제되는 노드의 자리에 하나밖에 없는 그 자식 노드를 위치시키면 된다.
       3. 자식이 둘인 노드의 삭제
          - 이 경우에는 삭제되는 노드의 자리에 노드의 왼쪽 서브트리에서 가장 큰 원소로 대체할 것인지 노드의 오른쪽 서브티리에서 제일 작은 원소로 대체할 것인지 선택해야 한다. 선택하여 대체한 후 해당 서브트리에서 대체원소를 삭제하면 된다.

     ```java
     public static void delete(Node node, char key){
         Node p = node;
         Node delete = null;
         Node parent = null;
         while(p != null){
             if(p.getData() == key){
                 delete = p;
                 break;
             }
             parent = p;
             if(p.getData()<key)
                 p = p.getRight();
             else
                 p = p.getLeft();
         }
         if(delete == null)
             return;
         
         if(delete.getLeft()==null&&delete.getRight()==null){
             if(parent.getLeft() == delete)
                 parent.setLeft(null);
             else
                 parent.setRight(null);
         }else if(delete.getLeft()==null||delete.getRight()==null){
             if(delete.getLeft() != null)
                 if(parent.getLeft() == delete)
      	           parent.setLeft(delete.getLeft());
         	    else 
             	    parent.setRight(delete.getLeft());
             else 
                 if(parent.getLeft() == delete)
                     parent.setLeft(delete.getRight());
             	else
                     parent.setRight(delete.getRight());
         }else {
         	Node q = delete.getLeft();//왼쪽 서브트리의 최대 키값
             delete.setData(q.getDate);
             delete(delete.getLeft(), delete.getDat());
         }
     }
     ```

     














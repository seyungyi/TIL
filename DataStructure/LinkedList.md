# Linked List

- 요소와 요소 간의 연결(link)을 이용해서 리스트를 구현한 것

- 리스트는 노드(요소)들의 모임이다. 따라서 내부적으로 노드를 가지고 있어야 한다. 노드는 최소 노드의 값과 다음 노드, 이 두 가지를 알고 있어야 한다. 

- 만약 구현하는 언어가 c라면 구조체, 객체지향 언어라면 객체에 데이터 필드와 링크 필드를 만든다. 링크 필드에서 다음 노드의 포인터나 참조값을 저장해서 노드와 노드를 연결시키는 방법을 사용한다.

- head: linked list를 사용하기 위해서는 이 head가 가리키는 첫번째 노드를 찾아야 한다. 

- 데이터 추가

  - 시작부분에 추가

    - 새로운 노드를 생성 

      새로운 노드의 다음 노드로 첫번째 노드를 가리킨다

       HEAD가 새로 만들어진 노드를 가리키도록 값을 변경

    ```JAVA
    Vertex temp = new Vertex(input);
    temp.next = head;
    head = temp;
    ```

  - 중간에 추가

    - HEAD를 참조해서 첫번째 노드를 찾는다 

      값을 넣을 자리를 반복문으로 찾는다 

      새로운 노드를 생성 

      값을 넣을 자리 바로 앞의 노드의 다음 노드로 새로운 노드를 지정

      새로운 노드의 다음 노드로 앞의 노드가 가리켰던 노드를 지정

    - 배열이 추가/삭제가 느린데 반해 linked list의 경우 추가/삭제가 될 요소의 이전, 이후 노드의 참조값(next)만 변경하면 되기 때문에 속도가 빠르다.

    ```java
    Vertex temp1 = head;
    while(--k!=0)
        temp1 = temp1.next;
    Vertex temp2 = temp1.next;
    Vertex newVertex = new Vertex(input);
    temp1.next = newVertex;
    newVertex = temp2;
    ```

- 데이터 제거

  - 우선 head를 이용해서 첫번째 노드를 찾는다

    다음 노드로 이동을 반복 지울 노드를 찾는다

    지울 노드의 앞의 노드의 next를 지울 노드의 다음 노드로 변경

  ```java
  Vertex cur = head;
  while(--k!=0)
      cur = cur.next;
  Vertex deleted = cur.next;
  cur.next = cur.next.next;
  delete deleted
  ```

- 인덱스를 이용한 데이터 조회

  - 인덱스를 이용하여 데이터를 조회할 때 linked list는 head가 가리키는 노드부터 시작해서 순차적으로 노드를 찾아가는 과정을 거친다. 만약 찾는 값이 마지막에 있다면 모든 노드를 탐색하게 된다.

- trade off

  - trade off는 어떤 특성이 좋아지면 다른 특성이 나빠지는 상황을 의미한다. array list와 linked list는 이의 좋은 사례라 할 수 있다.

- Singly Linked List 구현

  - HEAD는 첫번째 노드를 지정, TAIL은 마지막 노드를 지정, SIZE는 노드의 크기를 의미, 객체 Node는 내부적으로  data와 next변수를 가진다. 
  
  - ```java
    public class LinkedList{
        private Node head;
        private Node tail;
        private int size = 0;
        private class Node{
            private Object data;
            private Node next;
            public Node(Object input){
    			this.data = input;
                this.next = null;
            }
            public String toString(){
                return String.valueOf(this.data);
            }
        }
    }
    ```
  
  - 데이터 추가
    
    - 시작에 추가
    
    ```java
    public void addFirst(Object input){
        Node newNode = new Node(input);
        newNode.next = head;
        head = newHead;
        size++;
        if(head.next==null){
            tail = head;
        }
    }
    ```
    
    - 끝에 추가
    
      ​	tail이 없이도 구현이 가능하지만 tail을 사용할 시 훨씬 효율적
    
      ```java
      public void addLast(Object input){
        Node newNode = new Node(input);
      if(size == 0){
        		addFirst(input);
            }else{
        		tail.next = newNode;
                tail = newNode;
                size++;
            }
        }
      ```
    
    - 중간에 추가
    
      - 특정 위치의 노드를 찾아내는 방법
    
        ```java
        Node node(int index){
        	Node tmp = head;
            for(int i = 0; i<index;i++)
                tmp = tmp.next;
            retuen tmp;
        }
        ```
    
      - node 메소드를 이용한 추가 메소드
    
      ```java
      public void add(int k, Object input){
          if(k==0){
              addFirst(input);
          }else{
              Node tmp1 = node(k-1);
              Node tmp2 = temp1.next;
              Node newNode = new Node(input);
              tmp1.next = newNode;
              newNode.next = tmp2;
              size++;
              if(newNode.next == null)
                  tail=newNode;
          }
          
      }
      ```
    
  - 출력
  
    ```java
    public String toString(){
        if(head==null){
            return "[]";
        }
        Node temp = head;
        String str = "{";
        while(temp.next!=null){
            str+=temp.data+", ";
            temp = temp.next;
        }
        str+=temp.next;
        return str+"]";
    }
    ```
  
  - 삭제
  
    - 처음 노드 삭제
  
    ```java
    public Object removeFirst(){
        Object data = head.data;
        head = head.next;
        size--;
        return data;
    }
    ```
  
    - 중간 노드 삭제
  
    ```java
    public Object remove(int k){
        if(k==0) 
            return removeFirst();
        Node temp = node(k-1);
        Node deleted = temp.next;
        temp.next = temp.next.next;
        Object data = deleted.data;
        if(deleted == tail)
            tail = temp;
        deleted = null;
        size--;
        return data;
    }
    ```
  
  - 요소 가져오기
  
    ```java
    public Object get(int k){
    	Node temp = node(k);
        return temp.data;
    }
    ```
  
  - 탐색
  
    ```java
    public int indexOf(Object data){
        Node temp = head;
        int index = 0;
        while(temp.data != data){
            temp = temp.naxt;
            index++;
            if(temp==null)
                return -1;
        }
        return index;
    }
    ```
  
  - 반복
  
    - linked list에서는 반복문으로 반복작업을 하는 것은 바람직하지 않다. get을 호출할때마다 내부적으로 반복문이 실행되어 효율적이지 않기 때문이다. 이런 경우 Iterator를 사용하는 것이 유리하다. Iterator는 내부적으로 반복 처리된 노드가 무엇인지에 대한 정보를 유지하기 때문이다.
  
    - ListIterator 
  
      ```java
      public class ListIterator{
          private Node lastReturned;
          private Node next;
          private int nextIndex;
          ListIterator(){
              next = head;
              nextIndex = 0;
          }
          public Object next(){
              lastReturned = next;
              next = next.next;
              nextIndex++;
              return lastReturned.data;
          }
          public boolean hasNext(){
              return nextIndex < size();
          }
          public void add(Object input){
              Node newNode = new Node(input);
              if(lastReturned == null){
                  head = newNode;
                  newNode.next = next;
              }else{
                  lastReturned.next = newNode;
                  newNode.next = next;
                  if(nextIndex == size()) 
                       tail = newNode;
              }
              lastReturned = newNode;
              nextIndex++;
              size++;//LinkeList.size
          }
          public void remove(){
              if(nextIndex==0){
                  throw new IllegalStateException();
              }
              LinkedList.this.remove(nextIndex-1);
              nextIndex--;
          }
      }
      ```
  
- Doubly Linked List

  - 이중 연결 리스트는 노드와 노드가 서로 연결되어 있다. 즉, 노드가 이전 노드와 다음 노드로 구성되어 있다.
  - 이중 연결 리스트는 양방향 탐색이 가능하다. 이는 특정 인덱스 위치의 요소를 가져올 때와 반복자를 이용해서 탐색할 때 드러난다.  단반향에 비해 양방향은 최악의 경우 탐색해야하는 요소가 반으로 줄어든다.
  - 단점은 단방향에 비해 많이 사용하며 구현이 조금 더 복잡해진다는 점이 있다.

  - 노드의 추가

    - 새로운 노드를 a 노드와 b 노드 사이에 추가할 경우

      새 노드의 다음노드로 b노드를,  b노드의 이전 노드로 새 노드를 연결

      a 노드의 다음 노드로 새 노드를, 새 노드의 이전 노드로 a 노드를 연결

  - 노드의 제거

    - 삭제하려는 노드의 이전 노드 a를 찾는다

      삭제하려는 노드 b를 찾는다

      삭제하려는 노드의 다음 노드 c를 찾는다

      노드 b를 삭제

      a 노드의 다음노드로 c노드를, c 노드의 이전 노드로 a 노드를 지정

  - DoublyLinkedList

    ```java
    public class DoublyLinkedList{
        private Node head;
        private Node tail;
        private int size = 0;
        
        private class Node{
            private Object data;
            private Node prev;
            private Node next;
            Node(Object data){
                this.data = data;
                this.previousNode = null;
                this.nextNode = null;
            }
            public String toString(){
                return String.valueOf(this.data);
            }
        }
    }
    ```

  - 추가

    - 시작 위치에 추가

      ```java
      public void addFirst(Object input){
          Node newNode = new Node(input);
          newNode.next = head;
          if(head!=null)
              head.prev = newNode;
          head = newNode;
          size++;
          if(head.next==null){
      		tail = head;
          }
      }
      ```

    - 특정 위치에 추가

      ```java
      public void add(int k, Object input){
          if(k==0)
              addFirst(input);
          else{
              Node temp1 = node(k-1);
              Node temp2 = temp1.next;
              Node new Node = new Node(input);
              temp1.next = newNode;
              newNode.next = temp2;
              if(temp2!=null)
                  temp2.prev = newNode;
              newNode.prev = temp1;
              size++;
              if(newNode.next == null){
                  tail=newNode;
              }
          }
      }
      ```

    - 끝에 추가

      ```java
      pubic void addLast(Object input){
          Node newNode = new Node(input);
          if(size==0)
              addFirst(input);
          else{
      		tail.next = newNode;
              newNode.prev = tail;
              tail = newNode;
              size++;
          }
      }
      ```

    - 노드 추가

      ```java
      Node node(int index){
          if(index<size/2){
             	Node x = head;
              for(int i = 0; i<index;i++)
                  x = x.next;
          }else{
              Node x = tail;
              for(int i = size-1; i>index;i++)
                  x = x.prev;
          }
          return x;
      }
      ```

  - 삭제

    - 처음 노드 삭제

      ```java
      public Object removeFirst(){
      	Node temp = head;
          head = temp.next;
          Object data = temp.data;
          temp = null;
          if(head!=null)
              head.prev = null;
          size--;
          return data;
      }
      ```

      

    - 특정 위치 노드 삭제

      ```java
      public Object remove(int k){
          if(k==0)
              return removeFirst();
          Node temp = node(k-1);
          Node deleted = temp.next;
          temp.next = temp.next.next;
          if(temp.next != null){
              temp.next.prev = temp;
          }
          Object data = deleted.data;
          if(deleted == tail)
              tail = temp;
          deleted = null;
          return data;
      }
      ```

    - 마지막 노드 삭제

      ```java
      public Object removeLast(){
          return remove(size-1);
      }
      ```

  - 인덱스로 요소 가져오기

    ```java
    public Object get(int k){
        Node temp = node(k);
        return temp.data;
    }
    ```

  - 탐색

    ```java
    public int indexOf(Object data){
        Node temp = head;
        int index = 0;
        while(temp.data!=data){
            temp = temp.next;
            index++;
            if(temp==null)
                return -1;
        }
        return index;
    }
    ```

  - 반복

    - SinglyLinkedList의 Iterator에 3개의 메소드를 추가한다.

    ```java
    public class ListIterator{
        private Node lastReturned;
        private Node next;
        private int nextIndex;
        ListIterator(){
            next = head;
            nextIndex = 0;
        }
        public Object next(){
            lastReturned = next;
            next = next.next;
            nextIndex++;
            return lastReturned.data;
        }
        public boolean hasNext(){
            return nextIndex < size();
        }
        public boelean hasPrevious(){
            return nextIndex > 0;
        }
        public Object previous(){
            if(next == null)
             	lastReturned = next = tail;
            else
                lastReturned = next = next.prev;
            nextIndex--;
            return lastReturned.daata;
        }
        public void add(Object input){
            Node newNode = new Node(input);
            if(lastReturned == null){
                head = newNode;
                newNode.next = next;
            }else{
                lastReturned.next = newNode;
                newNode.prev = lastReturned;
                if(next != null){
                    newNode.next = next;
                    next.prev = newNode;
                }else
                    tail = newNode;
            }
        	lastReturned = newNode;
       	 	nextIndex++;
        	size++;
        }
        public void remove(){
            if(nextIndex == 0)
                throw new IllegalStateException();
            Node n = lastReturned.next;
            Node p = lastReturned.prev;
            if(p==null){
                head = n;
                head.prev = null;
                lastReturned = null;
            }
            if(n == null){
                tail = p;
                tail.next = null;
            }else
                n.prev = p;
            if(next == null)
                lastReturned = tail;
            else
                lastReturned = next.prev;
            size--;
            nextIndex--;
        }
    }
    ```

    

[참고](https://opentutorials.org/module/1335)
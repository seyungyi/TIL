# Queue

1. Queue의 개요

   - 선입선출(First In First Out) 형태의 자료구조
   - 가장 오래된 데이터를 front, 가장 최근의 데이터를 rear라고 한다.

2. Queue의 동작

   - 삽입(enqueue) : rear++ 후 새로운 데이터를 삽입

   - 삭제(추출, dequeue) : front의 데이터를 꺼낸 후 front--, front 값이 rear를 추월하게 된면 자료가 하나도 없는 빈 큐임을 의미한다.

   - 읽기(peek) : front의 데이터를 꺼내서 반환 한다.

3. 배열을 이용한 큐 

   - **ArrayQueue.java**

   ```java
   public class ArrayQueue{
       private int front;
       private int rear;
       private int maxSize;
       private Object[] queueArray;
       public ArrayQueue(int maxSize){
           this.front = 0;
           this.rear = -1;
           this.maxSize = maxSize;
           this.queueArray = new Object[maxSize];
       }
       public boolean empty() {
       	return (front==rear+1);
       }
       public boolean full() {
       	return (rear==maxSize-1);
       }
       public void enqueue(Object data) {
       	if(full()) throws new ArrayIndexOutOfBoundsException();
       	queueArray[++rear] = data;
       }
       public Object peek() {
       	if(empty()) throws new ArrayIndexOutOfBoundsException();
       	return queueArray[front];
       }
       public Object dequeue() {
       	if(empty()) throws new ArrayIndexOutOfBoundsException();
       	Object data = peek();
       	front++;
       	return data;
       }
   }
   ```

   - 이미 꺼낸 데이터가 들어 있던 배열의 인덱스를 다시 활용할 수 없다.

   - 배열이 꽉 안차더라도 rear와 front가 계속 증가되다 보면 언젠가는 배열의 사이즈까지 도달하게 되어 사용할 수 없게 된다.

     이에 대한 해결 방법으로 이동큐(moving queue)을 사용할 수 있다. 큐가 차면 앞부분에 사용할 수 있는 공간만큼 전체 데이터들을 앞으로 이동시키고 rear와 front를 수정하여 남은 공간을 사용하는 방법 하지만 이동시간을 도려하면 효율적이지 않다. 이를 보완한 원형큐가 있다.

4. 연결 리스트를 이용한 큐의 구현

   - **ListQueue.java**

   ```java
   public class ListQueue{
      private class Node{
   	   private Object data;
   	   private Node nextNode;
   	   Node(Object data){
   		   this.data = data;
   		   this.nextNode = null;
   	   }
      }
      private Node front;
      private Node rear;
      public ListQueue() {
   	   this.front = null;
   	   this.rear = null;
      }
      public boolean empty() {
   	   return (front==null);
      }
      public void enqueue(Object data) {
   	   Node node = new Node(data);
   	   node.nextNode = null;
   	   if(empty()) {
   		   rear = node;
   		   front = node;
   	   }else {
   		   rear.nextNode = node;
   		   rear = node;
   	   }
      }
      public Object peek() {
   	   if(empty()) throws new ArrayIndexOutOfBoundsException();
   	   return front.data;
      }
      public Object dequeue() {
   	   Object data = peek();
   	   front = front.nextNode;
   	   if(empty()) rear = null;
   	   return data;
      }
   }
   ```

5. 원형 큐(Circular Queue)

   - 배열큐의 문제점을 보완한 구조로 큐의 맨 끝과 맨 처음이 연결된 형태의 구조이기 때문에 이미 꺼내어 사용한 큐의 앞부분에 다시 데이터를 저장하여 재사용이 가능한 형태의 큐
   - **CircularQueue.java**

   ```java
   public class CircularQueue{
   	 private int front;
        private int rear;
        private int maxSize;
        private Object[] queueArray;
   
        public CircularQueue(int maxSize) {
       	 this.front = 0;
       	 this.rear = -1;
       	 this.maxSize = maxSize+1;
       	 this.queueArray = new Object[this.maxSize];
        }
        public boolean empty() {
       	 return (front==rear+1)||(front+maxSize-1==rear);
        }
        public boolean full() {
       	 return (rear==maxSize-1)||(front+maxSize-2==rear);
        }
        public void enqueue(Object data) {
       	 if(full()) throw new ArrayIndexOutOfBoundsException();
       	 if(rear==maxSize-1) rear = -1;
       	 queueArray[++rear]=data;
        }
        public Object peek() {
       	 if(empty()) throw new ArrayIndexOutOfBoundsException();
       	 return queueArray[front];
        }
        public Object dequeue() {
       	 if(empty()) throw new ArrayIndexOutOfBoundsExceptio();
       	 Object data = peek();
       	 if(++front==maxSize-1) front=0;
       	 return data;
        }
   }
   ```

6. 우선순위 큐(Priority Queue)

   - 데이터의 우선순위에 따라 우선순위가 높은 데이터부터 꺼내도록 만들어진 큐
   - 삽입할 때 우선순위에 따라서 정렬하여 삽입한 후 한쪽 방향에서만 꺼내쓴다.
   - **Priority Queue.java**: 값이 작은 데이터에 우선순위를 높이 부여하는 큐

   ```java
   public class PriorityQueue{
   	 private int maxSize;
   	 private long[] queueArray;
   	 private int count;
   	 public PriorityQueue(int maxSize) {
   		 this.maxSize = maxSize;
   		 this.queueArray = new long[maxSize];
   		 this.count = 0;
   	 }
   	 public boolean empty() {
   		 return (count==0);
   	 }
   	 public boolean full() {
   		 return (count==maxSize);
   	 }
   	 public void enqueue(long data) {
   		 if(full()) throw new ArrayIndexOutOfBoundsException();
   		 if(empty()) {
   			 queueArray[count++] = data;
   		 }else {
   			 int i;
   			 for(i = count-1; i>=0;i--) {
   				 if(data>queueArray[i]) {
   					 queueArray[i+1]=queueArray[i];
   				 }else {
   					break; 
   				 }
   			 }
   			 queueArray[i+1] = data;
   			 count++;
   		 }
   	 }
   	 public Object peek() {
   		 if(empty()) throw new ArrayIndexOutOfBoundsException();
            return queueArray[count-1];
   	 }
   	 public Object dequeue() {
   		 Object data = peek();
   		 count--;
   		 return data;
   	 }
   }
   ```

7. 데크(Deque-double ended queue)

   - 리스트의 양쪽 끝 모두에서 데이터를 삽입, 삭제할 수 있도록 만들어진 특별한 형태의 자료구조
   - 큐나 스택으로 모두 활용할 수 있다.
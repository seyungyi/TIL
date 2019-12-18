# AVL Tree

- 서브트리의 높이를 적절하게 제어해 전체 트리가 어느 한쪽으로 늘어지지 않도록 한 BST의 일종.
  
  - 요소를 삽입하거나 삭제하는 과정에서 서브 트리를 재구성해 트리전체의 균형을 맞춘다.
- 일종의 균형 잡힌 이진 트리
  
- 2-3트리, 2-3-4트리, Red-Black트리, B트리 
  
- 고안한 사람들의 이름의 앞글자를 따서 AVL(Adelson-Velskii Landis)트리가 지음

- 균형 인수(Balance Factor) = 왼쪽 서브트리의 높이 - 오른쪽 서브트리의 높이

  - 균형의 정도를 표현하는 단위
  - 균형 인수의 절대값이 크면 클수록 트리의 균형이 무너진 상태

  - AVL 트리는 균형인수의 절대값이 2이상인 경우에 위치 재조정을 진행

  - LL상태 : 균형 인수 +2가 존재하는 상태
  - LL회전 : 'LL상태'의 데이터를 균형 잡기 위해 회전하는 방법
  - RR상태 : 균형 인수 -2가 존재하는 상태
  - RR회전 : 'RR상태'의 데이터를 균형 잡기 위해 회전하는 방법

- single rotation

  - 회전을 한 차례 수행해 원하는 결과를 얻을 수 있는 경우
  - 삽입 연산의 single rotation
    -  삽입 연산의 single rotation은 V(U의 자식노드, BF 절대값이 1이하)를 중심으로 실시(U는 BF 절대값이 2 이상이면서 새 노드와 가장 가까운 조상 노드)
    - V가 U의 왼쪽 자식 노드이고, V의 왼쪽 서브트리에 새 노드 삽입 :  V를 기준으로 right rotation
    - V가 U의 오른쪽 자식 노드이고, V의 오른쪽 서브트리에 새 노드 삽입 :  V를 기준으로 left rotation
  - left rotation

  ```python
  def lrotate(self):
      cur = self.node #현재 트리의 기존 root
      right = self.node.right.node #기존 root의 right child
  	right_left = right.left.node #right의 left child
      
      self.node = right
      right.left.code = cur
      cur.right.node = right_left
  ```

  - right rotation

  ```python
  def rrotate(self) : 
      cur = self.node
      left = self.node.left.node
      left_right = left.right.node
      
      self.node = left
      left.right.node = cur
      cur.left.node = left_right
  ```

- double rotation

  - rotation 한 차례만으로 원하는 삽입 결과를 내지 못하는 경우
- double rotation은 V(U의 자식노드, BF 절대값이 1이하)를 중심으로 실시(U는 BF 절대값이 2 이상이면서 새 노드와 가장 가까운 조상 노드)
    - V가 U의 왼쪽 자식 노드, V의 오른쪽 서브트리에 새 노드 삽입
    - V가 U의 오른쪽 자식 노드, V의 왼쪽 서브트리에 새 노드 삽입

- 시나리오별 rotation

  - 시나리오1 : U(루트노드)의 왼쪽 자식노드의 왼쪽 서브트리 A에 새 노드 삽입 : single right rotation
  - 시나리오2 : U의 왼쪽 자식노드의 오른쪽 서브트리 A에 새 노드 삽입 : double rotation(left-right)
  - 시나리오3 : U의 오른쪽 자식노드의 왼쪽 서브트리 A에 새 노드 삽입 : double rotation(right-left)
  - 시나리오4 : U의 오른쪽 자식노드의 오른쪽 서브트리 A에 새 노드 삽입 : single left rotation

  ```python
  def rebalance(self): 
      #현재 노드(루트)에서 잎새노드에 이르는 경로의 모든 노드에 대해 BF 업데이트
      self.update_heights(False)
      self.update_balances(False)
      while self.balance < -1 or self.balance > 1:
          #U의 왼쪽 서브트리 높이가 오른쪽보다 크므로 시나리오 1 or 2에 해당
          if self.balance > 1:
              #시나리오 2에 해당 우선 single left rotation
              if self.node.left.balance < 0:
                  self.node.left.lrotate()
                  self.update_heights()
      			self.update_balances()
              #시나리오 1에 해당 single right rotation(시나리오 2도 수행)
              self.rrotate()
              self.update_heights()
      		self.update_balances()
          #U의 오른쪽 서브트리 높이가 왼쪽보다 크므로 시나리오 3 or 4에 해당
          if self.balance < -1:
              # 시나리오 3에 해당 우선 single right rotation
              if self.node.right.balance > 0:
                  self.node.right.rrotate()
                  self.update_heights()
      			self.update_balances()
              #시나리오 4에 해당 single left rotation(시나리오 4도 수행)
              self.lrotate()
              self.update_heights()
     	 		self.update_balances()
  ```

- 삽입/삭제 연산

  - AVL 트리의 삽입 연산은 기본적으로 이진탐색트리와 동일하다. 

  ```python
  def insert(self, key):
      tree = self.node
      newnode = Node(key)
      if tree==None:
          self.node = newnode
          self.node.left = AVLTree()
          self.node.right = AVLTree()
          debug("Inserted key["+str(key)+"]")
      elif key < tree.key:
          self.node.left.insert(key)
      elif key > tree.key:
          self.node.right.insert(key)
      else:
          debug("Key["+str(key)+"] already in tree")
      self.rebalance()
  ```

  - 삭제 연산도 이진탐색트리와 동일하지만 삭제 후 balance Factor가 깨진 노드가 있을 수 있으니 rebalance한다.

- 계산 복잡성(높이가 h)

  - 삽입연산 : O(h)이다. b/c BF 계산 : O(h), rotation : O(1)
  - 삭제 연산 : O(h)이다. b/c BF 계산 : O(h), rotation : O(1)

  - ALV트리 노드 수가 n개일 때 높이 h의 하한은 2log2 n이라고 한다. 즉, O(h) = O(log n)





[참고]([https://ratsgo.github.io/data%20structure&algorithm/2017/10/27/avltree/](https://ratsgo.github.io/data structure&algorithm/2017/10/27/avltree/))






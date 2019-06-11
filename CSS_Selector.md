# [ CSS 선택자 ]

- CSS 선택자(selector)

  `-` 스타일을 적용하기 위해 대상을 선택하는 방법

- 전체 선택자

  `-` 페이지의 모든 요소를 대상으로 스타일 적용시 사용

  `-` 다른 선택자와 함께 모든 하위 요소에 스타일을 적용시 사용

  `-` ex) {margin:0; padding:0;}

- 태그 선택자

  `-` 문서 안의 특정 태그에 스타일이 모두 적용

  `-` ex) p{font-size:12px; font-family:"돋움";}

- 클래스 선택자

  `-` 문서 안에서 반복할 스타일이면 클래스 선택자로 정의하고 . 뒤에 클래스 이름 지정

  `-` ex) .redtext {color:red;}

- id선택자

  `-` 문서 안에서 한번만 사용한다면 id선택자로 정의하고 파운드(#) 다음에 id 이름 지정

  `-` ex) #pic2 { clear: both; float: left; }

- 하위 선택자(descendant selector)

  `-` 부모 요소에 포함된 모든 하위 요소에 스타일이 적용된다.

  `-` 하위 선택자를 정의할 때는 상위 요소와 하위 요소를 나란히 작성한다.

  `-` ex) selection p { color: blue; } 

- 자식 선택자(child selector)

  `-` 부모 요소의 자식 요소에만 스타일이 적용된다.

  `-` ex) section > p { color: blue; }

- 인접 형제 선택자(adjacent selector)

  `-` 문서 구조상 같은 부모를 가진 형제 요소 중 첫 번째 동생 요소에만 스타일이 적용된다.

  `-` 같은 부모 요소를 가지는 요소들을 형제 관계라고 부른다.

  `-` 먼저 나오는 요소를 '형 요소', 나중에 나오는 요소를 '동생 요소'라고 한다.

  `-` ex) h1 + p { text-decoration: underline; }

- 형제 선택자(sibling selector)

  `-` 형제 요소들 중에서 모든 동생 요소들에 스타일이 적용된다.

  `-` ex) h1 ~ p { text-decoration: underline; }

- 그룹 선택자(descendant selector)

  `-` 같은 속성을 적용해야 할 경우 똑같은 스타일을 두번 정의하지 않고 한번에 묶어서 정의한다.

  `-` 쉼표로 선택자 구분

  `-` ex) a, p { color: #fffff; }

- 속성 선택자(property selector)

  `-` 태그에 정의된 속성과 속성의 값을 가지고 대상을 정하는 선택자이다.

  | 표기           | 설명                                                         |
  | -------------- | :----------------------------------------------------------- |
  | [ 속성 ]       | 지정한 '속성'을 가지고 있는 요소를 찾아 스타일을 적용        |
  | [ 속성 ~= 값 ] | '속성'과 '값'을 체크해 여러 개의 값 중 하나만 일치해도 스타일을 적용 |
  | [ 속성 ^= 값 ] | '속성'의 '값'이 지정한 문자로 시작하는 속성값에 대해서만 스타일을 적용 |
  | [ 속성 $= 값 ] | '속성'의 '값'이 지정한 문자로 끝나는 속성에 대해서만 스타일을 적용 |
  | [ 속성 *= 값 ] | 속성 값 중에 '값'의 일부가 포함되어 있는 속성에 스타일을 지정 |

- 가상 선택자(pseudo selector)

  `-` 웹 문서의 소스에는 실제로 존재하지 않지만 필요에 의해 임의로 가상의 선택자를 지정하여 사용하는 것을 말한다.

  | 표기          | 설명                                                         |
  | ------------- | ------------------------------------------------------------ |
  | :first-letter | 첫 번째 문자에 스타일을 적용한다.                            |
  | :first-line   | 첫 번째 행에 스타일 적용                                     |
  | :first-child  | 첫 번째 자식 요소에 스타일 적용                              |
  | :last-child   | 마지막 자식 요소에 스타일 적용                               |
  | :before       | 특정 요소의 내용 앞에 지정한 내용을 만듬                     |
  | :after        | 특정 요소의 내용 뒤에 지정한 내용을 만드                     |
  | :hover        | 사용자가 대상 요소를 가리키고 있을 때 스타일 적용. 롤 오버 등 |
  | :focus        | 대상 요소가 포커스 되었을 때 스타일 적용                     |

------

### < 주요 CSS 속성들 >

(General)

class, id, div, span, color, cursor, display, overflow, visiblilty

(text)

letter-spacing, line-height, text-align, text-decoration, text-indent, text-transform, vertical-align, word-spacing

(font)

font-style, font-variant, font-weight, font-size, fint-family

(box model)

height, margin, padding, margin-(top,bottm,left,right), padind-(top,bottom, left, right)

(border)

border-width, border-style, border-color

(background)

background-color, background-image,background-repeat, background-attachment, background-position

(position)

clear, float, left, top, postion, z-index

(list)

list-style-type, list-style-position, list-style-image

---

### < CSS3에 추가된 속성들>

- 새로운 CSS3 속성(프로퍼티)를 사용하려면 속성 앞에 브라우저를 식별할 수 있는 접두어 필요

| -webkit- | 사파리, 크롬 등       |
| -------- | --------------------- |
| -moz-    | 모질라, 파이어폭스 등 |
| -o-      | 오페라                |
| -ms-     | 인터넷 익스플로러     |

- border-radius : 테두리 선의 모서리 부분을 둥글게 해주는 속성

- box-shadow

  | 가로 오프셋 | 양수값은 오른쪽, 음수값은 왼쪽에 그림자 생김 |
  | ----------- | -------------------------------------------- |
  | 세로 오프셋 | 양수값은 아래쪽, 음수값은 왼쪽에 그림자 생김 |
  | blur radius | 그림자의 번지는 정도. 0이 최소값             |
  | 그림자 색상 | 16진수나 RCB값, 색상 이름 모두 사용가능      |

- text-shadow

  | 가로 오프셋 | 양수값은 오른쪽, 음수값은 왼쪽에 그림자 생김 |
  | ----------- | -------------------------------------------- |
  | 세로 오프셋 | 양수값은 아래쪽, 음수값은 왼쪽에 그림자 생김 |
  | blur radius | 그림자의 번지는 정도. 0이 최소값             |
  | 그림자 색상 | 16진수나 RCB값, 색상 이름 모두 사용가능      |

- gradient 속성값

  `-` direction은 색상설정 방향

  `-` ex) background: linear-gradient(direction, color1, color2, ..., color3);

- opacity 속성값

  `-` 칼라나 이미지의 투명도를 설정하는 속성으로 0.0 ~ 1.0 사이의 값을 설정

  `-` ex) opcity: 0.5;
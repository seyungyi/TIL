# [ Python Basic Grammer_8 ]

## < 파이썬 XML(eXtensible Markup Language) >

- XML 처리를 위한 파이썬 라이브러리

  ```url
  http://wiki.python.org/moin/PythonXml
  ```

- ElementTree 라이브러리를 사용(많은 이용률)

  - Tkinter로 유명한 프레드릭 런드가 만든 XML 제너레이터&파서
  - 외부 라이브러리로 존재하다 파이썬 2.5부터 통합

- XMl 처리의 더 자세한 내용 : 프레드릭 런드가 직접 작성한 튜토리얼 참고

  ```
  http://effbot.org/zone/element.html
  ```

### XML 문서 생성하기

- ElementTree를 이용해 XML 문서를 생성

  ```xml
  <note date="20151231">
  	<to>Tove</to>
      <from>Jani</from>
      <heading>Reminder</heading>
      <body>Don't forget me this weekend!</body>
  </note>
  ```

- 다음 파이썬 소스 작성

  ```python
  from xml.etree.ElementTree import Element, dump
  
  note = Element("note")
  to = Element("to")
  to.text = "Tove"
  
  note.append(to)
  dump(note)
  
  결과 : <note><to>Tove</to></note>
  ==> 엘리먼트를 이용하면 태그를 만들 수 있고, 만들어진 태그에 텍스트 값을 추가할 수 있음
  ```

- SubElement : 서브엘리먼트로 좀 더 편리하게 태그를 추가 가능

  ```python
  from xml.etree.ElementTree import Element, SubElement, dump
  
  note = Element("note")
  to = Element("to")
  to.text = "Tove"
  
  note.append(to)
  SubElement(note, "from").text = "Jani" --> 태그명과 텍스트 설정
  
  dump(note)
  
  결과 : <note><to>Tove</to><from>Jani</from></note>
  ==>  서브엘리먼트는 태그명과 태그의 텍스트 값을 한 번에 설정 가능.
  
  - 또는 태그 사이에 태그를 추가하거나 특정 태그를 삭제 가능
  dummy = Element("dummy")
  note.insert(1, dummy)
  note.remove(dummy)
  ```

- 애트리뷰트 추가하기 : note 태그에 애트리뷰트(attribute)를 추가해보기

  ```python
  from xml.etree.ElementTree import Element, SubElement, dump
  
  note = Element("note")
  note.attrib["date"] = "20120104"  --> 애트리뷰트 값 추가
  
  to = Element("to")
  to.text = "Tove"
  note.append(to)
  
  SubElement(note, "from").text = "Jani"
  SubElement(note, "heading").text = "Reminder"
  SubElement(note, "body").text = "Don't forget me this weekend!"
  
  dump(note)
  
  결과 : <note date="20120104"><to>Tove</to><from>Jani</from>...생략...</note>
  ```

- indent 함수 : 위의 결과값이 한 줄로 이루어져서 보기 쉽지 않기에 정렬된 형태의 xml 값을 보기위해 사용하는 함수

  ```python
  from xml.etree.ElementTree import Element, SubElement, dump
  
  note = Element("note")
  note.attrib["date"] = "20120104"  --> 애트리뷰트 값 추가
  to = Element("to")
  to.text = "Tove"
  note.append(to)
  
  SubElement(note, "from").text = "Jani"
  SubElement(note, "heading").text = "Reminder"
  SubElement(note, "body").text = "Don't forget me this weekend!"
  
  def indent(elem, level=0):
      i = "\n" + level*" "
      if len(elem):
          if not elem.text or not elem.text.strip():
              elem.text = i + " "
          if not elem.tail or not elem.tail.strip():
              elem.tail = i
          for elem in elem:
              indent(elem, level+1)
          if not elem.tail or not elem.tail.strip():
              elem.tail = i
      else:
          if level and (not elem.tail or not elem.tail.strip()):
              elem.tail = i
  
  indent(note)
  dump(note)
  ```

  ```xml
  (결과) 정렬된 형태의 xml값 확인 가능
  <note date="20120104">
  	<to>Tove</to>
      <from>Jani</from>
      <heading>Reminder</heading>
      <body>Don't forget me this weekend!</body>
  </note>
  ```

- 파일에 쓰기(write) 수행하기

  ```python
  from xml.etree.ElementTree import ElementTree
  ElementTree(note).write("note.xml")
  ```

### XML 문서 파싱하기

- ElementTree의 parse라는 함수를 이용해 xml을 파싱

  ```python
  from xml.etree.ElementTree import parse
  tree = parse("note.xml")
  note = tree.getroot()
  ```

- 애트리뷰트 값 읽기

  - get() 메서드로 애트리뷰트 값 읽기
  - 두번 째 입력 인수로 디폴트 값을 주면 첫 번째 인수가 없을시 두 번째 값을 리턴
  - keys : 모든 애트리뷰트의 키 값을 리스트로 리턴
  - items : key, value 쌍을 리턴
  - 애트리뷰트 값을 가져오는 방법은 딕셔너리와 동일함

  ```python
  print(note.get("data"))
  print(note.get("foo", "default"))
  print(note.keys())
  print(note.items())
  
  결과)
  20120104
  default
  ['date']
  [('date', '20120104')]
  ```

- XML 태그 접근하기

  ```python
  - XML 태그 접근 방법
  from_tag = note.find("from") -> note태그 하위에 from과 일치하는 첫번째 태그를 찾아 리턴하고 없으면 None을 리턴
  from_tags = note.findall("from") -> note태그 하위에 from과 일치하는 모든 태그를 리스트로 리턴
  from_text = note.findtext("from") -> note태그 하위에 from과 일치하는 첫 번째 태그의 텍스트 값을 리턴
  ```

  - 특정 태그의 모든 하위 엘리먼트를 순차적으로 처리할시 사용하는 메서드

    ```python
    childs = note.getiterator()
    childs = note.getchildren()
    
    - getiterator()함수는 첫 번째 인수로 다음과 같이 태그명 받기 가능
    note.getiterator("from")
    ==> from 태그의 하위 엘리먼트들이 순차적으로 리턴됨
    - 다음과 같이 많이 사용됨
    for parent in tree.getiterator():
        for child in parent:
            ... work on parent/child tuple
    ```
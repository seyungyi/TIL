# 필요한 기능 : 문서 파일 읽어 들이기, 문자열 변경하기
# 입력 값 : 탭을 포함한 문서 파일
# 출력 값 : 탭이 공백으로 수정된 문서 파일
# 입력값 출력
import sys
src = sys.argv[1]
dst = sys.argv[2]
print(src)
print(dst)

# 테스트를 위한 원본파일에 단어 입력(탭 문자로 분리되도록 입력)
# Life  is  too short
# 탭 문자를 포함한 문서를 읽어 탭을 공백 4개로 변환하는 코드
import sys
src = sys.argv[1]
dst = sys.argv[2]
f = open(src)
tab_content = f.read()
f.close()

space_content = tab_content.replace("\t", " "*4)
print(space_content)

# 변경된 내용을 다른 파일에 저장하는 코드
import sys
src = sys.argv[1]
dst = sys.argv[2]
f.open(src)
tab_content = f.read()
f.close()

space_content = tab_content.replace("\t", " "*4)

f = open(dst, 'w')
f.write(space_content)
f.close()

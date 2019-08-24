# 필요한 기능 : 메모 추가하기, 메모 조회하기
# 입력 받는 값 : 메모 내용, 프로그램 실행 옵션
# 출력하는 값 : memo.txt

# 입력으로 받은 옵션과 메모를 출력하는 코드
# 경로 : C:/Python/Notepad.py
import sys
option = sys.argv[1]
memo = sys.argv[2]
print(option)
print(memo)
# cmd에서 명령 실행 -> C:\Python>python Notepad.py -a "Life is too short"

# 입력으로 받은 메모를 파일에 쓰는 코드
import sys
option = sys.argv[1]
if option == '-a':
    memo = sys.argv[2]
    f = open('memo.txt', 'a')
    f.write(memo)
    f.write('\n')
    f.close()
# 실행 -> C:\Python>python Notepad.py -a "Life is too short"
# C:\Python>type Notepad.txt

# 메모 출력을 위한 코드
import sys
option = sys.argv[1]
if option == '-a':
    memo = sys.argv[2]
    f = open('memo.txt', 'a')
    f.write(memo)
    f.write('\n')
    f.close()
elif option == '-v':
    f = open('memo.txt')
    memo = f.read()
    f.close()
    print(memo)
# 실행 -> C:\Python>python Notepad.py

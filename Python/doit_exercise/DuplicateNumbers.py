# 0~9까지의 문자로된 숫자를 입력받아 숫자가 각각 한 번씩만 사용된 것인지 확인하는 함수
# 입력 : 0123456789 01234 01234567890 6789012345 012322456789
# 출력 : true false false true false
def chkDupNum(s):
    result = []
    for num in s:
        if num not in result:
            result.append(num)
        else:
            return False
    return len(result) == 10
print(chkDupNum("0123456789"))
print(chkDupNum("01234"))
print(chkDupNum("01234567890"))
print(chkDupNum("6789012345"))
print(chkDupNum("012322456789"))

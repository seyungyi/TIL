# 문자열 압축하기
# 입력받아 같은 문자가 연속적으로 반복될 경우 반복 횟수를 표시해 문자열을 압축해 표시
# 입력 : aaabbcccccca
# 출력 : a3b2c6a1
def compress_string(s):
    _c = ""
    cnt = 0
    result = ""
    for c in s:
        if c != _c:
            _c = c
            if cnt: result += str(cnt)
            result += c
            cnt = 1
        else:
            cnt += 1
    if cnt: result += str(cnt)
    return result

print(compress_string("aaabbcccccca"))
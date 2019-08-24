# 함수 이름 : getTotalPage
# 입력 받는 값 : 게시물 총 건수(m), 한 페이지에 보여줄 게시물 수(n)
# 출력하는 값 : 총 페이지 수 = 총 건수 / 한 페이지당 보여줄 건수 + 1

def getTotalPage(m, n):
    if m % n == 0:
        return m // n
    else:
        return m // n + 1

print(getTotalPage(5, 10))
print(getTotalPage(15, 10))
print(getTotalPage(25, 10))
print(getTotalPage(30, 10))

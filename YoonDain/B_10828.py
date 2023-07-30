import sys
input = sys.stdin.readline # 줄 읽기 (타임에러방지)
n = int(input()) # 명령의 개수
stack = [] # 스택을 담을 배열

for _ in range(n): #명령 개수만큼 for iter
    x = list(map(str,input().split())) # 명령, 숫자 로 map을 사용하여 split

    if x[0] =='push':
        stack.append(int(x[1]))
    elif x[0] =='pop':
        if stack: # stack이 있다면
            print(stack.pop()) # pop
        else:
            print('-1') # 없으면 -1 리턴
            
    elif x[0] =='size':
        print(len(stack))
    elif x[0] =='empty':
        if stack:
            print('0')
        else:
            print('1')
    elif x[0] =='top':
        if stack:
            print(stack[-1])
        else:
            print('-1')
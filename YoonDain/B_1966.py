from collections import deque

def find_print_order(documents, M):

    # (인덱스, 중요도)를 담는 큐
    queue = deque([(i, importance) for i, importance in enumerate(documents)])  
    # list 로 선언해서 큐를 만듦
    
    # 출력 순서 및 return 값
    order = 0

    while queue: # queue에 있을 때 
        idx, importance = queue.popleft() # 맨 앞 값 뽑기

        # 현재 문서보다 중요도가 높은 문서가 있는 경우는
        if any(importance < imp for _, imp in queue):
            # 지금 queue 형식이 (i,importance) 이므로 _ 로 i 의 역할 수행
            queue.append((idx, importance))  # 맨 뒤로 보낸다
        # 아닐 경우는 
        else:
            order += 1  # 출력 순서를 증가시킨다
            if idx == M: # 우리가 찾는 M 의 idx가 되었다면
                return order # 순서 return

if __name__ == "__main__":
    # 입력
    T = int(input())  # 테스트 케이스 개수
    for _ in range(T):
        N, M = map(int, input().split())  # 문서의 개수(N)와 찾으려는 문서의 위치(M)
        documents = list(map(int, input().split()))  # 문서들의 중요도 받기

        # 결과 출력
        print(find_print_order(documents, M))

# Test Caset
T = int(input())


# x 와 y 좌표 이동
dx = [-1,1,0,0]
dy = [0,0,-1,1]

def bfs(x,y):
    queue = [(x,y)] # 방문 큐에 넣기
    matrix[x][y] = 0 # 방문처리. 1을 0으로 바꿔서 없다고 표시

    while queue: # 큐에 있으면
        x,y = queue.pop(0) # 좌표를 뽑기

        for i in range(4): # 동서남북 위치 보기
            nx = x + dx[i]
            ny = y + dy[i]

            if nx < 0 or nx >= M or ny < 0 or ny >= N: 
                # 내부에서만 이뤄져야 함! 그냥 [N+1][M+1] 로 잡아도 되긴 할듯...? 
                continue

            if matrix[nx][ny] == 1 : # 아직 방문을 안했으면 
                queue.append((nx,ny)) # 큐에 넣기
                matrix[nx][ny] = 0 # 방문처리합시다


for _ in range(T):
    M,N,K = map(int, input().split())
    matrix = [ [0 for _ in range(N)] for _ in range(M)] # 모두 0으로 초기화
    # visited = [ [0 for _ in range(N)] for _ in range(M)] # 방문 처리 배열 0으로 초기화
    answer = 0

    # 입력받은 좌표에 1(배추) 로 초기화
    for j in range(K):
        x,y = map(int, input().split())
        matrix[x][y] = 1

    for x in range(M): 
        for y in range(N):
            # 1일 때(배추일 때) 확인
            if matrix[x][y] == 1:
                bfs(x,y)
                answer += 1 # 한번씩 돌 때마다 답을 추가하기

    # print("answer :: " + str(answer))
    print(answer)
    

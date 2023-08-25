
N = int(input()) 
board = [] # 게임 보드

# 2차원 배열
for _ in range(N) : 
    board.append(list(map(int, input().split())))


visited = [[0] * N for _ in range(N)] #방문체크, 2차원 배열 0으로 초기화
queue = [[0,0]] # 출발점은 가장 왼쪽 위 (0,0) initial

#오른쪽 & 아래 
dx = [1,0]
dy = [0,1]

#BFS
def bfs():
    while queue :
        [x, y] = queue.pop()

        # 맨 오른쪽 아래(-1) 도달하면 HaruHaru 출력
        if board[x][y] == -1 :
            return True 


        # 오른쪽이랑 아래로 이동
        for i in range(2) :
            nx = x + dx[i] * board[x][y] # 현재 짬푸값만큼 짬푸
            ny = y + dy[i] * board[x][y]

            # 1) 범위 안에 있음 2) 방문하지 않았으면
            if (0 <= nx < N and 0 <= ny < N) and (visited[nx][ny] == 0) :
                visited[nx][ny] = 1 # 방문 체크
                queue.append([nx,ny]) #  queue에 넣기
    return False

if bfs():
    print("HaruHaru")
else:
    print("Hing")

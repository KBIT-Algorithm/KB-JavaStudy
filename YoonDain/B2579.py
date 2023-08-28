N=int(input()) # 계단 개수
stair=[] # 계단 리스트
for _ in range(N): stair.append(int(input()))

dp=[0]*(N) # dp 리스트

# 초기값 입력.길ㅇ ㅣ없을 수도 있자나... 
# dp[0]=stair[0] # 첫번째 계단은 입력 값 그대로
# dp[1]=stair[0]+stair[1] # 두번째 계단 : 첫번째 + 두번째

if len(stair) == 1: # 계단이 2개 이하일땐 그냥 다 더해서 출력
    print(stair[0])
    #exit(0)
elif len(stair) == 2:
    print(stair[1]+stair[0])
    #exit(0)

else: # 계단이 3개 이상일 때
    dp[0]=stair[0] # 첫번째 계단: 입력 값 그대로
    dp[1]=stair[0]+stair[1] # 두번째 계단 : 첫번째 + 두번째

    for i in range(2,N): # 세번째 계단 부터는 점화식 이용
        dp[i] = max(dp[i-3] + stair[i-1] + stair[i], dp[i-2] + stair[i])
    print(dp[N-1]) # 가장 꼭대기
    #exit(0)

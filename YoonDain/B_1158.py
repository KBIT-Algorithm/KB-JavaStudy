def josephus(n, k):

    queue = list(range(1,n+1))  # 1, 2, ... ,n 사람이 저장
    result = []  # 제거되는 순서대로 저장, return 값

    idx = 0 # 제거되는 idx
    while queue: # queue 에 사람이 있을 때
        idx = (idx + k - 1) % len(queue)  # 제거될 사람의 인덱스 계산
        removed_person = queue.pop(idx)  # 제거될 사람을 큐에서 제거
        result.append(removed_person)    # 제거된 사람을 결과 리스트에 추가

    return result


if __name__ == "__main__":
    # 입력
    N, K = map(int, input().split())  # 사람들의 수 N과 제거될 사람의 번호 간격 K 입력
    result = josephus(N, K)        

    # 결과 출력
    print("<", end="")
    for i in range(N - 1):
        print(result[i], end=", ")
    print(result[-1], end="")
    print('>')

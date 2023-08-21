'''

조합
'''

import itertools

height_list = list(map(int, input().split()))
comb = itertools.combinations(height_list, 7) # array 에서 7명을 조합 뽑음

answer = []
for mem in comb:  
    if sum(mem) == 100:  # 그합이 100이라면
        answer = mem # 정답은 이 조합
        break # 끝

print(sorted(mem))

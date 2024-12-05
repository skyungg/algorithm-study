from collections import deque
import sys

input = sys.stdin.readline

F, S, G, U, D = map(int, input().split())   ## 건물 최고 층, 현재 위치, 회사 위치, 위로, 아래로

def bfs():
    que = deque()
    que.append(S)   ## 현재 위치
    visited = [0]*(F+1) ## 방문확인 및 횟수
    visited[S] = 1

    while que:
        x = que.popleft()

        if x == G:
            return visited[G]-1

        for i in [U, -D]:
            nx = x+i

            if 1 <= nx <= F and not visited[nx]:
                visited[nx] = visited[x]+1
                que.append(nx)
    else:
        return 'use the stairs'

print(bfs())
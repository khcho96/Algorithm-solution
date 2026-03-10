from collections import deque

T = int(input())
move = [[0,1], [1,0], [0,-1], [-1,0]]
for _ in range(T):
    m, n, k = map(int,input().split())
    mat = [[0]*m for _ in range(n)]

    for _ in range(k):
        j, i = map(int, input().split())
        mat[i][j] = 1

    visited = [[False]*m for _ in range(n)]
    q = deque()
    
    ans = 0
    for i in range(n):
        for j in range(m):
            if not visited[i][j] and mat[i][j] == 1:
                q.append((i,j))
                visited[i][j] = True
                while q:
                    cur_r, cur_c = q.popleft()
                    
                    for idx in range(4):
                        next_r, next_c = cur_r + move[idx][0], cur_c + move[idx][1]
                        if 0<=next_r<n and 0<=next_c<m and not visited[next_r][next_c] and mat[next_r][next_c] == 1:
                            q.append((next_r, next_c))
                            visited[next_r][next_c] = True
                ans += 1
    print(ans)
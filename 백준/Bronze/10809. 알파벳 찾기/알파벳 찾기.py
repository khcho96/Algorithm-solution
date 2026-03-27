str = input()
dic = {}
ans = [-1] * 26
for i in range(len(str)):
    if str[i] not in dic:
        dic[str[i]] = True
        ans[ord(str[i])-ord('a')] = i


for i in ans:
    print(i, end=" ")
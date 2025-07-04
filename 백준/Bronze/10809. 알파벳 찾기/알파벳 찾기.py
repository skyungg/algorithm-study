S = input()
alpha_list = 'abcdefghijklmnopqrstuvwxyz'

for i in alpha_list:
    if i in S:
        print(S.index(i), end = ' ')
    else:
        print(-1, end = ' ')
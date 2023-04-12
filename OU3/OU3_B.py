from keyword import kwlist
from re import sub, finditer
ref = {}
stoppord = set(kwlist)

with open('asd.txt', 'r', encoding='utf-8') as f:
    for i, line in enumerate(f, 1):
        print(f'{i} {line}', end='')
        line = sub(r'#.*$', '', line)
        for w in finditer('[\w]+', line):
            if w in stoppord:
                continue
            ref.setdefault(w, []).append(i)
for 


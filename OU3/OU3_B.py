import keyword
import re
ref = {}
stoppord = set(keyword.kwlist)

with open('asd.txt', 'r', encoding='utf-8') as f:
    for i, line in enumerate(f, start = 1):
        print(f'{i} {line}', end='')
        line = re.sub(r'#.*$', '', line)
        for w in re.finditer(r'[a-zA-ZåäöÅÄÖ]+', line):
            if w in stoppord:
                continue
            ref.setdefault(w.group(), []).append(i)

print('Referenslista:')
for (k, v) in ref.items():
    print('\t'f'{k}: {v}')
    
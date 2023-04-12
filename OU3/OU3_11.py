from re import findall

with open('asd.txt', 'r', encoding='utf-8') as f:
    words = findall(r'[a-zA-ZåäöÅÄÖ]+', f.read())

freq = dict()
for word in words:
    if word in freq:
        freq[word] += 1
    else:
        freq[word] = 1
print(f'Antalet ord i texten: {sum(freq.values())}')
print(f'Antalet unika ord: {len(freq.items())}')
print(f'3 vanligaste orden: {sorted(freq.items(), key=lambda x: x[1], reverse=True)[:3]}')
print(f'3 minst vanliga orden: {sorted(freq.items(), key=lambda x: x[1])[:3]}')
print(sorted(freq.items(), key=lambda x: x[1], reverse=True))

import csv
import matplotlib.pyplot as plt

def load_csv(filename): 
    d = {}
    with open(filename, 'r', encoding='utf-8') as f:
        reader = csv.reader(f)
        header = next(reader)
        d = {row[1].lower(): [float(s) for s in row[3:]] for row in reader}
    return d    

Landskoder_CO2 = load_csv('CO2Emissions_filtered.csv')

for i, (k, v) in enumerate(Landskoder_CO2.items()):
    print(
        f'index: \t{i}\n' \
        f'countrycode: \t{k}\n' \
        f'CO2 emissions: \t{v}\n'
    )
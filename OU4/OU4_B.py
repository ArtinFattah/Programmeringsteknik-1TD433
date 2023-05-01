import matplotlib.pyplot as plt
import csv

def load_csv(filename): 
    d = {}
    with open(filename, 'r', encoding='utf-8') as f:
        reader = csv.reader(f)
        header = next(reader)
        d = {row[1].lower(): [float(s) for s in row[3:]] for row in reader}
    return d

def smooth_a(lst):
    pass
  
countries = ['dnk','fin','isl','nor','swe']
years = list(range(1960,2014))

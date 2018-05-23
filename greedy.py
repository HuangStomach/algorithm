states = set(['mt', 'wa', 'or', 'id', 'nv', 'ut', 'ca', 'az'])

stations = {}
stations['one'] = set(['id', 'nv', 'ut'])
stations['two'] = set(['wa', 'id', 'mt'])
stations['three'] = set(['or', 'nv', 'ca'])
stations['four'] = set(['nv', 'ut'])
stations['five'] = set(['ca', 'az'])

final_stations = set()

while states:
    best = None
    covered = set()
    for name, items in stations.items():
        mixed = states & items
        if len(mixed) > len(covered):
            best = name
            covered = mixed
    
    states -= covered
    final_stations.add(best)

print(final_stations)

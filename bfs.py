#breadth-first search
from collections import deque

graph = {}
graph['you'] = ['alice', 'bob', 'claire']
graph['bob'] = ['anuj', 'peggy']
graph['alice'] = ['peggy']
graph['claire'] = ['thom', 'jonny']
graph['anuj'] = ['thor', 'stark']
graph['peggy'] = []
graph['thom'] = ['hulk', 'steven']
graph['jonny'] = ['thanos']
graph['thanos'] = []
graph['hulk'] = []
graph['steven'] = []
graph['thor'] = []
graph['stark'] = []

queue = deque()
queue += graph['you']

marked = []

while queue:
    print('I am trying')
    person = queue.popleft()
    if person not in marked:
        if person == 'thanos':
            print('thanos is your friend!')
            break
        else:
            marked.append(person)
            queue += graph[person]

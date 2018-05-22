graph = {}
graph['start'] = {}
graph['start']['a'] = 5
graph['start']['b'] = 2
graph['a'] = {}
graph['a']['c'] = 4
graph['a']['d'] = 2
graph['b'] = {}
graph['b']['a'] = 8
graph['b']['d'] = 7
graph['c'] = {}
graph['c']['d'] = 6
graph['c']['fin'] = 3
graph['d'] = {}
graph['d']['fin'] = 1
graph['fin'] = {}

inf = float('inf')
costs = {}
costs['a'] = 5
costs['b'] = 2
costs['c'] = inf
costs['d'] = inf
costs['fin'] = inf

parents = {}
parents['a'] = 'start'
parents['b'] = 'start'
parents['c'] = None
parents['d'] = None
parents['find'] = None

processed = []

def lowest(costs):
    lowest_cost = float('inf')
    lowest_node = None
    for node in costs:
        cost = costs[node]
        if cost < lowest_cost and node not in processed:
            lowest_cost = cost
            lowest_node = node
    return lowest_node

node = lowest(costs)
while node is not None:
    cost = costs[node]
    neighbors = graph[node]
    for neighbor in neighbors.keys():
        new_cost = cost + neighbors[neighbor]
        if (costs[neighbor] > new_cost):
            costs[neighbor] = new_cost
            parents[neighbor] = node
    processed.append(node)
    node = lowest(costs)

print('去重点最短的路程是', costs['fin'])
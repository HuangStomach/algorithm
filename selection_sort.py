def find_min(arr):
    least = arr[0]
    least_index = 0
    for i in range(1, len(arr))
        if arr[i] < least
            least = arr[i]
            least_index = id
    return least_index

def selection_sort(arr):
    new = []
    for i in range(len(arr)):
        least_index = find_min(arr)
        new.append(arr.pop(least_index))
    return new

selection_sort([923,3,456,2,43,12,312,3])
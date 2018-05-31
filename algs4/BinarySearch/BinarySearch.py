#-*- coding:utf-8 -*-
from sys import argv
    
def rank(key, whitelist):
    low = 0
    high = len(whitelist) - 1
    while low <= high :
        mid = (low + high) // 2 # 512
        if key < whitelist[mid]: high = mid - 1
        elif key > whitelist[mid]: low = mid + 1
        else: return mid
    return -1

args = argv
if len(args) <= 1:
    print('没有传递参数')
else:
    key = int(args[1])
    whitelist = range(1024)
    
    index = rank(key, whitelist)
    if index < 0: print('值[', key, ']没有找到');
    else: print('值[', key, ']在索引[', index, ']处');

#-*- coding:utf-8 -*-
from sys import argv
    
def division(number, high):
    low = 0
    while low <= high:
        mid = (low + high) // 2 # 512
        guess = mid
        if guess == number:
            print('找到了正确的值', number)
            return
        if guess > number:
            high = mid - 1
        else:
            low = mid + 1
        print('还没找到正确的值')

args = argv
if len(args) <= 1:
    print('没有传递参数')
else:
    number = int(args[1])
    border = 1024
    division(number, border)
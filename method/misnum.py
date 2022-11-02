# Given an array that consists of elements from range 1 to n. One of the elements is missing from the given list. Find the missing number in the given array.
# example:
# arr=[1,3,5,2,6,4,8,9,10].
# output: the missing number is  7.

def MissingNumber(arr):
    i, sum1 = 0, 1
    n=len(arr)
    for i in range(2, n + 2):
        sum1 += i
        sum1 -= arr[i - 2]
    return sum1

if __name__=='__main__':
    arr=[ 1, 2 , 5 , 3 ]
    ans=MissingNumber(arr)
    print(ans)






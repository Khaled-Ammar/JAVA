def find_second_largest(a, n):
    a.sort()
    secondlargest = 0
    
    for i in range(n-2, -1, -1):
    
        if a[i] != a[n - 1]:
            secondlargest = a[i]
            break
    return secondlargest

if __name__ == '__main__':
    a = [3,4,5,6,100,200]
    n = len(a)
    answer = find_second_largest(a, n)
    print("The second largest num in the array is: ", answer)
import time;

#Recursion
def fib(n):
    if(n == 1 or n == 0):
        if(n == 1):
            return 1
        else:
            return 0
    else:
        return fib(n-1) + fib(n-2)

#TailRecursion
def fib_tr(n, pp, p):
    if(n == 2):
        return p
    else:
        return fib_tr(n-1, p, p + pp)

start_time = time.time()
fibs = fib(40)
end_time = time.time()
print(f"exec.time of fib(n) = {end_time - start_time}, result: {fibs}")

start_time = time.time()
fib_trs = fib_tr(40, 1, 1)
end_time = time.time()
print(f"exec.time of fib_tr(n) = {end_time - start_time}, result: {fib_trs}")

def total_steps_lee_215(A: list[int]) -> int:
    n = len(A)
    dp = [0] * n
    stack = []
    for i in range(n-1, -1, -1):
        while stack and A[i] > A[stack[-1]]:
            dp[i] = max(dp[i] + 1, dp[stack.pop()])
        stack.append(i)
    return max(dp)

def total_steps_bakerstone(A: list[int]) -> int:
    st = [[A[0], 0]]
    ans = 0

    for a in A[1:]:
        t = 0
        while st and st[-1][0] <= a:
            t = max(t, st[-1][1])
            st.pop()
        if st:
            t += 1
        else:
            t = 0
        ans = max(ans, t)
        st.append([a, t])

    return ans


# result = total_steps_lee_215([10, 1, 2, 3, 4, 5, 6, 1, 2, 3])
result = total_steps_bakerstone([10, 6, 1, 2, 3])
print(result)
func smallestRangeI(A []int, K int) int {
    aLen := len(A)
    maxI, minI := A[0], A[0]
    for i := 0; i < aLen; i++ {
        if A[i] > maxI {
            maxI = A[i]
        }
        if A[i] < minI {
            minI = A[i]
        }
    }
    dis := maxI - minI - 2 * K
    if dis < 0 {
        return 0
    }
    return dis
}
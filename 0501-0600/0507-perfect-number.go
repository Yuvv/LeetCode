import "math"

// 约数之和为本身
func checkPerfectNumber(num int) bool {
    sum := 1
    max := int(math.Sqrt(float64(num)))
    if max * max == num {
        sum += max
        max--
    }
    for i := 2; i <= max; i++ {
        if num % i == 0 {
            sum += i + num / i
        }
    }
    return sum == num
}
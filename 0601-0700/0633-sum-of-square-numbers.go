// 判断一个数是否是两个数的平方和（圆上点）
// https://leetcode.com/problems/sum-of-square-numbers/description/
func judgeSquareSum(c int) bool {
    r := int(math.Sqrt(float64(c)))
	for i:=0;i<=r;i++ {
		j := math.Sqrt(float64(c - i * i))
		if j - float64(int(j)) == 0 {
			return true
		}
	}
	return false
}
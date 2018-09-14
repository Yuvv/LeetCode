// 螺旋打印数组
// https://leetcode.com/problems/spiral-matrix/description/
func spiralOrder(matrix [][]int) []int {
    nRows := len(matrix)
	if nRows == 0 {
		return make([]int, 0)
	}
	nCols := len(matrix[0])
	result := make([]int, nRows*nCols)

	top, bottom, left, right := 0, nRows-1, 0, nCols-1
	i, j := 0, 0
	count := 0
	for count < nRows*nCols {
		for j = left; j <= right; j++ {
			result[count] = matrix[top][j]
			count++
		}
		top++
		if count >= nRows*nCols {
			break
		}

		for i = top; i <= bottom; i++ {
			result[count] = matrix[i][right]
			count++
		}
		right--
		if count >= nRows*nCols {
			break
		}

		for j = right; j >= left; j-- {
			result[count] = matrix[bottom][j]
			count++
		}
		bottom--
		if count >= nRows*nCols {
			break
		}

		for i = bottom; i >= top; i-- {
			result[count] = matrix[i][left]
			count++
		}
		left++
		if count >= nRows*nCols {
			break
		}
	}

	return result
}
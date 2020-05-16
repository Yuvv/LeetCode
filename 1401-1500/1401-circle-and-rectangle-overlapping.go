package main

import (
	"fmt"
	"math"
)

/**
 * 判断矩形和圆是否相交。
 * 以矩形中心为中心，矩形短边为半径画圆`c1`，目标圆圆心在此圆之内的肯定相交；
 * 以矩形中心为中心，对角线+目标圆半径`sqrt(a^2+b^2)/2+r`为半径画圆`c2`，目标圆心在此圆之外的肯定不相交；
 * 然后判断`c1`和`c2`之间的区域。把矩形向四个方向扩展目标圆半径的距离，在此范围内的都是相交的。
 */
func checkOverlap(radius int, x_center int, y_center int, x1 int, y1 int, x2 int, y2 int) bool {
	f_radius := float64(radius)
	f_x_center := float64(x_center)
	f_y_center := float64(y_center)
	qx_center, qy_center := float64(x2+x1)/2.0, float64(y2+y1)/2.0
	qx_half, qy_half := float64(x2-x1)/2.0, float64(y2-y1)/2.0
	// 中心距离的平方
	center_distence_pow2 := math.Pow(f_x_center-qx_center, 2) + math.Pow(f_y_center-qy_center, 2)
	// 短边距离的平方
	short_line_distence_pow2 := math.Pow(math.Min(qx_half, qy_half), 2)
	// 最长距离的平方
	diaganol_distence_pow2 := math.Pow(qx_half, 2) + math.Pow(qy_half, 2)
	diaganol_radius_distence_pow2 := math.Pow(math.Sqrt(diaganol_distence_pow2)+f_radius, 2)
	if center_distence_pow2 <= short_line_distence_pow2 {
		return true
	} else if center_distence_pow2 > diaganol_radius_distence_pow2 {
		return false
	} else {
		if math.Abs(f_x_center-qx_center) > qx_half+f_radius {
			return false
		} else if math.Abs(f_y_center-qy_center) > qy_half+f_radius {
			return false
		}
		return true
	}
}

func main() {
	// true
	fmt.Println(checkOverlap(1, 0, 0, 1, -1, 3, 1))
	// true
	fmt.Println(checkOverlap(1, 0, 0, -1, 0, 0, 1))
	// true
	fmt.Println(checkOverlap(1, 1, 1, -3, -3, 3, 3))
	// false
	fmt.Println(checkOverlap(1, 1, 1, 1, -3, 2, -1))
	// false
	fmt.Println(checkOverlap(1, 5, -2, 0, 0, 10, 2))
	// true
	fmt.Println(checkOverlap(2, 8, 6, 5, 1, 10, 4))
}
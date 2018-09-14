// 求 7 进制数
// https://leetcode.com/problems/base-7/description/
func convertToBase7(num int) string {
    const base = 7
	var negative bool
	var result string
	var reminder int

    if num == 0 {
        return "0"
    }

	if num < 0 {
		negative = true
		num = -num
	}

	for num > 0 {
		reminder = num % base
		num /= base
		result = string(reminder + '0') + result
	}
	if negative {
		return "-" + result
	}
	return result
}
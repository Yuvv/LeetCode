const INT_MIN = -2147483648
const INT_MAX = 2147483647
const INT_MAX2 = 2147483647

// 字符串转为数字
// https://leetcode.com/problems/reverse-integer/description/
func myAtoi(str string) int {
    result := 0
    strLen := len(str)
    var sign byte = '+'
    i := 0
    for i < strLen && str[i] == ' ' {
        i++
    }
    if i < strLen && (str[i] == '-' || str[i] == '+') {
        sign = str[i]
        i++
    }
    for ; i < strLen; i++ {
        if str[i] >= '0' && str[i] <= '9' {
            result = result * 10 + int(str[i] - '0')
            if result > INT_MAX2 {
                break
            }
        } else {
            break
        }
    }
    if sign == '-' {
        result = -result
    }
    if result < INT_MIN {
        return INT_MIN
    }
    if result > INT_MAX {
        return INT_MAX
    }
    return result
}
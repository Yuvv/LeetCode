// 判断括号是否合法
// 贪心法，求左括号最大可能值和最小可能值，然后与右括号匹配
// https://leetcode.com/problems/valid-parenthesis-string/description/
func checkValidString(s string) bool {
    low := 0
    high := 0
    for i := 0; i < len(s); i++ {
        if s[i] == '(' {
            low += 1
        } else {
            low -= 1
        }
        if s[i] != ')' {
            high += 1
        } else {
            high -= 1
        }
        if high < 0 {
            break
        }
        if low < 0 {
            low = 0
        }
    }
    return low == 0
}
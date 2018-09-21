const BASE = 26

// excel 列数计算
// https://leetcode.com/problems/excel-sheet-column-title/description/
func convertToTitle(n int) string {
    var result string
    var remainder int
    for n > 0 {
        n--
        remainder = n % BASE
        n /= BASE
        result = string('A' + remainder) + result
    }
    return result
}
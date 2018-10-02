// 两个字符串，找出多余的字母
// 建立一个数组，找就行了
func findTheDifference(s string, t string) byte {
    sLen := len(s)
	arr := make([]byte, 128)
	for i := 0; i < sLen; i++ {
		arr[s[i]] = 1 - arr[s[i]]
		arr[t[i]] = 1 - arr[t[i]]
	}
	arr[t[sLen]] = 1 - arr[t[sLen]]

	var i byte
	for i = 0; i < 128; i++ {
		if arr[i] != 0 {
			return i
		}
	}
	return 0
}
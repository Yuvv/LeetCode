func wordPattern(pattern string, str string) bool {
    m := map[string]uint8{}
	set := map[uint8]bool{}
	fields := strings.Fields(str)
	pLen, sLen := len(pattern), len(fields)
	if pLen != sLen {
		return false
	}
	for i := 0; i < sLen; i++ {
		p, ok := m[fields[i]]
		if ok {
			if p != pattern[i] {
				return false
			}
		} else {
			_, ok := set[pattern[i]]
			if ok {
				return false
			}
			m[fields[i]] = pattern[i]
			set[pattern[i]] = true
		}
	}
	return true
}
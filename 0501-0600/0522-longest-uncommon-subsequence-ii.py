#!/usr/bin/env python3
# -*- coding: utf-8 -*-

# @File   : 0522-longest-uncommon-subsequence-ii.py
# @Date   : 2021/07/12
# @Author : Yuvv <yuvv_th@outlook.com>

from typing import List


class Solution:
    def findLUSlength(self, strs: List[str]) -> int:
        strs_len = len(strs)
        mx_len = -1
        for i, cur_s in enumerate(strs):
            if len(cur_s) > mx_len:
                for j in range(strs_len):
                    if i != j and self.is_sub(cur_s, strs[j]):
                        break
                else:
                    mx_len = len(cur_s)

        return mx_len

    def is_sub(self, s1: str, s2: str) -> bool:
        i, j = 0, 0
        while i < len(s1) and j < len(s2):
            if s1[i] == s2[j]:
                i += 1
            j += 1
        return i == len(s1)


if __name__ == '__main__':
    s = Solution()
    # 3
    print(s.findLUSlength(['aba', 'cdc', 'eae']))
    # -1
    print(s.findLUSlength(['aaa', 'aaa', 'aa']))
'''
class Solution {
	public int findLUSlength(String[] s) {
		int maxLength=-1, n=s.length;
		for(int i=0;i<n;i++){
			if(s[i].length()>maxLength){
				int j=-1;
				while(++j<n)    if(i!=j && !isMyAns(s[i],s[j]))   break;

				if(j==n)    maxLength=s[i].length();
			}
		}
		return maxLength;
	}
	private static boolean isMyAns(String str,String s1){
		int i1=0,i2=0;
		while(i1<str.length() && i2<s1.length()){
			if(str.charAt(i1)==s1.charAt(i2++))	i1++;
		}
		return i1!=str.length();
	}
}
'''
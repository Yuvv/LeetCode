#!/usr/bin/env python3
# -*- coding: utf-8 -*-

# @File   : 0811-subdomain-visit-count.py
# @Date   : 2021/03/16
# @Author : Yuvv <yuvv_th@outlook.com>

from typing import List


class Solution:
    def subdomainVisits(self, cpdomains: List[str]) -> List[str]:
        rd = dict()
        for each in cpdomains:
            s_num, domain = each.split(' ')
            num = int(s_num)

            idx = 0
            while idx >= 0:
                subs = domain[idx:]
                rd[subs] = rd.get(subs, 0) + num

                idx = domain.find('.', idx)
                if idx >= 0:
                    idx += 1

        return [f'{e[1]} {e[0]}' for e in rd.items()]


if __name__ == '__main__':
    s = Solution()
    # ["9001 discuss.leetcode.com", "9001 leetcode.com", "9001 com"]
    print(s.subdomainVisits(['900 discuss.leetcode.com']))
    # ["901 mail.com","50 yahoo.com","900 google.mail.com","5 wiki.org","5 org","1 intel.mail.com","951 com"]
    print(s.subdomainVisits(["900 google.mail.com", "50 yahoo.com", "1 intel.mail.com", "5 wiki.org"]))

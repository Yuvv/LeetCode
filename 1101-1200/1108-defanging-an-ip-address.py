#!/usr/bin/env python3
# -*- coding: utf-8 -*-

# @File   : 1108-defanging-an-ip-address.py
# @Date   : 2021/03/16
# @Author : Yuvv <yuvv_th@outlook.com>


class Solution:
    def defangIPaddr(self, address: str) -> str:
        return address.replace('.', '[.]')


if __name__ == '__main__':
    s = Solution()
    # "1[.]1[.]1[.]1"
    print(s.defangIPaddr('1.1.1.1'))

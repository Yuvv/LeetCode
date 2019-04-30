import binascii
import hashlib

class Codec:
    """
    https://leetcode.com/problems/encode-and-decode-tinyurl/
    编码/解码 url
    """
    def __init__(self):
        self.urls = {}
        self.salt = 'Ax97'

    def encode(self, longUrl):
        """Encodes a URL to a shortened URL.

        :type longUrl: str
        :rtype: str
        """
        crc32_sum = binascii.crc32((self.salt + longUrl).encode())
        self.urls[crc32_sum] = longUrl
        return crc32_sum

    def decode(self, shortUrl):
        """Decodes a shortened URL to its original URL.

        :type shortUrl: str
        :rtype: str
        """
        return self.urls.get(shortUrl)


if __name__ == "__main__":
    codec = Codec()
    e = codec.encode('https://leetcode.com/problems/design-tinyurl')
    print(e)
    print(codec.decode(e))

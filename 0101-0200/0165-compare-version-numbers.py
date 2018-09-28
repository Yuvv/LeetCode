class Solution:
    def compareVersion(self, version1, version2):
        """
        :type version1: str
        :type version2: str
        :rtype: int
        """
        version1 = list(map(int, version1.split('.')))
        version2 = list(map(int, version2.split('.')))
        if len(version1) > len(version2):
            version2.extend([0] * (len(version1) - len(version2)))
        elif len(version2) > len(version1):
            version1.extend([0] * (len(version2) - len(version1)))

        for i in range(len(version1)):
            if version1[i] > version2[i]:
                return 1
            elif version2[i] > version1[i]:
                return -1
        return 0
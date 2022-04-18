/*
 * 1886-determine-whether-matrix-can-be-obtained-by-rotation.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2022/04/18
 */
public class Solution {
    public boolean findRotation(int[][] mat, int[][] target) {
        boolean isOk = true;
        // 90-degree
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat.length; j++) {
                if (mat[i][j] != target[j][mat.length - 1 - i]) {
                    isOk = false;
                    break;
                }
            }
            if (!isOk) {
                break;
            }
        }
        if (!isOk) {
            // 180-degree
            isOk = true;
            for (int i = 0; i < mat.length; i++) {
                for (int j = 0; j < mat.length; j++) {
                    if (mat[i][j] != target[mat.length - 1 - i][mat.length - 1 - j]) {
                        isOk = false;
                        break;
                    }
                }
                if (!isOk) {
                    break;
                }
            }
            if (!isOk) {
                // 270-degree
                isOk = true;
                for (int i = 0; i < mat.length; i++) {
                    for (int j = 0; j < mat.length; j++) {
                        if (mat[i][j] != target[mat.length - 1 - j][i]) {
                            isOk = false;
                            break;
                        }
                    }
                    if (!isOk) {
                        break;
                    }
                }
                if (!isOk) {
                    // 360-degree
                    isOk = true;
                    for (int i = 0; i < mat.length; i++) {
                        for (int j = 0; j < mat.length; j++) {
                            if (mat[i][j] != target[i][j]) {
                                isOk = false;
                                break;
                            }
                        }
                        if (!isOk) {
                            break;
                        }
                    }
                }
            }
        }
        return isOk;
    }
}
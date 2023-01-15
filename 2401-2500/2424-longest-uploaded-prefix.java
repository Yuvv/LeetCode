/*
 * 2424-longest-uploaded-prefix.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2023/01/15
 */
public class LUPrefix {
    private boolean[] vUploaded;
    private int longest;

    public LUPrefix(int n) {
        vUploaded = new boolean[n+1];
        longest = 0;
        vUploaded[0] = true;
    }

    public void upload(int video) {
        vUploaded[video] = true;
        if (video == longest+1) {
            for (int i = longest+1; i < vUploaded.length; i++) {
                if (vUploaded[i]) {
                    longest = i;
                } else {
                    break;
                }
            }
        }
    }

    public int longest() {
        return longest;
    }

    public static void main(String[] args) {
        LUPrefix server = new LUPrefix(4);   // Initialize a stream of 4 videos.
        server.upload(3);                    // Upload video 3.
        server.longest();                    // Since video 1 has not been uploaded yet, there is no prefix.
                                             // So, we return 0.
        server.upload(1);                    // Upload video 1.
        server.longest();                    // The prefix [1] is the longest uploaded prefix, so we return 1.
        server.upload(2);                    // Upload video 2.
        server.longest();                    // The prefix [1,2,3] is the longest uploaded prefix, so we return 3.
    }
}
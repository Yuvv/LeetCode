import java.util.*;
import java.util.stream.*;

/*
 * 0899-orderly-queue.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2022/11/06
 */
public class Solution {
    public String orderlyQueue(String s, int k) {
        if (k == 1) {
            LinkedList<Character> list = new LinkedList<>();
            for (int i = 0; i < s.length(); i++) {
                list.addLast(s.charAt(i));
            }
            String candidate = s;
            for (int i = 1; i < s.length(); i++) {
                list.addLast(list.pollFirst());
                int j = 0;
                Iterator<Character> it = list.iterator();
                while (it.hasNext()) {
                    char a = it.next().charValue();
                    char b = candidate.charAt(j);
                    if (a < b) {
                        candidate = list.stream().map(Object::toString).collect(Collectors.joining(""));
                        break;
                    } else if (a > b) {
                        break;
                    }
                    j++;
                }
            }
            return candidate;
        } else {
            char[] arr = s.toCharArray();
            Arrays.sort(arr);
            return new String(arr);
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // "acb"
        System.out.println(s.orderlyQueue("cba", 1));
        // "aaabc"
        System.out.println(s.orderlyQueue("baaca", 3));
        // "asrgluefohptlsulrkgnztduowlpnrncjocfudpgdgewxcqjodtotgteuayockhwzfyxxfocfgcqjvodtnhiazwrlzohhbzpjpcu"
        System.out.println(s.orderlyQueue(
            "euayockhwzfyxxfocfgcqjvodtnhiazwrlzohhbzpjpcuasrgluefohptlsulrkgnztduowlpnrncjocfudpgdgewxcqjodtotgt",
            1
        ));
        // "adrjznrdmtvfkmlmhvxjqjpsnrtvefnnvnxunvmillqbszlbfcguawyeezjvazapyvivkmjjpustanjfxfeerpnpywxbxaqynkixyqsidzrhzpixcuecgspkeytrvucuvtmrctguqnnbbauddkzxivckpzbkxapndcxdxmlikjoivggmyasaktllgmfhqpyznchnryeawutmrkekuuyxrnseysplqqxoflgxvofbdlrfrwtlqzxireojllrvmdttykmoxsafwpwkfazdqmjnczmaktittgzawndgphvfjnivgceqobzmisalrztxdlahjijuevoioemawiizpkubonwpmnujoszszkptjgzjzwfvzhrucvisyaphcsznjlknkczzeglsavqhwriozbswsdpukpgivmldjngvjgivxyatndghkmybswjgfhdogagvkwygowpegzhwutsuwbenfnmdcavczztlhkiksxegfbwnbllutdqn"
        System.out.println(s.orderlyQueue(
            "ndcxdxmlikjoivggmyasaktllgmfhqpyznchnryeawutmrkekuuyxrnseysplqqxoflgxvofbdlrfrwtlqzxireojllrvmdttykmoxsafwpwkfazdqmjnczmaktittgzawndgphvfjnivgceqobzmisalrztxdlahjijuevoioemawiizpkubonwpmnujoszszkptjgzjzwfvzhrucvisyaphcsznjlknkczzeglsavqhwriozbswsdpukpgivmldjngvjgivxyatndghkmybswjgfhdogagvkwygowpegzhwutsuwbenfnmdcavczztlhkiksxegfbwnbllutdqnadrjznrdmtvfkmlmhvxjqjpsnrtvefnnvnxunvmillqbszlbfcguawyeezjvazapyvivkmjjpustanjfxfeerpnpywxbxaqynkixyqsidzrhzpixcuecgspkeytrvucuvtmrctguqnnbbauddkzxivckpzbkxap",
            1
        ));
    }
}

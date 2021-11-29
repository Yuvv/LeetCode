import java.util.*;
import java.util.stream.Collectors;

/*
 * 0721-accounts-merge.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2021/11/29
 */
public class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<String, String> emailMap = new HashMap<>();
        Map<String, Set<String>> resMap = new HashMap<>();
        for (int i  = 0; i < accounts.size(); i++) {
            List<String> info = accounts.get(i);
            String idxName = info.get(0) + "_" + i;
            Set<String> toMergeName = new HashSet<>();
            for (int j = 1; j < info.size(); j++) {
                if (emailMap.containsKey(info.get(j))) {
                    toMergeName.add(emailMap.get(info.get(j)));
                } else {
                    emailMap.put(info.get(j), idxName);
                }
            }
            Set<String> emails = new TreeSet<>(info.subList(1, info.size()));
            for (String name : toMergeName) {
                Set<String> oldEmails = resMap.remove(name);
                emails.addAll(oldEmails);
                for (String oe : oldEmails) {
                    emailMap.put(oe, idxName);
                }
            }
            resMap.put(idxName, emails);
        }
        return resMap.entrySet().stream()
                .map(e -> {
                    int idx = e.getKey().lastIndexOf("_");
                    List<String> lst = new ArrayList<>();
                    lst.add(e.getKey().substring(0, idx));
                    lst.addAll(e.getValue());
                    return lst;
                }).collect(Collectors.toList());
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // [["John","john00@mail.com","john_newyork@mail.com","johnsmith@mail.com"],
        //  ["Mary","mary@mail.com"],
        //  ["John","johnnybravo@mail.com"]]
        System.out.println(s.accountsMerge(Arrays.asList(
            Arrays.asList("John", "johnsmith@mail.com", "john_newyork@mail.com"),
            Arrays.asList("John", "johnsmith@mail.com", "john00@mail.com"),
            Arrays.asList("Mary", "mary@mail.com"),
            Arrays.asList("John", "johnnybravo@mail.com")
        )));

    }
}
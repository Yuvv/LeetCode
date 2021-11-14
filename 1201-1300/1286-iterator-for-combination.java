import java.util.Objects;
import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;

/*
 * 1286-iterator-for-combination.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2021/11/14
 */
class CombinationIterator {

    private int pos;
    private List<String> combinations;

    public CombinationIterator(String characters, int combinationLength) {
        List<List<Character>> result = new ArrayList<>();
        result.add(new ArrayList<>(0));

        // iteration
        for (int i = 0; i < characters.length(); i++) {
            char ch = characters.charAt(i);
            int lastSize = result.size();
            for (int j = 0; j < lastSize; j++) {
                List<Character> thatList = result.get(j);
                if (thatList.size() >= combinationLength) {
                    continue;
                }
                List<Character> curList = new ArrayList<>(thatList);
                curList.add(ch);
                result.add(curList);
            }
        }

        this.combinations = result.stream()
                .filter(l -> l.size() == combinationLength)
                .map(l -> l.stream().map(Objects::toString).collect(Collectors.joining()))
                .sorted()
                .collect(Collectors.toList());
        this.pos = 0;
    }

    public String next() {
        return this.combinations.get(pos++);
    }

    public boolean hasNext() {
        return this.pos < this.combinations.size();
    }


}

public class Solution {
    public static void main(String[] args) {
        CombinationIterator obj = new CombinationIterator("abc", 2);
        // ab
        System.out.println(obj.next());
        // true
        System.out.println(obj.hasNext());
        // ac
        System.out.println(obj.next());
        // true
        System.out.println(obj.hasNext());
        // bc
        System.out.println(obj.next());
        // false
        System.out.println(obj.hasNext());
    }
}

/**
 * Your CombinationIterator object will be instantiated and called as such:
 * CombinationIterator obj = new CombinationIterator(characters, combinationLength);
 * String param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
import java.util.*;

/*
 * 1656-design-an-ordered-stream.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2021/03/28
 */
class OrderedStream {

    private List<String> orderedValues;
    private int index;
    public OrderedStream(int n) {
        index = 0;
        orderedValues = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            orderedValues.add(null);
        }
    }

    public List<String> insert(int idKey, String value) {
        int i = idKey - 1;
        int size = orderedValues.size();
        List<String> result = new ArrayList<>();
        if (i < size && i >= 0) {
            orderedValues.set(i, value);
        }

        String v = null;
        while (index < size) {
            v = orderedValues.get(index);
            if (v != null) {
                index++;
                result.add(v);
            } else {
                break;
            }
        }
        return result;
    }
}

/**
 * Your OrderedStream object will be instantiated and called as such:
 * OrderedStream obj = new OrderedStream(n);
 * List<String> param_1 = obj.insert(idKey,value);
 */
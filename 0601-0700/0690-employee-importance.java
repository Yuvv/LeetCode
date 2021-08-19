import java.util.*;
import java.util.function.*;
import java.util.stream.*;

/*
// Definition for Employee.
*/
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;

    public Employee(int id, int importance, List<Integer> subord) {
        this.id = id;
        this.importance = importance;
        this.subordinates = subord;
    }
    public Employee(int id, int importance) {
        this(id, importance, Collections.emptyList());
    }
};

/*
 * 0690-employee-importance.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2021/08/19
 */
public class Solution {
    public int getImportance(List<Employee> employees, int id) {
        Map<Integer, Employee> employeeMap = employees.stream()
            .collect(Collectors.toMap(e -> e.id, Function.identity()));
        int total = 0;
        LinkedList<Integer> toSolveIds = new LinkedList<>();
        toSolveIds.add(id);
        while (toSolveIds.size() > 0) {
            Integer toSolveId = toSolveIds.pop();
            Employee employee = employeeMap.get(toSolveId);
            total += employee.importance;
            if (employee.subordinates != null) {
                toSolveIds.addAll(employee.subordinates);
            }
        }
        return total;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 11
        System.out.println(s.getImportance(
            Arrays.asList(new Employee(1, 5, Arrays.asList(2, 3)), new Employee(2, 3), new Employee(3, 3)),
            1
            ));
    }
}
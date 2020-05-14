package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.junit.Assert;
import org.junit.Test;

public class _1088_Confusing_Number_II {

    @Test
    public void test() {
        _1088_Confusing_Number_II q = new _1088_Confusing_Number_II();
        Assert.assertEquals(389627, q.confusingNumberII(100000000));
    }

    List<Integer> list = List.of(0, 1, 6, 8, 9);

    Map<Character, Character> mapping = Map.of('0', '0', '1', '1', '6', '9', '8', '8', '9', '6');

    Set<Integer> set = new HashSet<>();

    int maxDigital;

    int n;

    public int confusingNumberII(int n) {
        this.n = n;
        this.maxDigital = String.valueOf(n).length();
        dfs(0, new HashSet<>());
        return set.size();
    }

    private void dfs(int currentDigit, Set<Integer> acc) {
        if (currentDigit > maxDigital) {
            return;
        }
        for (Integer integer : acc) {
            if (isConfusing(integer) && integer >= 1 && integer <= n) {
                set.add(integer);
            }
        }
        for (Integer integer : list) {
            Set<Integer> tempList = new HashSet<>();
            if (acc.isEmpty()) {
                tempList.add(integer);
            }else {
                for (Integer pre : acc) {
                    tempList.add(pre * 10 + integer);
                }
            }
            dfs(currentDigit  + 1, tempList);
        }
    }

    private boolean isConfusing(Integer integer) {
        String oldNumber = integer.toString();
        StringBuilder sb = new StringBuilder();
        for (char c : oldNumber.toCharArray()) {
            sb.append(mapping.get(c));
        }
        return !sb.reverse().toString().equals(oldNumber);
    }

}

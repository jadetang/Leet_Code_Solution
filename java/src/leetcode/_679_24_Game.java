package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import org.junit.Test;
import util.Assert;

public class _679_24_Game {

    @Test
    public void test() {
        _679_24_Game q = new _679_24_Game();
        int[] nums = new int[] {4, 1, 8, 7};
        Assert.assertTrue(q.judgePoint24(nums));
    }

    public boolean judgePoint24(int[] nums) {
        List<Double> numList = IntStream.of(nums).mapToDouble(Double::valueOf).boxed().collect(Collectors.toList());
        return help(numList);
    }

    private boolean help(List<Double> nums) {
        if (nums.size() == 1) {
            return Math.abs(nums.get(0) - 24.0) < 0.001;
        } else {
            for (int i = 0; i < nums.size(); i++) {
                for (int j = i + 1; j < nums.size(); j++) {
                    double[] n = compute(nums.get(i), nums.get(j));
                    for (double nn : n) {
                        List<Double> nextNumbers = new ArrayList<>();
                        nextNumbers.add(nn);
                        for (int k = 0; k < nums.size(); k++) {
                            if (k != i && k != j) {
                                nextNumbers.add(nums.get(k));
                            }
                        }
                        if (help(nextNumbers)) {
                            return true;
                        }
                    }
                }
            }
            return false;
        }
    }

    private double[] compute(double left, double right) {
        return new double[]{right -left, right / left, left - right, left + right, left * right, left / right};
    }

}

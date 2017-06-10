package solution;

import java.util.*;

/**
 * @author sanguan.tangsicheng on 16/7/12 下午3:24
 */
public class _350_Intersection_Of_Two_Arrays_II {

    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i = 0;
        int j = 0;
        List<Integer> buffer = new LinkedList<>();
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] == nums2[j]) {
                buffer.add(nums1[i]);
                j++;
                i++;
            } else if (nums1[i] < nums2[j]) {
                i++;
            } else {
                j++;
            }
        }
        int[] result = new int[buffer.size()];
        int index = 0;
        for (Integer num : buffer) {
            result[index++] = num;
        }
        return result;
    }

    public static void main(String[] args) {
        _350_Intersection_Of_Two_Arrays_II q = new _350_Intersection_Of_Two_Arrays_II();
        int[] nums1 = new int[]{1};
        int[] nums2 = new int[]{1};
        q.intersect(nums1,nums2);
    }
}

package solution;

import java.util.*;

/**
 * @author sanguan.tangsicheng on 16/7/12 上午10:46
 */
public class _349_Intersection_Of_Two_Arrays {

    public int[] intersection(int[] nums1, int[] nums2) {

        Set<Integer> set1 = toSets(nums1);
        Set<Integer> set2 = toSets(nums2);
        Iterator<Integer> it = set1.iterator();
        while (it.hasNext()){
            Integer i = it.next();
            if( !set2.contains(i)){
                it.remove();
            }
        }
        return toArray(set1);
    }

    private int[] toArray(Set<Integer> set1) {
        int[] result = new int[set1.size()];
        int index = 0;
        for (Integer i : set1) {
            result[index++] = i;
        }
        return result;
    }

    private Set<Integer> toSets(int[] nums){
        Set<Integer> set = new HashSet<>();
        for (int i : nums) {
            set.add(i);
        }
        return set;
    }

    public static void main(String[] args) {
        _349_Intersection_Of_Two_Arrays q = new _349_Intersection_Of_Two_Arrays();
        int[] nums1 = new int[]{2,1};
        int[] nums2 = new int[]{1,2};
        q.intersection(nums1,nums2);
    }

}

package solution;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @author sanguan.tangsicheng on 16/7/11 下午5:04
 */
public class _373_Find_K_Pairs_with_Smallest_Sums {

    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<Pair> heap = new PriorityQueue<>(k);
        for (int x : nums1) {
            for (int y : nums2) {
                heap.add(new Pair(x, y));
            }
        }
        List<int[]> result = new LinkedList<>();
        int i = 0;
        while (result.size() < k && !heap.isEmpty()) {
            Pair pair = heap.poll();
            result.add(new int[] { pair.first, pair.second });
        }
        return result;
    }

    public List<int[]> kSmallestPairs2(int[] nums1, int[] nums2, int k) {
        Collections.emptyList();
        int i = 0, j = 0;
        List<int[]> result = new LinkedList<>();
        while (result.size() < k && i < nums1.length - 1 && j < nums2.length - 1) {
            result.add(new int[] { nums1[i], nums2[j] });
            if (nums1[i + 1] < nums2[j + 1]) {
                i++;
            } else {
                j++;
            }
        }
        if (result.size() == k) {
            return result;
        } else {
            if (i == nums1.length - 1) {
                for (int index = j; result.size() < k && index < nums2.length; index++) {
                    result.add(new int[] { nums1[i], nums2[index] });
                }
            } else {
                for (int index = i; result.size() < k && index < nums1.length; index++) {
                    result.add(new int[] { nums1[index], nums2[j] });
                }
            }

        }
        return result;
    }


    public List<int[]> kSmallestPairs3(int[] nums1, int[] nums2, int k) {

        int i = 0;
        int j = 0;

        List<int[]> result = new LinkedList<>();
        for (; i < nums1.length && j < nums2.length && result.size() < k ;) {
            result.add(new int[]{nums1[i],nums2[j]});
            if ( i == nums1.length - 1 || j == nums1.length - 1){
                break;
            }else {
                if (nums1[i+1] == nums2[j+1]){
                    if ( i < j){
                        i++;
                    }else {
                        j++;
                    }
                }else if( nums1[i+1] <= nums2[j+1]){
                    i++;
                }else {
                    j++;
                }
            }
        }
        if ( result.size() == k ){
            return result;
        }else {
            if ( i == nums1.length - 1 ){
                while ( result.size() < k && j < nums2.length){
                    result.add(new int[]{nums1[i],nums2[j]});
                    j++;
                }
            }
            if ( j == nums2.length - 1){
                while (result.size() < k && i < nums1.length){
                    result.add(new int[]{nums1[i],nums2[j]});
                }
            }
        }
        return result;
    }




    public static class Pair implements Comparable<Pair> {

        public Integer first;
        public Integer second;

        public Pair(Integer first, Integer second) {
            this.first = first;
            this.second = second;
        }

        @Override public int compareTo(Pair that) {
            return this.value().compareTo(that.value());
        }

        public Integer value() {
            return first + second;
        }
    }

    public static void main(String[] args) {
        _373_Find_K_Pairs_with_Smallest_Sums q = new _373_Find_K_Pairs_with_Smallest_Sums();
        int[] num1 = new int[] {1,1,2};
        int[] num2 = new int[] {1,1,2};
        List<int[]> result = q.kSmallestPairs3(num1,num2,10);
        for (int[] array
            : result
             ) {
            System.out.println("["+array[0]+","+array[1]+"]");
        }
        Integer x = 5;
    }

}

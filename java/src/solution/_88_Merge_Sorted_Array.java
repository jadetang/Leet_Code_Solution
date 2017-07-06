package solution;

/**
 * @author sanguan.tangsicheng on 2017/7/2 上午9:21
 */
public class _88_Merge_Sorted_Array {

    //从后往前插入
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;
        int j = n - 1;
        int k = m + n -1;
        while ( i>=0 && j>=0){
            if (nums1[i] > nums2[j]){
                nums1[k--] = nums1[i--];
            }else{
                nums1[k--] = nums2[j--];
            }
        }
        while ( j>=0){
            nums1[k--] = nums2[j--];
        }
    }

}
package solution;

/**
 * @author sanguan.tangsicheng on 16/9/12 下午3:48
 */
public class _26_Remove_Duplicates_from_Sorted_Array {

    public int removeDuplicates(int[] nums) {

        if (nums == null || nums.length == 0) {
            return 0;
        } else if (nums.length == 1) {
            return 1;
        } else {
            int dump = nums[0] - 1;
            int pre = nums[0];
            int duplicateCount = 0;
            for (int i = 1; i < nums.length; ) {
                if (pre == nums[i]) {
                    nums[i] = dump;
                    duplicateCount++;
                } else {
                    pre = nums[i];
                }
                i++;
            }
            int result = nums.length - duplicateCount;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == dump){
                    int j = findNextNoneDump(i+1,nums,dump);
                    if( j == -1 ){
                        break;
                    }else {
                        exchange(i,j,nums);
                    }
                }
            }
            return result;
        }
    }

    private int findNextNoneDump(int i, int[] nums, int dump) {
        if(i == nums.length ){
            return -1;
        }else {
            for (int j = i; j < nums.length; j++) {
                if (nums[j] != dump){
                    return j;
                }
            }
            return -1;
        }
    }

    private void exchange(int i, int j, int[] nums) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public int removeDuplicates2(int[] nums) {
        if (nums.length == 0) return 0;
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i]) {
                i++;
                nums[i] = nums[j];
            }
        }
        return i + 1;
    }


    public static void main(String[] args) {
        int[] array = new int[]{1,2,3,4};
        _26_Remove_Duplicates_from_Sorted_Array q = new _26_Remove_Duplicates_from_Sorted_Array();
        System.out.println(q.removeDuplicates2(array));
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }


}

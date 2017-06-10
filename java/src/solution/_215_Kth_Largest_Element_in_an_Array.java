package solution;

/**
 * @author sanguan.tangsicheng on 2016/11/23 上午8:26
 */
public class _215_Kth_Largest_Element_in_an_Array {


    public int findKthLargest(int[] nums, int k) {
        return kth(k-1,nums,0,nums.length-1);
    }

    public int kth(int k, int[] nums, int start, int end) {
        int pivot = nums[start];
        int i = start;
        int j = end;
        while (true){
            while (nums[i]>=pivot && i<end){
                i++;
            }
            while (nums[j]<pivot && j>start){
                j--;
            }
            if (i >= j){
                break;
            }
            swap(nums,i,j);
        }
        swap(nums,start,j);
        if (j == k){
            return nums[j];
        }else if (j>k){
            return kth(k,nums,start,j-1);
        }else {
            return kth(k,nums,j+1,end);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }


    public static void main(String[] args) {
        int[] nums = new int[]{3,1,2,4};
        _215_Kth_Largest_Element_in_an_Array q = new _215_Kth_Largest_Element_in_an_Array();
        System.out.println(q.findKthLargest(nums,2));
        for (int x :
                nums) {
            System.out.print(x+",");
        }
    }

}

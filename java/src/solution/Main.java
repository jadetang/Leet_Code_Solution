package solution;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        int[] r = new int[]{1,2,3,10,18};
        System.out.println(Arrays.binarySearch(r,20));
        System.out.println(Arrays.binarySearch(r,-1));
        System.out.println(Arrays.binarySearch(r,1));
        System.out.println(Arrays.binarySearch(r,6));
        System.out.println(Arrays.binarySearch(r,5));
        System.out.println(Arrays.binarySearch(r,7));
        System.out.println(Arrays.binarySearch(r,3));
    }
}

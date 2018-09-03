package other;


import java.util.Arrays;
import java.util.function.IntUnaryOperator;
import java.util.stream.IntStream;

/**
 *
 * https://www.geeksforgeeks.org/find-pythagorean-triplet-in-an-unsorted-array/
 * Given an array of integers, write a function that returns true if there is a
 * triplet (a, b, c) that satisfies a2 + b2 = c2.

 Example:

 Input: arr[] = {3, 1, 4, 6, 5}
 Output: True
 There is a Pythagorean triplet (3, 4, 5).

 Input: arr[] = {10, 4, 6, 12, 5}
 Output: False
 There is no Pythagorean triplet.

 */
public class PythagoreanTripletInAnArray {

  public static boolean triplet(int[] array){
    int[] square = IntStream.of(array).map(operand -> operand*operand).sorted().toArray();
    for (int i = 0 ; i < square.length - 1; i++){
      for (int j = i+1; j < square.length; j++){
        int x= square[i] + square[j];
        if (Arrays.binarySearch(square,x) >= 0 ){
          return true;
        }
      }
    }
    return false;
  }

  public static void main(String[] args) {
    System.out.println(triplet(new int[]{1,3,4,5,6}));
    System.out.println(triplet(new int[]{1,3,4,5,7}));
    System.out.println(triplet(new int[]{1,3,4,7}));
  }

}

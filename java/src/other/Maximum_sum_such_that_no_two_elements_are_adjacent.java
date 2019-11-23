package other;

public class Maximum_sum_such_that_no_two_elements_are_adjacent {


  int FindMaxSum(int arr[], int n) {
    int incl = arr[0];
    int excl = 0;
    int excl_new;
    int i;

    for (i = 1; i < n; i++) {
      /* current max excluding i */
      excl_new = Math.max(incl, excl);
      /* current max including i */
      incl = excl + arr[i];
      excl = excl_new;
    }

    /* return max of incl and excl */
    return Math.max(incl, excl);
  }


}

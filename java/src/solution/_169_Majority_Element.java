package solution;

/**
 * 假设有一群投票的人，每个人都会投票个某个候选人。为了选择最终赢的选取的候选人，可以采用这样的选举方式：每个投票人找到其他的投票人，并且这个投票人支持的候选不同于自己的支持的候选人，PK过后，这一对投票人同时出局。经过全部的PK
 * 之后，那么还没有出局的投票人支持的候选人，就有可能是最终的选举胜利者（获得半数以上的选票）。最后，选举主席，需要检查这位可能赢得选举的候选人的票数，来确认他是否赢得了选举。
 *
 * @author sanguan.tangsicheng on 2017/7/2 下午11:06
 */
public class _169_Majority_Element {

  public int majorityElement(int[] nums) {
    int c = -1;
    int k = 0;
    for (int i = 0; i < nums.length; i++) {
      if (k == 0) {
        c = i;
        k = 1;
      } else {
        if (nums[c] == nums[i]) {
          k++;
        } else {
          k--;
        }
      }
    }
    return nums[c];

  }

}

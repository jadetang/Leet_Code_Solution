package leetcode;

/**
 * @author jade on 2016/11/12 下午5:03
 */
public class _299_Bulls_and_Cows {

  public String getHint(String secret, String guess) {
    int bull = 0;
    int cow = 0;
    int[] hash = new int[256];
    for (char c : secret.toCharArray()) {
      hash[c]++;
    }
    for (int i = 0; i < guess.length(); i++) {
      if (guess.charAt(i) == secret.charAt(i)) {
        bull++;
        hash[guess.charAt(i)]--;
      }
    }
    for (int i = 0; i < guess.length(); i++) {
      if (hash[guess.charAt(i)] > 0 && secret.charAt(i) != guess.charAt(i)) {
        hash[guess.charAt(i)]--;
        cow++;
      }
    }
    return bull + "A" + cow + "B";
  }
}

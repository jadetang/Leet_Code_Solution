package leetcode;

/**
 * @author jade on 2016/11/17 上午7:55
 */
public class _423_Reconstruct_Original_Digits_from_English {


  public static void main(String[] args) {
    _423_Reconstruct_Original_Digits_from_English q = new _423_Reconstruct_Original_Digits_from_English();
    System.out.println(q.originalDigits("zerozero"));
  }

  public String originalDigits(String s) {
    int[] count = new int[128];
    for (char c : s.toCharArray()) {
      count[c]++;
    }
    int[] res = new int[10];
    char[] idx = {'z', 'x', 's', 'v', 'f', 'r', 'w', 'g', 'o', 'i'};
    //char[] idx = {'z', 'x', 's', 'v', 'f', 'r', 'w', 'g', 'o', 'i'};
    for (char i : idx) {
      while (count[i] > 0) {
        switch (i) {
          case 'z':
            res[0]++;
            count['z']--;
            count['e']--;
            count['r']--;
            count['o']--;
            break;   //匹配zero,这样的话,ero都要减掉一个
          case 'x':   //匹配six,减去s
            res[6]++;
            count['s']--;
            count['i']--;
            count['x']--;
            break;
          case 's':  //匹配seven,因为之前优先匹配了six,如果这个时候,还有多余的s,那么肯定是seven
            res[7]++;
            count['s']--;
            count['e']--;
            count['v']--;
            count['e']--;
            count['n']--;
            break;
          case 'v':   //匹配five,因为之前优先匹配了seven,如果这个时候还出现v,那么肯定是属于five
            res[5]++;
            count['f']--;
            count['i']--;
            count['v']--;
            count['e']--;
            break;
          case 'f':   //匹配four,因为之前匹配了four,那么这个时候还出现f,那么肯定属于four
            res[4]++;
            count['f']--;
            count['o']--;
            count['u']--;
            count['r']--;
            break;
          case 'r': //匹配three,因为之前匹配了four,还出现three,肯定属于three
            res[3]++;
            count['t']--;
            count['h']--;
            count['r']--;
            count['e']--;
            count['e']--;
            break;
          case 'w':
            res[2]++;
            count['t']--;
            count['w']--;
            count['o']--;
            break;
          case 'g':
            res[8]++;
            count['e']--;
            count['i']--;
            count['g']--;
            count['h']--;
            count['t']--;
            break;
          case 'o':
            res[1]++;
            count['o']--;
            count['n']--;
            count['e']--;
            break;
          case 'i':
            res[9]++;
            count['n']--;
            count['i']--;
            count['n']--;
            count['e']--;
            break;
          default:
            break;
        }
      }
    }
    //System.out.print(res[0]);
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i <= 9; i++) {
      for (int j = 0; j < res[i]; j++) {
        sb.append(i);
      }
    }
    return sb.toString();
  }


}

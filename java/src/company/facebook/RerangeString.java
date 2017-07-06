package company.facebook;

/**
 * @author sanguan.tangsicheng on 2017/6/27 上午7:56
 */
public class RerangeString {


    public static String rerangeString(String str){

        int[] dict = new int[26];
        int sum = 0;
        for (char c: str.toCharArray()){
            if (Character.isAlphabetic(c) && Character.isUpperCase(c)){
                dict[c-'A']++;
            }else {
                sum += (c - '0');
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < dict.length; i++) {
            int count = dict[i];
            while (count>0){
                sb.append((char)(i+'A'));
                count--;
            }
        }
        if (sum>0){
            sb.append(sum);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(rerangeString("AC2BEW3"));
    }


}

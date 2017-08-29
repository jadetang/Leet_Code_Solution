package solution;

import java.util.List;

/**
 * @author sanguan.tangsicheng on 2017/8/9 上午8:14
 */
public class _524_Longest_Word_in_Dictionary_through_Deleting {

    public String findLongestWord(String s, List<String> d) {
        d.sort((d1,d2)->{
            if(d1.length() == d2.length()){
                return d1.compareTo(d2);
            }else{
                return d1.length() - d2.length();
            }
        });
        for(String str : d){
            if( canDeleteFrom(s, str) ){
                return str;
            }
        }
        return "";
    }


    private boolean canDeleteFrom(String from, String to){
        if( from == null || to == null ){
            return false;
        }else if( to.length() == 0 ){
            return true;
        }else if( from.length() < to.length() ){
            return false;
        }else{
            char[] fromChar = from.toCharArray();
            char[] toChar = to.toCharArray();
            int i = 0;
            int j = 0;
            while( i < fromChar.length && j < toChar.length ){
                if( fromChar[i] == toChar[j] ){
                    i++;
                    j++;
                }else{
                    i++;
                }
            }
            return j == toChar.length;
        }
    }

}

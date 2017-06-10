/*
package solution;

import ds.Interval;
import ds.NestedInteger;

import java.util.Stack;

*/
/**
 * @author sanguan.tangsicheng on 2016/11/27 下午8:16
 *//*

public class _385_Mini_Parser {


    public NestedInteger deserialize(String s) {
        Stack<Integer> stack = new Stack<>();
        char[] chars = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if (c == '}'){
                break;
            }else {
                if ( c == '{'){
                    if (sb.length() > 0 ){
                        stack.push(Integer.valueOf(sb.toString()));
                        sb = new StringBuilder();
                    }
                }else {
                    sb.append(chars[i]);
                }
            }
        }
        NestedInteger n  = null;
        while ( !stack.isEmpty()){
            Integer temp = stack.pop();
            if ( n == null ){
                n = new NestedInteger(temp);
            }else {
                if ( n.isInteger()){
                    n.add(n);
                }else {

                }
            }
        }


    }
}
*/

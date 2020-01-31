package solution;

public class _1249_Minimum_Remove_to_Make_Valid_Parentheses {

    public String minRemoveToMakeValid(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        int left = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if ( c == '(') {
                left++;
                sb.append(c);
            }else if (c == ')'){
                if ( left > 0) {
                    sb.append(c);
                    left--;
                }
            }else {
                sb.append(c);
            }
        }
        if (left == 0) {
            return sb.toString();
        }else {
            s = sb.toString();
            sb = new StringBuilder();
            left = 0;
            int right = 0;
            for (int i = s.length() - 1; i >=0; i--) {
                char c = s.charAt(i);
                if ( c == ')') {
                    right++;
                    sb.append(c);
                }else if (c == '(') {
                    left++;
                    if (left <= right) {
                        sb.append(c);
                    }else {
                        left--;
                    }
                }else {
                    sb.append(c);
                }
            }
            return sb.reverse().toString();
        }
    }
}

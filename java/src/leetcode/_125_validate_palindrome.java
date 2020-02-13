package leetcode;

public class _125_validate_palindrome {

    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        if (s.length() == 0) {
            return true;
        }
        int l = 0;
        int r = s.length() - 1;
        while (l < r) {
            char lc = s.charAt(l);
            char rc = s.charAt(r);
            if (!Character.isAlphabetic(lc) && !Character.isDigit(lc)) {
                l++;
                continue;
            }
            if (!Character.isAlphabetic(rc) && !Character.isDigit(rc)) {
                r--;
                continue;
            }
            if (lc != rc) {
                return false;
            } else {
                l++;
                r--;
            }
        }
        return true;
    }
}

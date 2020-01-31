package solution;

public class _1271_Hexspeak {

    public String toHexspeak(String num) {
        long i = Long.valueOf(num);
        String decimal = Long.toHexString(i);
        StringBuilder sb = new StringBuilder();
        for (char c : decimal.toCharArray()) {
            if (c == '0') {
                sb.append('O');
            }else if (c == '1') {
                sb.append("I");
            }else if (Character.isDigit(c)) {
                return "ERROR";
            }else {
                sb.append(c);
            }
        }
        return sb.toString().toUpperCase();
    }

}

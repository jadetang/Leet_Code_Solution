package solution;

import static java.lang.Integer.toBinaryString;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<String> s = new ArrayList<>();
        s.add("x");
        s.add("y");
        s.add("z");

        //  System.out.println(Integer.toBinaryString(getMask(0)));
        //  System.out.println(Integer.toBinaryString(getMask(1)));
        //  System.out.println(Integer.toBinaryString(getMask(2)));
    }

    public static int getMask(int i) {
        int mask = 1;
        while (i > 0) {
            mask = mask << 1;
            mask += 1;
            i--;
        }
        return mask;
    }
}

package solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class _1268_Search_Suggestions_System {

    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Arrays.sort(products);
        List<List<String>> ans = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for (char c: searchWord.toCharArray()) {
            sb.append(c);
            String keyWord = sb.toString();
            int index = Arrays.binarySearch(products, keyWord);
            while (index > 0 && products[index-1].equals(keyWord)) {
                index--;
            }
            if (index < 0) {
                index = -index;
            }
            List<String> l = new ArrayList<>();
            for (int i = index; i < Math.min(products.length, index + 3); i++) {
                l.add(products[i]);
            }
            ans.add(l);
        }
        return ans;
    }
}
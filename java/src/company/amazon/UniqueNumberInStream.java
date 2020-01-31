package company.amazon;

import java.util.LinkedHashMap;
import java.util.LinkedHashSet;

public class UniqueNumberInStream {

    private LinkedHashSet<Integer> set = new LinkedHashSet<>();

    public UniqueNumberInStream() {
    }

    public void add(int n){
        if (!set.contains(n)) {
            set.add(n);
        }else {
            set.remove(n);
        }
    }

    public Integer getFirstUniqueNumber() {
        return set.size() == 0 ? null : set.iterator().next();
    }
}

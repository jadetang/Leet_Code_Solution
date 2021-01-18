package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class _1152_Analyze_User_Website_Visit_Pattern {


    public List<String> mostVisitedPattern(String[] username, int[] timestamp, String[] website) {
        List<Record> records = new ArrayList<>();
        for (int i = 0; i < username.length; i++) {
            records.add(new Record(username[i], timestamp[i], website[i]));
        }
        records.sort(Comparator.comparingInt(r -> r.timestamp));
        Map<String, List<String>> webSitesForEachUser = new HashMap<>();
        for (Record r : records) {
            webSitesForEachUser.computeIfAbsent(r.username, u -> new ArrayList<>()).add(r.website);
        }
        Map<String, Integer> count = new HashMap<>();
        int max = 0;
        String ans = "";
        for (List<String> webs : webSitesForEachUser.values()) {
            Set<String> webVisitedSequenceSet = gen(webs);
            for (String webVisitedSequence : webVisitedSequenceSet) {
                count.put(webVisitedSequence, count.getOrDefault(webVisitedSequence, 0) + 1);
                if (count.get(webVisitedSequence) > max) {
                    max = count.get(webVisitedSequence);
                    ans = webVisitedSequence;
                } else if (count.get(webVisitedSequence) == max) {
                    ans = webVisitedSequence.compareTo(ans) < 0 ? webVisitedSequence : ans;
                }
            }
        }
        return Arrays.asList(ans.split(","));
    }

    private Set<String> gen(List<String> webs) {
        Set<String> set = new HashSet<>();
        for (int i = 0; i < webs.size(); i++) {
            for (int j = i + 1; j < webs.size(); j++) {
                for (int k = j + 1; k < webs.size(); k++) {
                    set.add(webs.get(i) + "," + webs.get(j) + "," + webs.get(k));
                }
            }
        }
        return set;
    }

    public static class Record {

        public String username;
        public int timestamp;
        public String website;

        public Record(String username, int timestamp, String website) {
            this.username = username;
            this.timestamp = timestamp;
            this.website = website;
        }
    }

}

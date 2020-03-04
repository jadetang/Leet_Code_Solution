package solution;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import solution._1319_Number_of_Operations_to_Make_Network_Connected.DSU;
import tag.Array;

public class _721_Accounts_Merge {

    public static class DSU {

        int[] array;

        public DSU(int n) {
            array = new int[n];
            for (int i = 0; i < n; i++) {
                array[i] = i;
            }
        }

        public void connect(int i, int j) {
            int rooti = find(i);
            int rootj = find(j);
            if (rooti != rootj) {
                array[rootj] = rooti;
            }
        }

        public int find(int i) {
            while (i != array[i]) {
                i = array[i];
            }
            return i;
        }
    }

    public List<List<String>> accountsMerge2(List<List<String>> a) {
        Map<String,String> emailToName = buildMapping(a);
        Map<String,Integer> emailToId = buildIdMap(emailToName.keySet());
        Map<Integer, String> idToEmail = reverseMap(emailToId);
        DSU dsu = new DSU(emailToId.size());
        for (List<String> account : a) {
            for (int i = 1; i < account.size(); i++) {
                dsu.connect(emailToId.get(account.get(1)), emailToId.get(account.get(i)));
            }
        }
        Map<Integer, List<String>> groupedEmail = new HashMap<>();
        for (int i = 0; i < idToEmail.size(); i++) {
            int id = dsu.find(i);
            String email = idToEmail.get(id);
            groupedEmail.computeIfAbsent(id, key -> new ArrayList<String>()).add(email);
        }
        List<List<String>> ans = new ArrayList<>(groupedEmail.values());
        ans.forEach(Collections::sort);
        ans.forEach(emails -> emails.add(emailToName.get(emails.get(0))));
        return ans;
    }

    private Map<Integer, String> reverseMap(Map<String, Integer> emailToId) {
        Map<Integer, String> map = new HashMap<>();
        for (String email : emailToId.keySet()) {
            map.put(emailToId.get(email), email);
        }
        return map;
    }

    private Map<String, Integer> buildIdMap(Set<String> keySet) {
        Map<String, Integer> map = new HashMap<>();
        int count = 0;
        for(String s : keySet) {
            map.put(s, count++);
        }
        return map;
    }

    public List<List<String>> accountsMerge(List<List<String>> a) {
        Map<String,Set<String>> graph = buildGraph(a);
        Map<String,String> emailToName = buildMapping(a);
        List<List<String>> ans = new ArrayList<>();
        Set<String> visited = new HashSet<>();
        for (String email : emailToName.keySet()) {
            if (visited.add(email)) {
                List<String> emails = new ArrayList<>();
                dfs(graph, email, visited, emails);
                Collections.sort(emails);
                emails.add(0, emailToName.get(email));
                ans.add(emails);
            }
        }
        return ans;

    }

    private void dfs(Map<String,Set<String>> g, String email, Set<String> visited, List<String> emails) {
        emails.add(email);
        for (String e : g.get(email)) {
            if (visited.add(e)) {
                dfs(g, e, visited, emails);
            }
        }
    }

    private Map<String,String> buildMapping(List<List<String>> a) {
        Map<String,String> map = new HashMap<>();
        for (List<String> account : a) {
            String name = account.get(0);
            for (String email : account.subList(1, account.size())) {
                map.put(email, name);
            }
        }
        return map;
    }

    private Map<String,Set<String>> buildGraph(List<List<String>> a) {
        Map<String,Set<String>> g = new HashMap<>();
        for (List<String> account : a) {
            for (String email : account.subList(1, account.size())) {
                g.putIfAbsent(email, new HashSet<>());
            }
            for (int i = 1; i < account.size(); i++) {
                for (int j = i + 1; j < account.size(); j++) {
                    g.get(account.get(i)).add(account.get(j));
                    g.get(account.get(j)).add(account.get(i));
                }
            }
        }
        return g;
    }
}

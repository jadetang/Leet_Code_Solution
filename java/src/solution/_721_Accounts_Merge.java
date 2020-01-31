package solution;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class _721_Accounts_Merge {

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

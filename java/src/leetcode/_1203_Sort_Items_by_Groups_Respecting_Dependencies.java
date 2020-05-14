package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import org.junit.Assert;
import org.junit.Test;

public class _1203_Sort_Items_by_Groups_Respecting_Dependencies {

    @Test
    public void test() {
        _1203_Sort_Items_by_Groups_Respecting_Dependencies q = new _1203_Sort_Items_by_Groups_Respecting_Dependencies();
        int n = 8, m = 2;
        int[] group = new int[]{-1, -1, 1, 0, 0, 1, 0, -1};
        List<List<Integer>> beforeItems =
                List.of(Collections.emptyList(), List.of(6), List.of(5), List.of(6), List.of(3),
                        Collections.emptyList(), List.of(4), Collections.emptyList());
        Assert.assertEquals(0, q.sortItems(n, m, group, beforeItems).length);
    }


    Map<Integer, Integer> itemToGroupMapping;

    Map<Integer, Set<Integer>> groupToItemMapping;

    Map<Integer, Set<Integer>> groupDependency;


    public int[] sortItems(int n, int m, int[] group, List<List<Integer>> beforeItems) {
        itemToGroupMapping = mapItemToGroup(m, group);
        groupToItemMapping = groupToItem(itemToGroupMapping);
        groupDependency = buildDependencyBetweenGroups(beforeItems);
        List<Integer> groupList = topSort(groupDependency);
        if (groupList.size() != groupToItemMapping.size()) {
            return new int[]{};
        }
        return new int[]{-1};
    }

    private List<Integer> topSort(Map<Integer, Set<Integer>> graph) {
        Map<Integer, Integer> inDegree = new HashMap<>();
        for (int i = 0; i < groupToItemMapping.size(); i++) {
            inDegree.put(i, 0);
        }
        for (Map.Entry<Integer, Set<Integer>> entry : graph.entrySet()) {
            for (Integer node : entry.getValue()) {
                inDegree.put(node, inDegree.get(node) + 1);
            }
        }
        List<Integer> ans = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < groupToItemMapping.size(); i++) {
            if (inDegree.get(i) == 0) {
                queue.add(i);
            }
        }
        while (!queue.isEmpty()) {
            Integer node = queue.poll();
            ans.add(node);
            for (Integer nextNode : groupDependency.getOrDefault(node, new HashSet<>())) {
                inDegree.put(nextNode, inDegree.get(nextNode) - 1);
                if (inDegree.get(nextNode) == 0) {
                    queue.offer(nextNode);
                }
            }
        }
        return ans;
    }

    private Map<Integer, Set<Integer>> buildDependencyBetweenGroups(List<List<Integer>> beforeItems) {
        Map<Integer, Set<Integer>> groupDependency = new HashMap<>();
        for (int i = 0; i < beforeItems.size(); i++) {
            for (Integer beforeItem : beforeItems.get(i)) {
                groupDependency.computeIfAbsent(itemToGroupMapping.get(beforeItem), k -> new HashSet<>()).add(itemToGroupMapping.get(i));
            }
        }
        return groupDependency;
    }

    private Map<Integer, Set<Integer>> groupToItem(Map<Integer, Integer> itemToGroupMapping) {
        Map<Integer, Set<Integer>> groupToItem = new HashMap<>();
        for (Map.Entry<Integer, Integer> entry : itemToGroupMapping.entrySet()) {
            Integer item = entry.getKey();
            Integer group = entry.getValue();
            groupToItem.computeIfAbsent(group, k -> new HashSet<>()).add(item);
        }
        return groupToItem;
    }

    private Map<Integer, Integer> mapItemToGroup(int m, int[] group) {
        Map<Integer, Integer> itemToGroup = new HashMap<>();
        for (int i = 0; i < group.length; i++) {
            if (group[i] == -1) {
                itemToGroup.put(i, m++);
            } else {
                itemToGroup.put(i, group[i]);
            }
        }
        return itemToGroup;
    }

}

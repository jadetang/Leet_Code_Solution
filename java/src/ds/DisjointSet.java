package ds;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author sanguan.tangsicheng on 2016/12/4 下午7:18
 */
public class DisjointSet {

  Map<Integer, Integer> indexToParent;

  Map<Integer, Integer> size;

  public DisjointSet() {
    indexToParent = new HashMap<>();
    size = new HashMap<>();
  }

  public void add(int i) {
    if (!indexToParent.containsKey(i)) {
      indexToParent.put(i, i);
      size.put(i, 1);
    }
  }

  public boolean isConnect(int p, int q) {
    return find(p) == find(q);
  }

  public void connect(int p, int q) {
    int rootP = find(p);
    int rootQ = find(q);
    if (rootP == rootQ) {
      return;
    } else {
      if (size.get(rootP) < size.get(rootQ)) {
        indexToParent.put(rootP, rootQ);
        size.put(rootQ, size.get(rootQ) + size.get(rootP));
      } else {
        indexToParent.put(rootQ, rootP);
        size.put(rootP, size.get(rootP) + size.get(rootQ));
      }
    }
  }

  public int find(int p) {
    List<Integer> tempList = new LinkedList<>();
    while (indexToParent.get(p) != p) {
      tempList.add(p);
      p = indexToParent.get(p);
    }
    for (Integer i :
        tempList) {
      indexToParent.put(i, p);
    }
    return p;
  }

  public List<ArrayList<Integer>> collect() {
    Map<Integer, ArrayList<Integer>> indexToData = new HashMap<>();
    for (Map.Entry<Integer, Integer> e :
        indexToParent.entrySet()) {
      ArrayList<Integer> list = indexToData.getOrDefault(find(e.getKey()), new ArrayList<>());
      list.add(e.getKey());
      indexToData.put(e.getValue(), list);
    }
    return indexToData.values().stream().collect(Collectors.toList());
  }


  public static void main(String[] args) {
    DisjointSet disjointSet = new DisjointSet();
    disjointSet.add(1);
    disjointSet.add(2);
    disjointSet.add(3);

    disjointSet.connect(1, 2);

    System.out.println(disjointSet.isConnect(1, 2));
    System.out.println(disjointSet.isConnect(1, 3));
    System.out.println(disjointSet.collect());

  }
}

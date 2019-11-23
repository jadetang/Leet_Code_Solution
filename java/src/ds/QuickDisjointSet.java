package ds;


public class QuickDisjointSet {

  private int[] id;
  private int count;

  public QuickDisjointSet(int n) {
    this.count = n;
    id = new int[n];
    for (int i = 0; i < n; i++) {
      id[i] = i;
    }
  }

  public int count() {
    return count;
  }

  public boolean connect(int p, int q) {
    return find(p) == find(q);
  }

  public int find(int p) {
    while (id[p] != p) {
      p = id[p];
    }
    return p;
  }

  public void uion(int p, int q) {
    int proot = find(p);
    int qroot = find(q);
    if (proot == qroot) {
      return;
    }
    id[proot] = qroot;
    count--;
  }
}

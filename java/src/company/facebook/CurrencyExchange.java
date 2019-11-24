package company.facebook;

import java.util.HashMap;
import java.util.Map;

public class CurrencyExchange {

    private Map<String, Integer> currencyToID = new HashMap<>();

    private DSU dsu;

    public CurrencyExchange(String[][] rates) {
        final int[] id = {1};
        dsu = new DSU(rates.length * 2 + 1);
        for (String[] rate : rates) {
            String money1 = rate[0];
            currencyToID.computeIfAbsent(money1, s -> id[0]++);
            String money2 = rate[1];
            currencyToID.computeIfAbsent(money2, s -> id[0]++);
            dsu.connect(currencyToID.get(money1), currencyToID.get(money2));
        }
    }

    public boolean canChange(String money1, String money2) {
        if (!currencyToID.containsKey(money1) || !currencyToID.containsKey(money2)) {
            return false;
        }
        return dsu.isConnect(currencyToID.get(money1), currencyToID.get(money2));
    }

    public static class DSU {

        int[] array;

        public DSU(int n) {
            array = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                array[i] = i;
            }
        }

        public int find(int id) {
            while (array[id] != id) {
                id = array[id];
            }
            return id;
        }

        public void connect(int left, int right) {
            array[find(right)] = find(left);
        }

        public boolean isConnect(int left, int right) {
            return find(left) == find(right);
        }
    }

}

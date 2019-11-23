package company.facebook;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class CurrencyExchange2 {

  public double change(String fromCurrency, String toCurrency, Rate[] rates) {
    Map<String, List<Rate>> graph = new HashMap<>();
    for (Rate r : rates) {
      graph.computeIfAbsent(r.from, k -> new ArrayList<>()).add(r);
      Rate reverseRate = new Rate(r.to, r.from, 1 / r.rate);
      graph.computeIfAbsent(reverseRate.from, k -> new ArrayList<>()).add(reverseRate);
    }
    Map<String, Double> exchangeRate = new HashMap<>();
    Set<String> unsettledNode = new HashSet<>();
    Set<String> settledNode = new HashSet<>();
    unsettledNode.add(toCurrency);
    exchangeRate.put(toCurrency, 1.0D);
    while (!unsettledNode.isEmpty()) {
      String current = getSmallest(unsettledNode, exchangeRate);
      unsettledNode.remove(current);
      settledNode.add(current);
      for (Rate rate : graph.get(current)) {
        if (!settledNode.contains(rate.to)) {
          if (exchangeRate.get(rate.to) == null
              || exchangeRate.get(rate.to) > exchangeRate.get(current) * rate.rate) {
            exchangeRate.put(rate.to, exchangeRate.get(current) * rate.rate);
            unsettledNode.add(rate.to);
          }
        }
      }
    }
    return 1 / exchangeRate.get(fromCurrency);
  }

  private String getSmallest(Set<String> unsettledNode, Map<String, Double> costTo) {
    double min = Double.MAX_VALUE;
    String ret = null;
    for (String s : unsettledNode) {
      if (costTo.get(s) < min) {
        min = costTo.get(s);
        ret = s;
      }
    }
    return ret;
  }

  public static class Rate {

    String from;
    String to;
    Double rate;

    public Rate(String from, String to, Double rate) {
      this.from = from;
      this.to = to;
      this.rate = rate;
    }
  }
}

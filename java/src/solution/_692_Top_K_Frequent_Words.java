package solution;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class _692_Top_K_Frequent_Words {

  public List<String> topKFrequent(String[] words, int k) {
    Map<String,Integer> counter = new HashMap<>();
    for(String word : words){
      counter.put(word,counter.getOrDefault(word,0)+1);
    }
    PriorityQueue<String> q = new PriorityQueue<>(
        (w1, w2) -> counter.get(w1).equals(counter.get(w2)) ?
            w2.compareTo(w1) : counter.get(w1) - counter.get(w2) );
    for(String word : counter.keySet()){
      q.offer(word);
      if( q.size() > k ){
        q.poll();
      }
    }
    List<String> ans = Stream.generate(q::poll).limit(q.size()).collect(Collectors.toList());
    Collections.reverse(ans);
    return ans;
  }

  public static void main(String[] args) {
    _692_Top_K_Frequent_Words q = new _692_Top_K_Frequent_Words();
    String[] data = new String[]{"glarko","zlfiwwb","nsfspyox","pwqvwmlgri","qggx",
        "qrkgmliewc","zskaqzwo","zskaqzwo","ijy","htpvnmozay","jqrlad","ccjel","qrkgmliewc",
        "qkjzgws","fqizrrnmif","jqrlad","nbuorw","qrkgmliewc","htpvnmozay","nftk","glarko",
        "hdemkfr","axyak","hdemkfr","nsfspyox","nsfspyox","qrkgmliewc","nftk","nftk","ccjel",
        "qrkgmliewc","ocgjsu","ijy","glarko","nbuorw","nsfspyox","qkjzgws","qkjzgws","fqizrrnmif",
        "pwqvwmlgri","nftk","qrkgmliewc","jqrlad","nftk","zskaqzwo","glarko","nsfspyox","zlfiwwb",
        "hwlvqgkdbo","htpvnmozay","nsfspyox","zskaqzwo","htpvnmozay","zskaqzwo","nbuorw","qkjzgws",
        "zlfiwwb","pwqvwmlgri","zskaqzwo","qengse","glarko","qkjzgws","pwqvwmlgri","fqizrrnmif",
        "nbuorw","nftk","ijy","hdemkfr","nftk","qkjzgws","jqrlad","nftk","ccjel","qggx","ijy",
        "qengse","nftk","htpvnmozay","qengse","eonrg","qengse","fqizrrnmif","hwlvqgkdbo","qengse",
        "qengse","qggx","qkjzgws","qggx","pwqvwmlgri","htpvnmozay","qrkgmliewc","qengse",
        "fqizrrnmif","qkjzgws","qengse","nftk","htpvnmozay","qggx","zlfiwwb","bwp","ocgjsu",
        "qrkgmliewc","ccjel","hdemkfr","nsfspyox","hdemkfr","qggx","zlfiwwb","nsfspyox","ijy",
        "qkjzgws","fqizrrnmif","qkjzgws","qrkgmliewc","glarko","hdemkfr","pwqvwmlgri"};
    q.topKFrequent(data,14);
  }

}

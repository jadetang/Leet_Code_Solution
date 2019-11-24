package solution;

import java.util.LinkedHashMap;
import java.util.Map;

public class _146_LRU_Cache {

  private final int size;

  private Map<Integer,Integer> cache;

  public _146_LRU_Cache(Integer size){
    this.size = size;
    cache = new LinkedHashMap<Integer, Integer>((int) (Math.ceil(size / 0.75f) + 1), 0.75f, true){
      @Override
      protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
        return size() > size;
      }
    };
  }

  public int get(int key) {
    Integer result = cache.get(key);
    if(result == null){
      return -1;
    }
    else{
      return result;
    }
  }
  public void put(int key, int value) {
    cache.put(key,value);
  }


}

package solution;

import java.util.HashMap;
import java.util.Map;


/**
 * longUrl -> hashCode -> dict mapping -> shortUrl shortUrl -> dict mapping -> hashCode -> longUrl
 *
 * @author jade on 2017/5/17 上午8:39
 */
public class _535_Encode_and_Decode_TinyURL {

  private Map<Integer, String> hashToLongUrl;

  private Map<Integer, Character> dict;

  private Map<Character, Integer> reverseDict;

  private int radix;

  public _535_Encode_and_Decode_TinyURL() {
    int count = 0;
    hashToLongUrl = new HashMap<>();
    dict = new HashMap<>();
    reverseDict = new HashMap<>();
    for (char c = 'A'; c < 'Z'; c += 1) {
      dict.put(count, c);
      reverseDict.put(c, count);
      count++;
    }
    for (char c = 'a'; c < 'z'; c += 1) {
      dict.put(count, c);
      reverseDict.put(c, count);
      count++;
    }
    for (char c = '0'; c < '9'; c += 1) {
      dict.put(count, c);
      reverseDict.put(c, count);
      count++;
    }
    radix = dict.size();
  }

  // Encodes a URL to a shortened URL.
  public String encode(String longUrl) {
    int hash = Math.abs(longUrl.hashCode());
    System.out.println(hash);
    if (!hashToLongUrl.containsKey(hash)) {
      hashToLongUrl.put(hash, longUrl);
    }
    return encode(hash);
  }

  private String encode(int hash) {
    StringBuilder sb = new StringBuilder();
    while (hash != 0) {
      sb.append(dict.get(hash % radix));
      hash = hash / radix;
    }
    return sb.reverse().toString();
  }

  private Integer decodeHelp(String shortUrl) {
    int hash = 0;
    for (int i = 0; i < shortUrl.length() - 1; i++) {
      hash = (hash + reverseDict.get(shortUrl.charAt(i))) * radix;
    }
    hash += reverseDict.get(shortUrl.charAt(shortUrl.length() - 1));
    System.out.println(hash);
    return hash;
  }

  // Decodes a shortened URL to its original URL.
  public String decode(String shortUrl) {
    Integer hash = decodeHelp(shortUrl);
    return hashToLongUrl.get(hash);
  }

  public static void main(String[] args) {
    _535_Encode_and_Decode_TinyURL q = new _535_Encode_and_Decode_TinyURL();
    String url = "https://leetcode.com/problems/design-tinyurl";
    String shortUrl = q.encode(url);
    String decodeShortUrl = q.decode(shortUrl);
    System.out.println(shortUrl + ":" + decodeShortUrl);


  }

}

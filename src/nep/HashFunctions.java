package nep;

import java.util.BitSet;

public class HashFunctions {

  private static final BitSet TO_BITS(int value) {
    BitSet bits = new BitSet();
    int index = 0;
    while(value != 0) {
      if(value % 2 != 0) {
        bits.set(index);
      }
      index++;
      value = value >>> 1
    }
    return bits;
  }
  
  public static HashFunction SIMPLE = new HashFunction() {
    @Override
    public long hash(Object obj) {
      return obj.hashCode();
    }
  };
  
  public static HashFunction FNV = new HashFunction() {
    @Override
    public long hash(Object obj) {
      BitSet bits = TO_BITS(obj.hashCode());
      long hash = 0xcbf29ce484222325L;
      int index = 0;
      while(index < bits.length()) {
        byte octet = bits.get(index, index + 8).toByteArray()[0];
        hash = hash ^ octet;
        hash = hash * 0x100000001b3L;
        index += 8
      }
      return hash;
    }
  };
  
  public static HashFunction JENKINS_ONE_AT_A_TIME = new HashFunction() {
    @Override
    public long hash(Object obj) {
      String key = obj.toString();
      long hash = 0;
      for (int i = 0; i < key.length(); i++) {
        hash += key.charAt(i);
        hash += (hash << 10);
        hash += (hash >> 6);
      }
      hash += (hash << 3);
      hash ^= (hash >> 11);
      hash += (hash << 15);
      return hash;
    }
  };
  
  private HashFunctions() {}

}

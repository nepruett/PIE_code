package nep;

import java.util.Arrays;
import java.util.BitSet;
import java.util.List;

public class BloomFilter {
  private int nBits;
  private BitSet bits;
  private List<HashFunction> hashers;
  
  public BloomFilter(int nBits, List<HashFunction> hashers) {
    //Preconditions.checkArgument(nBits > 0, "Number of bits must be > 0");
    //Preconditions.checkArgument(hashers.size() > 0, "One or more hash functions must be provided");
    this.nBits = nBits;
    this.bits = new BitSet(nBits);
    this.hashers = hashers;
  }
  
  public BloomFilter(int nBits, HashFunction ... hashers) {
    this(nBits, Arrays.asList(hashers));
  }
  
  private int generateIndex(HashFunction f, Object item) {
    long result = f.hash(item);
    long index = Math.abs(result) % nBits;
    System.out.print(" " + index);
    return (int)index;
  }
  
  public void add(Object item) {
    System.out.print("Adding " + item);
    for (HashFunction f : hashers) {
      bits.set(generateIndex(f, item));
    }
    System.out.println();
  }
  
  public boolean query(Object item) {
    System.out.print("Query " + item);
    for(HashFunction f : hashers) {
      if(bits.get(generateIndex(f, item))) {
        System.out.println();
        return true;
      }
    }
    System.out.println();
    return false;
  }
  
  public String toString() {
    return bits.toString();
  }
}

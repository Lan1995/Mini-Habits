package cache;

import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnels;

import java.util.stream.IntStream;


/**
 * @author qing.lan, {@literal <qing.lan@leyantech.com>}
 * @date 2021-04-24.
 */
public class BloomFilterTest {

  private static BloomFilter<Integer> bloomFilter;

  static {
   // bloomFilter = BloomFilter.create(Funnels.integerFunnel(), 1000000, 0.01);
    bloomFilter = BloomFilter.create(Funnels.integerFunnel(), 5, 0.01);
  }

  public static void main(String[] args) {
    IntStream.range(0, 100_000).forEach(bloomFilter::put);
    printResult(1);
    printResult(2);
    printResult(3);
    printResult(1_000_000);
  }

  private static void printResult(int i) {
    if (bloomFilter.mightContain(i)) {
      System.out.println("hit:" + i);
    }
  }


}

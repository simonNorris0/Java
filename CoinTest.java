/**
 *
 */
public class CoinTest {
  private static final int TESTCOUNT = 1000000;

  public static void main(String[] args) { 
    Coin c = new Coin();
    int headCount = 0;
    int tailCount = 0;
    
    for(int i = 0; i < TESTCOUNT; i++) {
      if(c.flip().equals("heads")) headCount++;
      else tailCount++;
    }

    System.out.println("# of heads: " + headCount);
    System.out.println("# of tails: " + tailCount);
  }
}

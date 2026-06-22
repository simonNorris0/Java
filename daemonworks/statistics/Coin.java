package daemonworks.statistics;

import java.util.Random;
/**
 * A simple program that simulates coin-flipping.
 * @author Simon Norris
 * @author simonNorris0
 *
 * TO-DO:
 *   * Documentation!
 *
 */
public class Coin {
  /**
   * 0.5 weighting for a fair coin
   */
  private static final double WEIGHT = 0.5;
  private Random rng;

  public Coin() {
    rng = new Random();
  }
  
  /**
   * @return true for heads or false for tails
   */
  private boolean simulateToss() {
    if (rng.nextDouble(1.0) > WEIGHT) return true;
    else return false;
  }

  public String flip() {
    if (simulateToss()) return "heads";
    else return "tails";
  }

  /**
   * @param int n number of flips to simulate
   */
  public void flip(int n) {
    for (int j = 0; j < n; j++) {
      if (simulateToss()) System.out.println("heads");
      else System.out.println("tails");
    }
    return;
  }
}

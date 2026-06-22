package daemonworks.numbers;
/** Methods for computing and analyzing prime numbers.
 *  @author Simon Norris
 *  @author simonNorris0
 *   
 */
public class Primes {
   /** Determines if an integer n is prime */
   private boolean isPrime(int n) {
      if (n<=1) return false;
      else {
         for(int i = 2; i < n; i++) {
            if(n % i == 0) return false;
         }
         return true;
      }
   }
   /** sum of prime numbers in the range between 
    *  min(n, reverse_of_n) -> max(n, reverse_of_n) inclusive
    *  (personal solution to a LeetCode problem)
    *  To-Do:
    *   * add reference to the actual problem on LeetCode 
    *   * improve documentation
    *
    */
   public int sumOfPrimesInRange(int n) {
        int r = 0;
        int sum = 0;
        int temp = n;
        
	  // reverse the number n, store as r
        while(temp > 0) {
            r = r * 10 + (temp % 10);
            temp = temp / 10;
        }
        System.out.println("r = " + r);

	  // calculate the sum of all primes from min(n, r) -> max(n, r) inclusive
        for(int i = Math.min(n, r); i <= Math.max(n, r); i++) {
            if(isPrime(i)) sum = sum + i;
        }
        return sum;
    }
}
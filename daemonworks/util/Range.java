package daemonworks.util;

/**  Methods to create integer sequences
 */
public class Range() {

   /** Produces an integer array containing the sequence [0...n)
    *  @param int n          the upper boundary of the sequence (non-inclusive)
    *  @return int[] result  an integer array of size n with:
    *                          result[0] = 0, 
    *                          result[1] = 1, ..., 
    *                        result[n-1] = n - 1
    */
   public static int[] range(int n) {
      int[] result = new int[n];
      
      for(int i = 0; i < n; i++) result[i] = i;
      return result;
   }
   
   /** Produces an integer array containing the sequence [start...end)
    *  @param int start      the lower boundary of the sequence (inclusive)
    *  @param int end        the upper boundary of the sequence (non-inclusive)
    *  @return int[] result  an integer array of size n = (end - start) 
    *                        with:   result[0] = start, 
    *                                result[1] = start + 1, ...,
    *                              result[n-1] = start + (n - 1)
    */
   public static int[] range(int start, int end) {
      int n = end - start; // number of items in array
      int[] result = new int[n];
      
      for(int i = 0; i < n; i++) result[i] = start + i;
      return result;
   }

   /** Produces an integer array containing the sequence [start..end) 
    *  incrementing by the parameter step
    *  @param int start      the lower boundary of the sequence (inclusive)
    *  @param int end        the upper boundary of the sequence (non-inclusive)
    *  @param int step       the step size of each term in the sequence
    *  @return int[] result  an integer array of size n = (end - start) / step
    *                        with:   result[0] = start,
    *                                result[1] = start + step, ...,
    *                              result[n-1] = start + ((n - 1) * step)
    */
   public static int[] range(int start, int end, int step) {
      int n = (end - start) / step; // number of items in array
      int[] result = new int[n];
      
      for(int i = 0; i < n; i++) result[i] = start + (i * step);
      return result;
   }   
}
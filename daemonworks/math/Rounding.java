package daemonworks.math;
/** Methods to round numbers mathematically */
public class Rounding {
   /** Rounds the input to n decimal places.
    *  @param double x   the floating-point number to round off.
    *  @param int n      the number of decimal places to round to.
    *  @return double y  x rounded to n decimal places.
    *  
    *   To round a number x to n decimal places:
    *    -multiply the number by 10 to the power of n
    *    -round to the nearest integer
    *        (Math.round() implements this by adding 0.5 to the argument 
    *        and then taking the floor.)
    *    -then divide by 10 to the power of n
    */
   public static double roundNDecimalPlaces(double x, int n) {
      double y = Math.round(x * Math.pow(10, n));
      return y / Math.pow(10, n);   
   }
}
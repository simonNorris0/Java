import java.util.Random;
import java.util.Map.Entry;
import java.util.Map;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.ArrayList;
/** How well distributed are samples produced by 
 *  java.util.Random.nextInt()?
 *
 *  Based on the output data, there is no single number that tends to 
 *  appear more than any one other. This experiment successfully shows  
 *  that java.util.Random operates with a uniform distribution.
 *
 *  Across three completely separate runs generating 1 billion numbers each, 
 *  the overall mathematical distribution remained consistent, maintaining 
 *  a mean frequency of ~99.99 and an expected outlier count of ~26
 *
 *  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  !!** How can I improve the efficiency of this program to increase 
 *       TEST_COUNT without running out of memory??? **!!
 *
 */
public class RandomNextIntDistribution {
   public static void main(String[] args) {
      TestingFrequencies.main(args);
   }
}/*Output: (sample run 1 - unseeded Random generators)
*  total running time (Pre-Reporting): 21.0 seconds
*  total tests run: 1000
*  iterations of nextInt(n+1) per test: 1000000
*  upper limit of range (n) in each test: 10000
*  mean frequency: 99.98987
*  variance: 0.09932199913881486
*  standard deviation: 0.31515392927713093
*  true outliers (z-score > +-3:
*  number: 7996 z-score: -3.62955174095234 freq: 98.846
*  number: 4118 z-score: -3.4962841120483747 freq: 98.888
*  number: 2070 z-score: -3.445518949866428 freq: 98.904
*  number: 9072 z-score: -3.3947537876844818 freq: 98.92
*  number: 5170 z-score: -3.1916689304864136 freq: 98.984
*  number: 6835 z-score: -3.1821550016654765 freq: 98.987
*  number: 1852 z-score: -3.144075077911446 freq: 98.999
*  number: 4914 z-score: -3.134561149090509 freq: 99.002
*  number: 3727 z-score: -3.1059951541574153 freq: 99.011
*  number: 1504 z-score: -3.0996525349434574 freq: 99.013
*  number: 9613 z-score: -3.0996525349434574 freq: 99.013
*  number: 9659 z-score: -3.055229991975469 freq: 99.027
*  number: 4470 z-score: -3.048887372761511 freq: 99.029
*  number: 9869 z-score: -3.039373443940574 freq: 99.032
*  number: 6944 z-score: -3.0203213778284175 freq: 99.038
*  number: 2994 z-score: 3.0148260550743395 freq: 100.94
*  number: 3252 z-score: 3.0243399838952763 freq: 100.943
*  number: 9501 z-score: 3.0401965319301714 freq: 100.948
*  number: 5336 z-score: 3.056077288435349 freq: 100.953
*  number: 1895 z-score: 3.1226989986521905 freq: 100.974
*  number: 7409 z-score: 3.1290416178661484 freq: 100.976
*  number: 8336 z-score: 3.2178867038021255 freq: 101.004
*  number: 3715 z-score: 3.3067317897381026 freq: 101.032
*  number: 3873 z-score: 3.373377708425226 freq: 101.053
*  number: 807 z-score: 3.4082863225722777 freq: 101.064
*  number: 7060 z-score: 3.455880175147245 freq: 101.079
*/
/* Output: (sample run 2 - unseeded Random generators)
*  total running time (Pre-Reporting): 22.0 seconds
*  total tests run: 1000
*  iterations of nextInt(n+1) per test: 1000000
*  upper limit of range (n) in each test: 10000
*  mean frequency: 99.98967
*  variance: 0.10126927495727432
*  standard deviation: 0.3182283377659418
*  true outliers (z-score > +-3:
*  number: 1931 z-score: -3.7698367552662924 freq: 98.79
*  number: 4654 z-score: -3.358193012219402 freq: 98.921
*  number: 5165 z-score: -3.3299029937688873 freq: 98.93
*  number: 8892 z-score: -3.2576195991686325 freq: 98.953
*  number: 3027 z-score: -3.1916415222399754 freq: 98.974
*  number: 2913 z-score: -3.138226131470699 freq: 98.991
*  number: 3087 z-score: -3.1130767845600302 freq: 98.999
*  number: 820 z-score: -3.0942327553209585 freq: 99.005
*  number: 7623 z-score: -3.0816460945696704 freq: 99.009
*  number: 179 z-score: -3.0659427368704444 freq: 99.014
*  number: 3162 z-score: -3.0376527184199302 freq: 99.023
*  number: 8614 z-score: -3.0376527184199302 freq: 99.023
*  number: 316 z-score: -3.012527346101168 freq: 99.031
*  number: 9950 z-score: -3.012527346101168 freq: 99.031
*  number: 6645 z-score: 3.077450540985908 freq: 100.969
*  number: 8300 z-score: 3.1371472748348745 freq: 100.988
*  number: 986 z-score: 3.143428617914565 freq: 100.99
*  number: 2291 z-score: 3.1591559502056983 freq: 100.995
*  number: 2241 z-score: 3.193703337143996 freq: 101.006
*  number: 2672 z-score: 3.218852684054665 freq: 101.014
*  number: 7845 z-score: 3.2440020309653343 freq: 101.022
*  number: 9227 z-score: 3.265986731744251 freq: 101.029
*  number: 5956 z-score: 3.3225427940533723 freq: 101.047
*  number: 6937 z-score: 3.3225427940533723 freq: 101.047
*  number: 1451 z-score: 3.3351294548046604 freq: 101.051
*  number: 2112 z-score: 3.3351294548046604 freq: 101.051
*  number: 8456 z-score: 3.344551469424196 freq: 101.054
*  number: 9726 z-score: 3.416834864024451 freq: 101.077
*  number: 1094 z-score: 3.4356788932635225 freq: 101.083
*  number: 8909 z-score: 3.8599092970617015 freq: 101.218
*/
/* Output: (sample run 3 - unseeded Random generators)
*  total running time (Pre-Reporting): 22.0 seconds
*  total tests run: 1000
*  iterations of nextInt(n+1) per test: 1000000
*  upper limit of range (n) in each test: 10000
*  mean frequency: 99.98952
*  variance: 0.09898175918330672
*  standard deviation: 0.31461366655520023
*  true outliers (z-score > +-3:
*  number: 4807 z-score: -3.831749087960548 freq: 98.784
*  number: 3264 z-score: -3.7236666521334474 freq: 98.818
*  number: 2249 z-score: -3.558378367951819 freq: 98.87
*  number: 6146 z-score: -3.313646947182894 freq: 98.947
*  number: 9123 z-score: -3.29773891983208 freq: 98.952
*  number: 4170 z-score: -3.234179560553904 freq: 98.972
*  number: 86 z-score: -3.176973712199376 freq: 98.99
*  number: 8728 z-score: -3.1070365919558585 freq: 99.012
*  number: 2154 z-score: -3.0847993037230896 freq: 99.019
*  number: 4489 z-score: -3.0657145209104515 freq: 99.025
*  number: 2558 z-score: 3.0401792270073917 freq: 100.946
*  number: 3154 z-score: 3.084678053514623 freq: 100.96
*  number: 603 z-score: 3.0878548089764473 freq: 100.961
*  number: 4909 z-score: 3.0878548089764473 freq: 100.961
*  number: 6010 z-score: 3.135530390945503 freq: 100.976
*  number: 746 z-score: 3.141883901869151 freq: 100.978
*  number: 9735 z-score: 3.183205972914558 freq: 100.991
*  number: 565 z-score: 3.1863827283763824 freq: 100.992
*  number: 2813 z-score: 3.1863827283763824 freq: 100.992
*  number: 6071 z-score: 3.2436128267726034 freq: 101.01
*  number: 3090 z-score: 3.48199073661788 freq: 101.085
*  number: 4154 z-score: 3.4915210030033523 freq: 101.088
*  number: 7038 z-score: 3.602780194292277 freq: 101.123
*/
// IMPLEMENTATION
// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
/** A program to run tests that examine the randomnes of the nextInt() method 
 *  of java.util.Random.
 *  The upper limit of the test range is controlled by the parameter n passed 
 *  to the constructor. If no argument is provided a default constructor 
 *  runs the test with n = 10.
 *  The constant ITERATION_COUNT controls how many times to call nextInt()
 *
 *  getFreqMap() returns the Map<Integer, Integer> that contains the 
 *  number:frequency pairs.
 *
 */
class RandomNextIntStatistics {
   private static final int ITERATION_COUNT = 1_000_000;
   private Random rng;

   private Map<Integer, Integer> m = new HashMap<Integer, Integer>();
   /** Creates a new test of the distribution of integers in the range 
    *  [0 to n]
    *  @param int n  the upper limit of the range to test
    */
   public RandomNextIntStatistics(int n) {
      rng = new Random();
      for(int i = 0; i < ITERATION_COUNT; i++) {
         int num = rng.nextInt(n+1); // autoboxing
         Integer freq = m.get(num);  // return the 'value' associated with 
                                     // this 'key'
         // store 1 for the frequency 'value' if this is the first time seeing 
         // this number 'key', otherwise increment the current value 
         // stored as 'freq' above:
         m.put(num, freq == null ? 1 : freq + 1); 
      }
   }
   /** Default constructor - creates and runs a new test in the range
    *                        [0 to 10]
    */
   public RandomNextIntStatistics() {
       for(int i = 0; i < ITERATION_COUNT; i++) {
         int num = rng.nextInt(11);
         Integer freq = m.get(num); 
         m.put(num, freq == null ? 1 : freq + 1);
       }      
   }
   public static int getIterationCount() { return ITERATION_COUNT; }
   public Map<Integer, Integer> getFreqMap() { return m; }
}
class TestingFrequencies {
   // turn on a full output of all the numbers tested, their frequency, 
   // and their z-scores : sorted in ascending order
   private static final boolean FULL_REPORT = false;
   private static long startTime = System.nanoTime();

   // Test Parameters (constants): 
   private static final int TEST_COUNT = 1000;
   private static final int UPPER_LIMIT_OF_RANGE = 10_000;
   
   // Inferential Statistics Variables:
   private static Float meanFrequency = 0F;
   private static Double variance = 0D;
   private static Double stdDeviation = 0D;
   private static int N = 0; // total number of data points
   
   // Data Structures: 
   private static List<Map<Integer, Integer>> results = 
      new ArrayList<Map<Integer, Integer>>();
   private static List<Map.Entry<Integer, Float>> sortedAvgFreqs;
   private static Map<Integer, Float> averages = 
      new HashMap<Integer, Float>();
   private static Map<Integer, Double> zScores =
      new LinkedHashMap<Integer, Double>();
   private static Map<Integer, Double> outliers = 
      new LinkedHashMap<Integer, Double>();
   
   // Data Initialization (Running the tests): 
   static {
      for(int i = 0; i < TEST_COUNT; i++) {
         RandomNextIntStatistics test = 
            new RandomNextIntStatistics(UPPER_LIMIT_OF_RANGE);
         results.add(test.getFreqMap());
      }
   }
   /** Processing the data. */
   public static void main(String[] args) {
      // COMPUTING AVERAGE FREQUENCY OF EACH NUMBER IN THE SPECIFIED RANGE FROM 
      // ALL THE INDIVIDUAL TESTS:
      // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
      for(Map<Integer, Integer> m : results) {
         for(Map.Entry<Integer, Integer> entry : m.entrySet()) {
            int num = entry.getKey();
            Integer freq = entry.getValue();
            Float totalFreq = averages.get(num);
            // store freq as is for the 'value' if this is the first time 
            // seeing this number 'key', otherwise add freq to the current 
            // total value of frequencies seen for that key in averages: 
            averages.put(num, totalFreq == null ? freq : totalFreq + freq); 
         }
      }// now that we have iterated through all the entries in all the test
       // maps - compute the average frequency for the total frequencies 
       //        we have associated with each key in the averages map:
      for(Map.Entry<Integer, Float> entry : averages.entrySet()) {
         Float avgFreq = entry.getValue() / TEST_COUNT;
         averages.put(entry.getKey(), avgFreq);         
      }
      // IDENTIFYING OUTLIERS:
      // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
      // store the entry set from the averages map in an ArrayList so 
      // we can sort it in ascending order by value:
      sortedAvgFreqs = 
         new ArrayList<Map.Entry<Integer, Float>>(averages.entrySet());
      sortedAvgFreqs.sort(Map.Entry.<Integer, Float>comparingByValue());
      // identify the mean frequency among all the numbers in the range 
      // tested:
      for(Map.Entry<Integer, Float> entry : sortedAvgFreqs) {
         meanFrequency += entry.getValue();
         N++;
      }
      meanFrequency /= N;
      // calculate variance:
      for(Map.Entry<Integer, Float> entry : sortedAvgFreqs) {
         variance += Math.pow(entry.getValue() - meanFrequency, 2);
      }
      variance /= (N-1); // this is a sample (so N-1)
      // calculate standard deviation:
      stdDeviation = Math.sqrt(variance);
      // detect outliers by converting data points to Z-scores:
      for(Map.Entry<Integer, Float> entry : sortedAvgFreqs) {
         Double zScore = (entry.getValue() - meanFrequency) / stdDeviation;
         zScores.put(entry.getKey(), zScore);
         if(zScore > 3.0 || zScore < -3.0)
            outliers.put(entry.getKey(), zScore);
      }
      long endTime = System.nanoTime();
      long runTime = endTime - startTime;
      long runTimeMilis = runTime / 1_000_000;
      float runTimeSec = runTimeMilis / 1_000;
      // REPORT
      // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
      System.out.println("total running time (Pre-Reporting): " 
         + runTimeSec + " seconds");
      System.out.println("total tests run: " + TEST_COUNT);
      System.out.println("iterations of nextInt(n+1) per test: " 
         + RandomNextIntStatistics.getIterationCount());
      System.out.println("upper limit of range (n) in each test: " 
         + UPPER_LIMIT_OF_RANGE);
      System.out.println("mean frequency: " + meanFrequency);
      System.out.println("variance: " + variance);
      System.out.println("standard deviation: " + stdDeviation);
      System.out.println("true outliers (z-score > +-3: ");
      for(Map.Entry<Integer, Double> entry : outliers.entrySet()) {
         System.out.println("number: " + entry.getKey() + " z-score: " 
            + entry.getValue() + " freq: " 
            + averages.get(entry.getKey()));
      }
      if(FULL_REPORT) {
         System.out.println("All z-Scores: ");
         for(Map.Entry<Integer, Double> entry : zScores.entrySet())
            System.out.println("number: " + entry.getKey() + " z-score: " 
               + entry.getValue() + " freq: " 
               + averages.get(entry.getKey()));
      }
   }
}
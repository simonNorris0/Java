package daemonworks.util;

import java.util.Formatter;
import java.io.File;
/** Often you want to look at the bytes inside a binary file using hex format.
 *  This is a small utility that displays a binary array of bytes in a 
 *  readable hex format, using String.format().
 *
 *  TO-DO: implement BinaryFile.read()
 *
 */
public class Hex {
   public static String format(byte[] data) {
      StringBuilder result = new StringBuilder();
      int n = 0;
      for(byte b : data) {
         if(n % 16 == 0)
            result.append(String.format("%05X: ", n));
         result.append(String.format("%02X ", b));
         n++;
         if(n % 16 == 0) result.append("\n");
      }
      result.append("\n");
      return result.toString();
   }
   public static void main(String[] args) throws Exception {
      if(args.length == 0)
         // Test by displaying this class file:
         System.out.println(
            // * BinaryFile.read() returns the entire file as a byte array
            format(BinaryFile.read("Hex.class")));
      else
         System.out.println(
            format(BinaryFile.read(new File(args[0]))));
   }
}/*Output:

*/
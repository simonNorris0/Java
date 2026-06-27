package daemonworks.util;

import java.util.regex.Pattern;
import java.util.regex.Matcher;
/** A very simple version of the 'grep' program that shows how to apply 
 *  regular expressions to search for matches in a file.
 *
 *  Takes two arguments: a file name and the regular expression that you 
 *  want to match. The output shows each line where a match occurs and the
 *  match position(s) within the line.
 *
 *  ** TO-DO: implement TextFile  the constructor reads the lines of the 
 *                                lines of the file into an ArrayList.
 *
 *  Modified from TIJ String/regular_expressions
 *  @author Bruce Eckel
 *  
 */
public class JGrep {
   public static void main(String[] args) throws Exception {
      if(args.length < 2) {
         System.out.println("Usage: java JGrep file regex");
         System.exit(0);
      }
      Pattern p = Pattern.compile(args[1]);
      // Iterate through the lines of the input file:
      int index = 0; // counts the current line of the input file
      Matcher m = p.matcher("");
      for(String line : new TextFile(args[0])) {
         m.reset(line); // reset the Matcher object to the new input line
         while(m.find())
            System.out.println(index++ + ": " + m.group() + ": " + m.start());
      }
   }
}/*Output:

*/

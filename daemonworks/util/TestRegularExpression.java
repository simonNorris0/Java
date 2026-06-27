package daemonworks.util;

import java.util.regex.Pattern;
import java.util.regex.Matcher;
/** Can be used to test regular expressions against an input String. 
 *  The first command-line argument is the input string to match against, 
 *  followed by one or more regular expressions to be applied to the input. 
 *  
 *  Under Unix/Linux, the regular expressions must be quoted on the command line. 
 *
 *  args: CharSequenceToApplyRegexTo, regex(s), ...
 *
 *  Program comes verbatim from Thinking in Java 4th Ed. 
 *  (without his print utility)
 *  @author Bruce Eckel
 *  
 */
class TestRegularExpression {
   public static void main(String[] args) {
      if(args.length < 2) {
         System.out.println("Usage:\njava TestRegularExpression " + 
            "characterSequence regularExpression+");
         System.exit(0);
      }
      System.out.println("Input: \"" + args[0] + "\"");
      for(String arg : args) {
         System.out.println("Regular expression: \"" + arg + "\"");
         // compile the regex using the static Pattern.compile() method:
         Pattern p = Pattern.compile(arg);
         // call the Pattern.matcher() method on the compiled pattern,
         // passing in the String that you want to apply the regex to:
         Matcher m = p.matcher(args[0]);
         while(m.find()) {
            System.out.println("Match \"" + m.group() + "\" at positions " 
               + m.start() + "-" + (m.end() - 1));
         }
      }
   }
}

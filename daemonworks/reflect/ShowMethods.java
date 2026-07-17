package daemonworks.reflect;

import java.util.regex.Pattern;
import java.lang.reflect.Method;
import java.lang.reflect.Constructor;
/** TO-DO:
 *   - Documentation
 *
 *
 *  From Thinking in Java (4th Ed.)
 *  @author Bruce Eckel
 *  @version 1.0
 *
 */
public class ShowMethods {
   private static String usage = "
      "usage:\n" +
      "ShowMethods qualified.class.name\n" +
      "to show all methods in a class, or:\n" +
      "ShowMethods qualified.class.name word\n" +
      "to search the class for methods that include 'word'";
                   //  at least one letter character followed by a single dot
                   // (* used with Matcher.replaceAll("") to 
                   //  remove name qualifiers from method/constructors 
                   //  signatures):
   private static Pattern p = Pattern.compile("\\w+\\.");
   
   public static void main(String[] args) {
      if(args.length < 1) {
         System.out.println(usage);
         System.exit(0);
      }
      int lines = 0;
      try {
         Class<?> c = Class.forName(args[0]);
         Method[] methods = c.getMethods();
         Constructor[] constructors = c.getConstructors();
         // * Show all methods in the given class:
         if(args.length == 1) {
            for(Method m : methods)
               System.out.println(p.matcher(m.toString()).replaceAll(""));
            for(Constructor c : constructors)
               System.out.println(p.matcher(c.toString()).replaceAll(""));
            lines = constructors.length + methods.length;
         //  * Show only methods matching the target word
         // (using String.indexOf(args[1]) on the method signature to 
         //  determine if it contains the target word - if not, returns -1):   
         } else {
            for(Method m : methods)
               if(m.toString().indexOf(args[1]) != -1) {
                  System.out.println(p.matcher(m.toString()).replaceAll(""));
                  lines++;
               }
            for(Constructor c : constructors)
               if(c.toString().indexOf(args[1]) != -1) {
                  System.out.println(p.matcher(c.toString()).replaceAll(""));
                  lines++;
               }
         }
      } catch(ClassNotFoundException e) {
        System.out.println("Class not found: " + e);
      }
   }
}
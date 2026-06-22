package daemonworks.util;

/** Print methods that can be used without qualifiers.
 */
public class Print {
   
   /** Print obj.toString() with a new line.
    *  @param Object obj
    *  @see System.out.println()
    */
   public static void println(Object obj) { System.out.println(obj); }

   /** Print a new line by itself. */
   public static void println() { System.out.println(); }
    
   /** Print obj.toString() with no line break.
    *  @param Object obj
    *  @see System.out.print()
    */
   public static void print(Object obj) { System.out.print(obj); }
   
   /** Writes a formatted String to System.out PrintStream using:
    *  @param String format   the specified format String
    *  @param Object... args  a variable argument list
    *
    *  @return 
    * @see PrintStream printf(String format, Object... args)
    */
   public static PrintStream printf(String format, Object... args) { 
      return System.out.printf(format, args);
   }
}

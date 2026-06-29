package daemonworks.util;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
/** TO-DO:
 *   - Documentation
 *   - Replace deprecated Class.newInstance() use in 
 *     printClassHierarchy() with reflection
 *
 */
class TypeInfo {
   /** A utility method that takes an object and recursively
    *  prints all the classes in that object's hierarchy.
    *
    *  @param Object o             The object to investigate the class 
    *                              hierarchy of.
    *  @param boolean fieldsFlag   pass 'true' if you want to print the 
    *                              field details for every class in the 
    *                              hierarchy (excluding Object).
    *  @param boolean methodsFlag  pass 'true' if you want to print the 
    *                              method details for every class in the 
    *                              hierarchy (excluding Object).
    *
    *  Runtime Exceptions:
    *  @throws InstantiationException
    *  @throws IllegalAccessException
    *
    *  * Recursive
    */
   public static void printClassHierarchy(
      Object o, boolean fieldsFlag, boolean methodsFlag) {
      Class c = o.getClass();
      Class sup = c.getSuperclass();
      //Base-case:
      if(sup == null) {
         // This is Object:
         System.out.println("Type: " + c.getSimpleName());
         return;
      }
      else {
         System.out.println("Type: " + c.getSimpleName());
         if(fieldsFlag) {
            System.out.println("Contains fields: ");
            for(Field f : c.getDeclaredFields())
               System.out.println(f.getName() + " " +
                  Modifier.toString(f.getModifiers()));
         }
         if(methodsFlag) {
            System.out.println("Contains methods: ");
            for(Method m : c.getDeclaredMethods())
               System.out.println(m.getName() + " " + 
                  Modifier.toString(m.getModifiers()));
         }
         // DEPRECATED (TO-DO: Fix with reflection)
         try {
            printClassHierarchy(sup.newInstance(), fieldsFlag, methodsFlag);
         } catch(InstantiationException e) {
            System.err.println("Could not instantiate object of type: "
                + sup.getSimpleName());
            System.exit(1);
         } catch(IllegalAccessException e) {
            System.err.println(
               "Illegal access exception instatiating object of type: "
               + sup.getSimpleName());
         }
      }
   }
}
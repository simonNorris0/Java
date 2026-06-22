/**  There are two techniques for explicitly creating threads in a
 *   Java program. One approach is to create a new class that is derived 
 *   from the Thread class and to override its run() method. An alternative, 
 *   and more commonly used, technique is to define a class that implements 
 *   the Runnable interface.
 *   
 *   @see https://docs.oracle.com/javase/8/docs/api/java/lang/Runnable.html
 * 
 *   Runnable defines a single abstract method with the signature
 *   public void run()
 *   the code in the run() method of a class that implements Runnable is 
 *   what executes in a separate thread.
 *
 *   TO-DO:
 *    * Review this entire file
 *
 */
public class Threads implements Runnable 
{
  public void run() {
    System.out.println("I am a thread.");
  }

  /** Lambda expressions allow a cleaner syntax for creating threads, 
   *  rather than defining a separate class that implements Runnable. 
   */
  static Runnable task = () -> {
    System.out.println("I am a thread created by a Lambda expression.");
  };

  /** Thread creation in Java involves creating a Thread object and passing 
   *  it an instance of a class that implements Runnable, followed by invoking 
   *  the start() method on the Thread object.
   * 
   *  Invoking the start() method on a new Thread object does two things: 
   *   - allocates memory and initializes a new thread in the JVM
   *   - calls the run() method, making the thread eligible to be run by 
   *     the JVM. 
   */
  public static void main(String[] args) {
    Thread worker = new Thread(new Threads());
    worker.start();

    /** The parent threads in the Pthreads and Windows libraries use 
     *  pthread_join() and WaitForSingleObject() respectively to wait 
     *  for child threads to finish before proceeding.
     *
     *  The join() method in Java provides similar functionality. (Notice 
     *  that join() can throw an InterruptedException.) If the parent must 
     *  wait for several threads to finish, the join() method can be enclosed 
     *  in a for loop.
     */
    try {
      worker.join();
    } catch (InterruptedException e) { } // ignored exception

    Thread worker2 = new Thread(task);
    worker2.start();
    try {
      worker2.join();
    } catch (InterruptedException e) { } // ignored exception
  }
}
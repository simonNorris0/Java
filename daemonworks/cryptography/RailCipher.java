package daemonworks.cryptography;

/** To-do: - Generalize decryption to work with more than 2 rails.
 *         - Proper documentation
 */
public class RailCipher extends TranspositionCipher {
   private StringBuilder[] rails;
   
   /** Create a new RailCipher with the specified number of rails. */
   public RailCipher(int numberOfRails) {
      if(numberOfRails < 2)
         throw new IllegalArgumentException("Requires at least 2 rails");
      rails = new StringBuilder[numberOfRails];
      for(int i = 0; i < rails.length; i++)
         rails[i] = new StringBuilder();
   }
   /** The plaintext is encrypted by writing one letter to a StringBuilder 
    *  in the rails array, and then the next letter to another StringBuilder 
    *  in the array, and so on for the number of rails. Once every rail has 
    *  a letter, the process starts over from the first rail - until the 
    *  entire plaintext has been written onto the rails. Then the rails 
    *  are concatenated and output as the ciphertext.
    */
   public String encrypt(String plaintext) {
      int i = 0;
      for(char c : plaintext.toCharArray()) {
         if(i == rails.length) i = 0;
         rails[i].append(c);
         i++;
      }
      StringBuilder result = new StringBuilder();
      for(StringBuilder s : rails) {
         result.append(s.toString()); 
      }
      // reset the rails:
      for(int j = 0; j < rails.length; j++)
         rails[j] = new StringBuilder();
      return result.toString();
   }
   /** The ciphertext is decrypted by reversing the process...
    *  ** Currently only have the case where numberOfRails == 2.
    *     Need to generalize to decrypt any number of rails.
    */
   public String decrypt(String ciphertext) {
   // first, split the concatenated text evenly into the number of rails
      split2Rails(ciphertext);
   // then, form the plaintext by appending alternating chars from each rail
      return decrypt2Rails();
   }
   
   private void split2Rails(String ciphertext) {
      char[] c = ciphertext.toCharArray();
      for(int i = 0; i < c.length/2 + 1; i++)
         rails[0].append(c[i]);
      for(int i = c.length/2 + 1; i < c.length; i++)
         rails[1].append(c[i]);
   }
   private String decrypt2Rails() {
      char[] rail1 = rails[0].toString().toCharArray();
      char[] rail2 = rails[1].toString().toCharArray();
      StringBuilder result = new StringBuilder();
      int i = 0;
      int j = 0;
      while(i < rail1.length && j < rail2.length) {
         result.append(rail1[i]);
         i++;
         result.append(rail2[j]);
         j++;
      }
      if(i < rail1.length) result.append(rail1[i]);
      if(j < rail2.length) result.append(rail2[j]);
      return result.toString();     
   }
   /** test */
   public static void main(String[] args) {
      RailCipher c = new RailCipher(2);
      String plaintext = "Move the tropps into place tonight - Attack at dawn";
      String ciphertext = c.encrypt(plaintext);
      System.out.println(ciphertext);
      System.out.println(c.decrypt(ciphertext));
   }
}
package daemonworks.cryptography;

/** A simple monoalphabetic substitution cipher. Shifts each letter in 
 *  the plaintext alphabetically by k positions. 
 *
 *  *To-do:
 *   - Find a way to deal with spaces and punctuation
 *   - Add support for file input/output
 */
public class CaesarCipher {
   /** Encrypts the plaintext input by shifting each letter of the 
    *  String by k positions to the right alphabetically. 
    *  
    *  @param String plaintext    The plaintext to encrypt.
    *  @param int k               The amount of positions to shift each letter.
    *  @return String ciphertext  The encrypted plaintext.
    *
    */
   public static String encrypt(String plaintext, int k) {
      StringBuilder ciphertext = new StringBuilder();
      for(char c : plaintext.toCharArray()) {
         if(Character.isUpperCase(c)) {
            // zero-indexing uppercase characters: 
            char shifted = (char) (((c - 'A' + k) % 26) + 'A');
            ciphertext.append(shifted);
         }
         else if(Character.isLowerCase(c)) {
            // zero-indexing lowercase characters:
            char shifted = (char) (((c - 'a' + k) % 26) + 'a');
            ciphertext.append(shifted);
         }
         else
            // leave spaces and punctuation:
            ciphertext.append(c);
      }
      return ciphertext.toString();
   }
   
   /** Decrypts the ciphertext input by shifting each letter of the 
    *  String by k positions to the left alphabetically. The key 
    *  (k) must match the value used to encrypt the ciphertext. 
    *
    *  @param String ciphertext  The ciphertext to decrypt.
    *  @param int k              The amount of positions to shift each letter.
    *  @return String plaintext  The decrypted ciphertext.
    */
   public static String decrypt(String ciphertext, int k) {
      StringBuilder plaintext = new StringBuilder();
      for(char c : ciphertext.toCharArray()) {
         if(Character.isUpperCase(c)) {
            // zero-indexing uppercase characters: 
            char shifted = (char) (((c - 'A' - k) % 26) + 'A');
            plaintext.append(shifted);
         }
         else if(Character.isLowerCase(c)) {
            // zero-indexing lowercase characters:
            char shifted = (char) (((c - 'a' - k) % 26) + 'a');
            plaintext.append(shifted);
         }
         else
            // leave spaces and punctuation:
            plaintext.append(c);
      }
      return plaintext.toString();
   }
   
   /** test */
   public static void main(String[] args) {
      System.out.println(encrypt("Attack at dawn!", 2));
      System.out.println(decrypt(encrypt("Attack at dawn!", 2), 2));
   }
}
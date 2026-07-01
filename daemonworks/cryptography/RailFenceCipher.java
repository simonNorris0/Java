package daemonworks.cryptography;

/** A simple transposition cipher; encrypts plaintext by writing alternating 
 *  letters on different 'rails' or lines. The resulting ciphertext is 
 *  decrypted by reversing the process.
 *
 *  *To-Do:
 *    - Implement
 *    - Add support for file input/output
 *
 */
public class RailFenceCipher {
   /** Encrypts the plaintext input by writing alternating letters on k 
    *  different 'rails'.  
    *  
    *  @param String plaintext    The plaintext to encrypt.
    *  @param int k               The amount of 'rails' (lines) to use with 
    *                             this railfence cipher.
    *  @return String ciphertext  The encrypted plaintext.
    *
    */
   public static String encrypt(String plaintext, int k) {
   
   }
   
   /** Decrypts the ciphertext input by writing alternating letters from k 
    *  different 'rails' back onto one line. The key (k) must match the 
    *  number of rails used to encrypt the ciphertext.
    *  
    *  @param String plaintext    The ciphertext to decrypt.
    *  @param int k               The amount of 'rails' (lines) used with 
    *                             this railfence cipher.
    *  @return String ciphertext  The decrypted ciphertext.
    *
    */
   public static String decrypt(String ciphertext, int k) {
   
   }
}
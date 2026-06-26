import java.io.File;
public interface Cipher {
   /** Takes an input plaintext String and returns 
    *  the encrypted ciphertext String.
    */
   String encrypt(String plaintext);
   /** Takes an input plaintext File and returns 
    *  the encrypted ciphertext File.
    */
   //File encrypt(File plaintext);
   /** Takes an input ciphertext String and returns 
    *  the plaintext String.
    */
   String decrypt(String ciphertext);
   /** Takes an input ciphertext File and returns 
    *  the plaintext File.
    */
   //File decrypt(File ciphertext);
}
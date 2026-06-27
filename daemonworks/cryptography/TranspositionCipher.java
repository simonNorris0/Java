package daemonworks.cryptography;

public abstract class TranspositionCipher implements Cipher {
   /** Returns the encrypted ciphertext of the input plaintext String */
   public abstract String encrypt(String plaintext);
   /** Returns the decrypted plaintext of the input ciphertext String */
   public abstract String decrypt(String ciphertext);
}
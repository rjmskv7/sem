import java.util.*;
public class Expt2 {
private static String adjustKeyLength(String text, String key) {
int textLength = text.length();
int keyLength = key.length();
if (keyLength < textLength) {
StringBuilder adjustedKey = new StringBuilder();
while (adjustedKey.length() < textLength) {
adjustedKey.append(key);
}
key = adjustedKey.toString(); 
}
if (keyLength > textLength) {
key = key.substring(0, textLength); 
}
return key; 
}
public static String stringEncryption(String text, String key) {
key = adjustKeyLength(text, key); 
StringBuilder cipherText = new StringBuilder();
for (int i = 0; i < text.length(); i++) {
int cipherValue = (text.charAt(i) - 'A' + key.charAt(i) - 'A') % 26;
cipherText.append((char) (cipherValue + 'A')); 
}
return cipherText.toString();
}
public static String stringDecryption(String cipherText, String key) {
key = adjustKeyLength(cipherText, key); 
StringBuilder plainText = new StringBuilder();
for (int i = 0; i < cipherText.length(); i++) {
int plainValue = (cipherText.charAt(i) - 'A' - (key.charAt(i) - 'A') + 26) % 26;
plainText.append((char) (plainValue + 'A')); 
}
return plainText.toString(); 
}
public static void main(String[] args) {
Scanner sc=new Scanner(System.in);
System.out.println("Enter plain text: ");
String plainText = sc.nextLine();
System.out.println("Enter key: ");
String key = sc.nextLine();
String encryptedText = stringEncryption(plainText.toUpperCase(), key.toUpperCase());
System.out.println("Cipher Text - " + encryptedText);
String decryptedMessage = stringDecryption(encryptedText.toUpperCase(), key.toUpperCase());
System.out.println("Decrypted Message - " + decryptedMessage);
}
}

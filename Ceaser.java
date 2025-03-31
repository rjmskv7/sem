import java.util.Scanner;

class CaesarCipher {
    public static String encryptData(String inputStr, int shiftKey) {
        StringBuilder encryptStr = new StringBuilder();
        
        for (int i = 0; i < inputStr.length(); i++) {
            char ch = inputStr.charAt(i);
            
            if (Character.isLetter(ch)) {
                char base = Character.isUpperCase(ch) ? 'A' : 'a';
                char encryptChar = (char) ((ch - base + shiftKey) % 26 + base);
                encryptStr.append(encryptChar);
            } else {
                encryptStr.append(ch); // Keep non-alphabetic characters unchanged
            }
        }
        return encryptStr.toString();
    }

    public static String decryptData(String inputStr, int shiftKey) {
        StringBuilder decryptStr = new StringBuilder();
        
        for (int i = 0; i < inputStr.length(); i++) {
            char ch = inputStr.charAt(i);
            
            if (Character.isLetter(ch)) {
                char base = Character.isUpperCase(ch) ? 'A' : 'a';
                char decryptChar = (char) ((ch - base - shiftKey + 26) % 26 + base);
                decryptStr.append(decryptChar);
            } else {
                decryptStr.append(ch); // Keep non-alphabetic characters unchanged
            }
        }
        return decryptStr.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the shift key: ");
        int shiftKey = sc.nextInt();
        sc.nextLine(); // Consume the newline character
        
        System.out.print("Enter a message to encrypt: ");
        String message = sc.nextLine();
        
        String encryptedMessage = encryptData(message, shiftKey);
        System.out.println("Encrypted Message: " + encryptedMessage);
        
        String decryptedMessage = decryptData(encryptedMessage, shiftKey);
        System.out.println("Decrypted Message: " + decryptedMessage);

        sc.close();
    }
}

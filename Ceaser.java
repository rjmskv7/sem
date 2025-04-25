import java.util.Scanner;  
class Expt1 {
    public static final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";   
    public static String encryptData(String inputStr, int shiftKey) {      
        inputStr = inputStr.toLowerCase();   
        String encryptStr = "";     
        for (int i = 0; i < inputStr.length(); i++) {      
            int pos = ALPHABET.indexOf(inputStr.charAt(i));      
            int encryptPos = (shiftKey + pos) % 26;   
            char encryptChar = ALPHABET.charAt(encryptPos);   
            encryptStr += encryptChar;   
        }   
        return encryptStr;   
    }   
    public static String decryptData(String inputStr, int shiftKey) {      
        inputStr = inputStr.toLowerCase();   
        String decryptStr = "";      
        for (int i = 0; i < inputStr.length(); i++) {    
            int pos = ALPHABET.indexOf(inputStr.charAt(i));      
            int decryptPos = (pos - shiftKey + 26) % 26;   
            char decryptChar = ALPHABET.charAt(decryptPos);   
            decryptStr += decryptChar;   
        }   
        return decryptStr;   
    }   
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter shift key: ");
        int a = sc.nextInt();
        System.out.print("Enter string to encrypt: ");
        String b = sc.next();
        Expt1 c = new Expt1();
        String encryptedData = c.encryptData(b, a);
        System.out.println("Encrypted Data: " + encryptedData);
        String decryptedData = c.decryptData(encryptedData, a);
        System.out.println("Decrypted Data: " + decryptedData);
        System.out.println("Shift Key: " + a);
        System.out.println("Original String: " + b);
        sc.close();
    }
}


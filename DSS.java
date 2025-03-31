import java.security.*;
import java.util.Base64;
import java.util.Scanner;

public class Expt10 {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a message to sign: ");
        String message = scanner.nextLine();

        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("DSA");
        keyPairGenerator.initialize(1024);
        KeyPair keyPair = keyPairGenerator.generateKeyPair();

        PrivateKey privateKey = keyPair.getPrivate();
        PublicKey publicKey = keyPair.getPublic();
     
        Signature signature = Signature.getInstance("SHA256withDSA");
        signature.initSign(privateKey);
        signature.update(message.getBytes());
       
        byte[] signedMessage = signature.sign();
        System.out.println("Signed Message: " + Base64.getEncoder().encodeToString(signedMessage));
       
        signature.initVerify(publicKey);
        signature.update(message.getBytes());
       
        boolean isVerified = signature.verify(signedMessage);
        System.out.println("Is the signature valid? " + isVerified);
        scanner.close();
    }
}


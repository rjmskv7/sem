import java.math.BigInteger;
import java.security.SecureRandom;
public class Expt7 {
private final static BigInteger one= new BigInteger("1");
private final static SecureRandom random = new SecureRandom();
private BigInteger privateKey;
private BigInteger publicKey;
private BigInteger modulus;

RSADemo(int N) {
BigInteger p = BigInteger.probablePrime(N/2, random);
BigInteger q = BigInteger.probablePrime(N/2, random);
BigInteger phi = (p.subtract(one)).multiply(q.subtract(one));
System.out.println("prime p = " + p);
System.out.println("prime q = " + q);
modulus = p.multiply(q);
System.out.println("phi = " + phi);
publicKey = new BigInteger("65537");

privateKey = publicKey.modInverse(phi);
}
BigInteger encrypt(BigInteger message) {
return message.modPow(publicKey, modulus);
}
BigInteger decrypt(BigInteger encrypted) {
return encrypted.modPow(privateKey, modulus);
}
public String toString() {
String s = "";
s += "public = " + publicKey + "\n";
s += "private = " + privateKey + "\n";
s += "modulus = " + modulus;
return s;
}
public static void main(String[] args) {
int N = Integer.parseInt(args[0]);
RSADemo key = new RSADemo(N);
System.out.println(key);
BigInteger message = new BigInteger("8");

BigInteger encrypt = key.encrypt(message);
BigInteger decrypt = key.decrypt(encrypt);
System.out.println("message = " + message);
System.out.println("encrypted = " + encrypt);
System.out.println("decrypted = " + decrypt);
}
}


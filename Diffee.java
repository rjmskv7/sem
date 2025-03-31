import java.util.Scanner;

class Expt6 {

private static long power(long a, long b, long p) {
long result = 1;
a = a % p; 
while (b > 0) {
if ((b & 1) == 1) {
result = (result * a) % p;
}
b = b >> 1;
a = (a * a) % p; 
}
return result;
}
public static void main(String[] args) {
Scanner scanner = new Scanner(System.in);
System.out.print("Enter a prime number P: ");
long P = scanner.nextLong();
System.out.println("The value of P: " + P);
System.out.print("Enter a primitive root G for P: ");
long G = scanner.nextLong();
System.out.println("The value of G: " + G);
System.out.print("Enter Alice's private key a: ");
long a = scanner.nextLong();
System.out.println("The private key a for Alice: " + a);
long x = power(G, a, P);
System.out.print("Enter Bob's private key b: ");
long b = scanner.nextLong();
System.out.println("The private key b for Bob: " + b);
long y = power(G, b, P);
long ka = power(y, a, P); 
long kb = power(x, b, P); 

System.out.println("Secret key for Alice is: " + ka);
System.out.println("Secret key for Bob is: " + kb);

scanner.close();
}
}




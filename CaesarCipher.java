
import java.util.Scanner;
public class CaesarCipher {

    public static String encrypt(String plaintext, int key) {
        StringBuilder ciphertext = new StringBuilder();

        for (char ch : plaintext.toCharArray()) {
            if (Character.isUpperCase(ch)) {
                char c = (char) ((ch - 'A' + key) % 26 + 'A');
                ciphertext.append(c);
            } else if (Character.isLowerCase(ch)) {
                char c = (char) ((ch - 'a' + key) % 26 + 'a');
                ciphertext.append(c);
            } else {

                ciphertext.append(ch);
            }
        }
        return ciphertext.toString();
    }

    public static String decrypt(String ciphertext, int key) {
        StringBuilder plaintext = new StringBuilder();

        for (char ch : ciphertext.toCharArray()) {
            if (Character.isUpperCase(ch)) {
                char c = (char) ((ch - 'A' - key + 26) % 26 + 'A');
                plaintext.append(c);
            } else if (Character.isLowerCase(ch)) {
                char c = (char) ((ch - 'a' - key + 26) % 26 + 'a');
                plaintext.append(c);
            } else {
                plaintext.append(ch);
            }
        }
        return plaintext.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean again = true;

        while (again) {

            System.out.print("\nEnter plaintext: ");
            String plaintext = sc.nextLine();

            System.out.print("Enter key (integer shift): ");
            int key = sc.nextInt();
            sc.nextLine();

            String ciphertext = encrypt(plaintext, key);
            System.out.println("\nEncrypted Ciphertext: " + ciphertext);

            String decryptedText = decrypt(ciphertext, key);
            System.out.println("Decrypted Plaintext : " + decryptedText);

            if (decryptedText.equals(plaintext)) {
                System.out.println("\n Validation Successful: Decryption matches");
            } else {
                System.out.println("\n Validation Failed: Decryption does not match");
            }

            System.out.print("\nDo you want to try again? (Y/N): ");
            String choice = sc.nextLine().trim().toUpperCase();

            if (!choice.equals("Y")) {
                again = false;
                System.out.println("\nGoodbye!");
            }
        }

        sc.close();
    }

}

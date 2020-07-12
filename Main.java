package encryptdecrypt;

import java.util.Scanner;

public class Main {
    final static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String sentence = scanner.nextLine();
        int encryptDiff = scanner.nextInt();

        simpleEncrypt(sentence, encryptDiff);
    }

    public static void simpleEncrypt(String toEncrypt, int encryptDiff) {
        char[] toEncryptArray;
        toEncryptArray = toEncrypt.toLowerCase().toCharArray();

        for (int i = 0; i < toEncryptArray.length; i++) {
            if (toEncryptArray[i] < 123 && toEncryptArray[i] > 96) {
                for (int j = 1; j <= encryptDiff; j++) {
                    toEncryptArray[i] += 1;
                    if (toEncryptArray[i] > 122) {
                        toEncryptArray[i] = 97;
                    }
                }
            }
            System.out.printf("%c", toEncryptArray[i]);
        }
    }
}

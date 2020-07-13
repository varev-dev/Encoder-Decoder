package encryptdecrypt;

import java.util.Scanner;

public class Main {
    final static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        insertCommand();
    }

    public static void insertCommand() {
        String actionType = scanner.nextLine();

        if (actionType.equals("enc") || actionType.equals("dec")) {
            String sentence = scanner.nextLine();
            int diff = scanner.nextInt();

            if (actionType.equals("enc")) {
                simpleEncrypt(sentence, diff);
            } else if (actionType.equals("dec")) {
                simpleDecrypt(sentence, diff);
            }
        }
    }


    public static void simpleEncrypt(String toEncrypt, int encryptDiff) {
        char[] toEncryptArray;
        toEncryptArray = toEncrypt.toCharArray();

        for (int i = 0; i < toEncryptArray.length; i++) {
            for (int j = 1; j <= encryptDiff; j++) {
                    toEncryptArray[i] += 1;
                    if (toEncryptArray[i] > 126) {
                        toEncryptArray[i] = 32;
                    }
                }
            System.out.printf("%c", toEncryptArray[i]);
        }
    }

    public static void simpleDecrypt(String toDecrypt, int decryptDiff) {
        char[] toDecryptArray;
        toDecryptArray = toDecrypt.toCharArray();

        for (int i = 0; i < toDecryptArray.length; i++) {
            for (int j = 1; j <= decryptDiff; j++) {
                toDecryptArray[i] -= 1;
                if (toDecryptArray[i] < 32) {
                    toDecryptArray[i] = 126;
                }
            }
            System.out.printf("%c", toDecryptArray[i]);
        }
    }
}

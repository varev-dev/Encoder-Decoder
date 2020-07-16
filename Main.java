package encryptdecrypt;

public class Main {
    public static void main(String[] args) {
        String mode = "enc";
        int key = 0;
        String data = "";

        for (int i = 0; i < args.length; i++) {
            if (args[i].equals("-mode")) {
                mode = args[i + 1];
            } else if (args[i].equals("-key")) {
                key = Integer.parseInt(args[i + 1]);
            } else if (args[i].equals("-data")) {
                data = args[i + 1];
            }
        }

        switch (mode) {
            case "dec":
                simpleDecrypt(data, key);
                break;
            case "enc":
                simpleEncrypt(data, key);
                break;
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

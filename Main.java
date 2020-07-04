package encryptdecrypt;

public class Main {
    public static void main(String[] args) {
        String sentence = "we found a treasure!";
        simpleEncrypt(sentence);
    }

    public static void simpleEncrypt(String toEncrypt) {
        char[] toEncryptArray;
        int increase, decrease;
        toEncryptArray = toEncrypt.toLowerCase().toCharArray();

        for (int i = 0; i < toEncryptArray.length; i++) {
            if (toEncryptArray[i] < 111 && toEncryptArray[i] > 96) {
                increase = 97 + (122 - toEncryptArray[i]);
                toEncryptArray[i] = (char) increase;
                System.out.printf("%c", toEncryptArray[i]);
            }
            else if (toEncryptArray[i] > 110 && toEncryptArray[i] < 123) {
                decrease = 122 - (toEncryptArray[i] - 97);
                toEncryptArray[i] = (char) decrease;
                System.out.printf("%c", toEncryptArray[i]);
            }
            else {
                System.out.printf("%c", toEncryptArray[i]);
            }
        }
    }
}

package encryptdecrypt;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {
    static String mode = "enc";
    static String outputFile = "";
    static int key = 0;

    public static void main(String[] args) {
        String data = "";
        String algorithmType = "shift";

        for (int i = 0; i < args.length; i++) {
            switch (args[i]) {
                case "-mode":
                    mode = args[++i];
                    break;
                case "-data":
                    data = args[++i];
                    break;
                case "-in":
                    String inputFile = args[++i];
                    for (String arg : args) {
                        if (arg.equals("-data")) {
                            break;
                        } else {
                            try {
                                data = new String(Files.readAllBytes(Paths.get(inputFile)));
                            } catch (IOException e) {
                                System.out.println("Error4");
                            }
                        }
                    }
                    break;
                case "-out":
                    outputFile = args[++i];
                    break;
                case "-key":
                    try {
                        key = Integer.parseInt(args[++i]);
                    } catch (NumberFormatException e) {
                        System.out.println("Error2");
                    }
                    break;
                case "-alg":
                    algorithmType = args[++i];
                    break;
            }
        }

        String result = "";
        switch (mode) {
            case "enc":
                encrypt(data, key, result, algorithmType);
                break;
            case "dec":
                decrypt(data, key, result, algorithmType);
                break;
            default:
                System.out.println("Error3");
        }
    }

    public static void encrypt(String data, int key, String result, String algorithmType) {
        if (data.toCharArray().length != 0) {
            char[] toEncryptArray;
            toEncryptArray = data.toCharArray();

            StringBuilder resultBuilder = new StringBuilder(result);

            if (algorithmType.equals("unicode")) {
                for (int i = 0; i < toEncryptArray.length; i++) {
                    for (int j = 1; j <= key; j++) {
                        toEncryptArray[i] += 1;
                        if (toEncryptArray[i] > 126) {
                            toEncryptArray[i] = 32;
                        }
                    }
                    resultBuilder.append(toEncryptArray[i]);
                }
            } else {
                for (int i = 0; i < toEncryptArray.length; i++) {
                    if (toEncryptArray[i] >= 65 && toEncryptArray[i] <= 90) {
                        for (int j = 1; j <= key; j++) {
                            toEncryptArray[i] += 1;
                            if (toEncryptArray[i] > 90) {
                                toEncryptArray[i] = 65;
                            }
                        }
                    } else if (toEncryptArray[i] >= 97 && toEncryptArray[i] <= 122) {
                        for (int j = 1; j <= key; j++) {
                            toEncryptArray[i] += 1;
                            if (toEncryptArray[i] > 122) {
                                toEncryptArray[i] = 97;
                            }
                        }
                    }
                    resultBuilder.append(toEncryptArray[i]);
                }
            }
            result = resultBuilder.toString();

            overwriteFiles(result, outputFile);
        }
    }

    public static void decrypt(String data, int key, String result, String algorithmType) {
        if (data.toCharArray().length != 0) {
            char[] toDecryptArray;
            toDecryptArray = data.toCharArray();

            StringBuilder resultBuilder = new StringBuilder(result);

            if (algorithmType.equals("unicode")) {
                for (int i = 0; i < toDecryptArray.length; i++) {
                    for (int j = 1; j <= key; j++) {
                        toDecryptArray[i] -= 1;
                        if (toDecryptArray[i] < 32) {
                            toDecryptArray[i] = 126;
                        }
                    }
                    resultBuilder.append(toDecryptArray[i]);
                }
            } else {
                for (int i = 0; i < toDecryptArray.length; i++) {
                    if (toDecryptArray[i] >= 65 && toDecryptArray[i] <= 90) {
                        for (int j = 1; j <= key; j++) {
                            toDecryptArray[i] -= 1;
                            if (toDecryptArray[i] < 65) {
                                toDecryptArray[i] = 90;
                            }
                        }
                    } else if (toDecryptArray[i] >= 97 && toDecryptArray[i] <= 122) {
                        for (int j = 1; j <= key; j++) {
                            toDecryptArray[i] -= 1;
                            if (toDecryptArray[i] < 97) {
                                toDecryptArray[i] = 122;
                            }
                        }
                    }
                    resultBuilder.append(toDecryptArray[i]);
                }
            }
            result = resultBuilder.toString();

            overwriteFiles(result, outputFile);
        }
    }


    public static void overwriteFiles(String result, String outputFile) {
        if (outputFile.equals("")) {
            System.out.println(result);
        } else {
            try {
                File file = new File(outputFile);
                if (!file.createNewFile()) {
                    System.out.println("");
                }
                FileWriter writer = new FileWriter(file);
                writer.write(result);
                writer.close();
            } catch (IOException e) {
                System.out.println("Error5");
            }

        }
    }
}
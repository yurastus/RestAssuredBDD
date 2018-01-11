package tools;

import java.util.Random;

public class RandomGenerator {

    private static Random random = new Random();

    private RandomGenerator(){}


    public static String generateIfRandom(String value){
        return generateIfRandom(value, 10);
    }

    public static String generateIfRandom(String value, int length){

        switch (value){
            case "STRING":
                return generateString(length);
            case "INT_AS_STRING":
                return generateIntAsString(length);
            default:
                return value;
        }
    }


    private static String generateString(int length) {
        String characters = "abcdefghijklmnopqrstuvwxyz";
        char[] text = new char[length];

        for (int i = 0; i < length; i++)
            text[i] = characters.charAt(random.nextInt(characters.length()));

        return new String(text);
    }

    private static String generateIntAsString(int desiredLength){
        return generateInt(desiredLength) + "";
    }

    private static int generateInt(int desiredLength){
        return random.nextInt(desiredLength);
    }

}

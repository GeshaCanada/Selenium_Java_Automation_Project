package ua.foxminded.scarb;

import utils.RandomDataGenerator;

public class Main {
    public static void main(String[] args) {
        String randomString = RandomDataGenerator.generateRandomString(20);
        int randomNumber = RandomDataGenerator.generateRandomNumber(3,280);
        boolean randomBoolean = RandomDataGenerator.generateRandomBoolean();
        System.out.println("Random String: " + randomString);
        System.out.println("Random Number: " + randomNumber);
        System.out.println("Random Number: " + randomBoolean);
    }
}




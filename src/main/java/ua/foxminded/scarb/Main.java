package ua.foxminded.scarb;

import utils.RandomDataGenerator;

public class Main {
    public static void main(String[] args) {
        String randomString = RandomDataGenerator.generateRandomString();
        String randomNumber = RandomDataGenerator.generateRandomNumber();
        boolean randomBoolean = RandomDataGenerator.generateRandomBoolean();
        String randomPassword = RandomDataGenerator.generateStrongPassword();
        System.out.println("Random String: " + randomString);
        System.out.println("Random Number: " + randomNumber);
        System.out.println("Random Boolean: " + randomBoolean);
        System.out.println("Random Password: " + randomPassword);
    }
}




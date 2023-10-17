package utils;

import java.util.Random;

// Example for use Factory methods in main.java
public class RandomDataGenerator {
    public static String generateRandomString() {
        Random random = new Random();
        int minLength = 4;
        int maxLength = 15;
        int length = random.nextInt(maxLength - minLength + 1) + minLength; // Генерируем случайную длину от 4 до 15
        StringBuilder stringBuilder = new StringBuilder(length);

        // Генерируем первый символ (большая буква)
        int randomIndex = random.nextInt(26); // 26 - количество букв в алфавите
        char randomChar = (char) ('A' + randomIndex); // Преобразуем индекс в букву
        stringBuilder.append(randomChar);

        // Генерируем остальные символы (маленькие буквы)
        for (int i = 1; i < length; i++) {
            randomIndex = random.nextInt(26); // 26 - количество букв в алфавите
            randomChar = (char) ('a' + randomIndex); // Преобразуем индекс в букву
            stringBuilder.append(randomChar);
        }
        return stringBuilder.toString();
    }

    public static String generateRandomNumber() {

        Random random = new Random();
        int maxLength = 10;

        StringBuilder randomString = new StringBuilder(maxLength);

        // Начинаем строку с числа "2"
        randomString.append("8");

        for (int i = 1; i < maxLength; i++) {
            int randomNumber = random.nextInt(11); // Генерируем случайное число от 0 до 10
            randomString.append(randomNumber);
        }
        return randomString.toString();
    }

    public static boolean generateRandomBoolean() {
        Random random = new Random();
        return random.nextBoolean();
    }

    public static String generateStrongPassword() {
        String uppercaseChars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String lowercaseChars = "abcdefghijklmnopqrstuvwxyz";
        String specialChars = "!@#$%^&*()_-+=<>?";
        String digitChars = "0123456789";

        Random random = new Random();
        int minLength = 8;
        int length = random.nextInt(5) + minLength; // Генерируем длину от 8 до 12 символов

        StringBuilder passwordBuilder = new StringBuilder(length);

        // Добавляем минимум две большие буквы
        passwordBuilder.append(uppercaseChars.charAt(random.nextInt(uppercaseChars.length())));
        passwordBuilder.append(uppercaseChars.charAt(random.nextInt(uppercaseChars.length())));

        // Добавляем минимум две маленькие буквы
        passwordBuilder.append(lowercaseChars.charAt(random.nextInt(lowercaseChars.length())));
        passwordBuilder.append(lowercaseChars.charAt(random.nextInt(lowercaseChars.length())));

        // Добавляем один специальный символ
        passwordBuilder.append(specialChars.charAt(random.nextInt(specialChars.length())));

        // Добавляем минимум две цифры
        passwordBuilder.append(digitChars.charAt(random.nextInt(digitChars.length())));
        passwordBuilder.append(digitChars.charAt(random.nextInt(digitChars.length())));

        // Заполняем остаток пароля случайными символами
        for (int i = 7; i < length; i++) {
            String allChars = uppercaseChars + lowercaseChars + specialChars + digitChars;
            passwordBuilder.append(allChars.charAt(random.nextInt(allChars.length())));
        }

        return passwordBuilder.toString();
    }

}

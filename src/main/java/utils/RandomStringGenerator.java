package utils;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.text.WordUtils;

import java.util.Random;


public class RandomStringGenerator {
    public static String generateRandomEmail() {
        String generatedString = RandomStringUtils.randomAlphabetic(10).toLowerCase();
        return generatedString + "@skarb.ngo";
    }

    public static String generateRandomString() {
        String randomString = RandomStringUtils.randomAlphabetic(7).toLowerCase();
        return WordUtils.capitalize(randomString);
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

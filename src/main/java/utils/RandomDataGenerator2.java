package utils;


import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.text.WordUtils;


public class RandomDataGenerator2 {
    public static String generateRandomEmail() {
        String generatedString = RandomStringUtils.randomAlphabetic(10).toLowerCase();
        return generatedString + "@skarb.ngo";
    }

    public static String generateRandomString1() {
        String randomString = RandomStringUtils.randomAlphabetic(7).toLowerCase();
        return WordUtils.capitalize(randomString);
    }

    public static String generateRandomString2() {
        String randomString2 = RandomStringUtils.randomAlphabetic(5).toLowerCase();
        return WordUtils.capitalize(randomString2);
    }



}

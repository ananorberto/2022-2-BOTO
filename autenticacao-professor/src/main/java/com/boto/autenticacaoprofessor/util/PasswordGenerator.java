package com.boto.autenticacaoprofessor.util;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PasswordGenerator {
    private static final String UPPERCASE_LETTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String LOWERCASE_LETTERS = "abcdefghijklmnopqrstuvwxyz";
    private static final String NUMBERS = "0123456789";
    private static final String SYMBOLS = "!@#$%^&*()_+";

    public String generatePassword(int length) {
        SecureRandom random = new SecureRandom();
        List<Character> passwordChars = new ArrayList<>();

        passwordChars.add(getRandomCharacter(UPPERCASE_LETTERS, random));
        passwordChars.add(getRandomCharacter(LOWERCASE_LETTERS, random));
        passwordChars.add(getRandomCharacter(NUMBERS, random));
        passwordChars.add(getRandomCharacter(SYMBOLS, random));

        for (int i = 4; i < length; i++) {
            String allChars = UPPERCASE_LETTERS + LOWERCASE_LETTERS + NUMBERS + SYMBOLS;
            char randomChar = getRandomCharacter(allChars, random);
            passwordChars.add(randomChar);
        }

        Collections.shuffle(passwordChars);
        StringBuilder passwordBuilder = new StringBuilder();
        for (Character c : passwordChars) {
            passwordBuilder.append(c);
        }

        return passwordBuilder.toString();
    }

    private char getRandomCharacter(String characters, SecureRandom random) {
        int randomIndex = random.nextInt(characters.length());
        return characters.charAt(randomIndex);
    }
}
package com.boto.autenticacaoprofessor.util;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;


public class PasswordGeneratorTest {

    @Test
    public void testGeneratePassword() {
        PasswordGenerator generator = new PasswordGenerator();
        String password = generator.generatePassword(8); 
        assertEquals(8, password.length());
    }
    @Test
    public void testGeneratePasswordContainsUppercase() {
        PasswordGenerator generator = new PasswordGenerator();
        String password = generator.generatePassword(8); 
        assertEquals(8, password.length());
        assertTrue(password.matches(".*[A-Z].*"));
    }
    @Test
    public void testGeneratePasswordContainsUppercaseAndLowercase() {
        PasswordGenerator generator = new PasswordGenerator();
        String password = generator.generatePassword(8); 
        assertEquals(8, password.length());
        assertTrue(password.matches(".*[A-Z].*"));
        assertTrue(password.matches(".*[a-z].*"));
    }
    @Test
    public void testGeneratePasswordContainsUppercaseLowercaseAndNumbers() {
        PasswordGenerator generator = new PasswordGenerator();
        String password = generator.generatePassword(8); 
        assertEquals(8, password.length());
        assertTrue(password.matches(".*[A-Z].*"));
        assertTrue(password.matches(".*[a-z].*"));
        assertTrue(password.matches(".*\\d.*"));
    }
    @Test
    public void testGeneratePasswordContainsUppercaseLowercaseAndSymbols() {
        PasswordGenerator generator = new PasswordGenerator();
        String password = generator.generatePassword(8);  
        assertEquals(8, password.length());
        assertTrue(password.matches(".*[A-Z].*"));
        assertTrue(password.matches(".*[a-z].*"));
        assertTrue(password.matches(".*[!@#$%^&*()_+].*"));
    }
    @Test
    public void testGeneratePasswordContainsAllTypesIncluded() {
        PasswordGenerator generator = new PasswordGenerator();
        String password = generator.generatePassword(12);

        assertEquals(12, password.length());

        assertTrue(password.matches(".*[A-Z].*"));
        assertTrue(password.matches(".*[a-z].*"));
        assertTrue(password.matches(".*\\d.*"));
        assertTrue(password.matches(".*[!@#$%^&*()_+].*"));
    }
    
}
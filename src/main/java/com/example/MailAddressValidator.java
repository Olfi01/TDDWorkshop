package com.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * To be valid, an e-mail address needs to have:
 * A recipient name:
 *      max. 64 characters
 *      consisting of:
 *          Uppercase and lowercase english letters (A-Z, a-z)
 *          Digits from 0 to 9
 *          Special characters: ! # $ % & ' * + - / = ? ^ _ ` { |
 *              Special characters may NOT appear more than once consecutively.
 *          ignored  for this exercise: alternative special characters that might be further restricted and could be
 *          rejected depending on mail server, like " ( ) , : ; < > @ [ \ ]
 * an @ symbol
 * a domain name:
 *      max. 253 characters
 *      consisting of:
 *          Uppercase and lowercase english letters (A-Z, a-z)
 *          Digits from 0 to 9
 *          A hyphen (-)
 *          A period (.), used to identify subdomains
 * a top level domain
 */
public class MailAddressValidator {
    private static final List<Character> specialCharacters = List.of('!', '#', '$', '%', '&', '\'', '*', '-', '/', '=', '?', '^', '_', '`', '{', '|');

    public boolean isValidEmailAddress(String address) {
        if (!address.contains("@")) return false;
        String[] split = address.split("@");
        if (split[0].isEmpty()) return false;
        if (split[0].length() > 64) return false;
        if (!split[0].matches("[A-Za-z0-9!#$%&'*\\-/=?^_`{|]+")) return false;
        if (specialCharacters.stream().anyMatch((Character c) -> split[0].contains(c + "" + c))) return false;
        return true;
    }
}

package com.example;

import java.util.Arrays;

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
    public boolean isValidEmailAddress(String address) {
        if (!address.contains("@")) return false;

        String recipientName = address.split("@")[0];
        if(recipientName.length() > 64)  return false;


        // Special chars in recipient name
        String[] specialChars = {"!", "#", "$",  "%", "&" , "'", "*", "+", "-", "/", "=", "?", "^", "_", "`", "{", "|"};
        for(String specialChar1: specialChars) {
            for(String specialChar2: specialChars) {
                String forbiddenConsChars = specialChar1 + specialChar2;
                if(recipientName.contains(forbiddenConsChars)) {
                    return false;
                }
            }
        }

        // max lenght domain name
        String domainName = address.split("@")[1];
        if(domainName.length() > 253) return false;

        return true;
    }
}

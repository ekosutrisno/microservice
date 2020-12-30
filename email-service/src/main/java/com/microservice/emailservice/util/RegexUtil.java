package com.microservice.emailservice.util;

import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * The type Regex util.
 */
public class RegexUtil {

    /**
     * Validate email boolean.
     *
     * @param email the email
     * @return the boolean
     */
    public static boolean validateEmail(String email) {

    String EMAIL_REGEX = "^[\\w-+]+(\\.[\\w]+)*@[\\w-]+(\\.[\\w]+)*(\\.[a-z]{2,})$";
    Pattern pattern = Pattern.compile(EMAIL_REGEX, Pattern.CASE_INSENSITIVE);
    Matcher matcher = pattern.matcher(email);
    return matcher.matches();
  }

    /**
     * Valid username boolean.
     *
     * @param username the username
     * @return the boolean
     */
    public static boolean validUsername(String username) {
    String USERNAME_REGEX = "[A-Za-z0-9_]+";
    return username.matches(USERNAME_REGEX);
  }

    /**
     * Validate password boolean.
     *
     * @param password the password
     * @param maps     the maps
     * @return the boolean
     */
    public static boolean validatePassword(String password, Map<String, String> maps) {
    Pattern spesialCharPattern = Pattern.compile("[^a-z0-9]", Pattern.CASE_INSENSITIVE);
    Pattern upperCasePattern = Pattern.compile("[A-Z ]");
    Pattern lowerCasePattern = Pattern.compile("[a-z ]");
    Pattern digitalCasePattern = Pattern.compile("[0-9 ]");

    boolean kondisi = true;

    if (password.isEmpty()) {
      maps.put("errorMessage", "Password tidak boleh kosong");
      kondisi = false;
    } else if (password.length() < 6) {
      maps.put("errorMessage", "Password minimal 6 karakter");
      kondisi = false;
    } else if (!spesialCharPattern.matcher(password).find()) {
      maps.put("errorMessage", "Password minimal terdapat 1 karakter spesial karakter");
      kondisi = false;
    } else if (!upperCasePattern.matcher(password).find()) {
      maps.put("errorMessage", "Password minimal terdapat 1 karakter Hurup Kapital");
      kondisi = false;
    } else if (!lowerCasePattern.matcher(password).find()) {
      maps.put("errorMessage", "Password minimal terdapat 1 karakter hurup kecil");
      kondisi = false;
    } else if (!digitalCasePattern.matcher(password).find()) {
      maps.put("errorMessage", "Password minimal terdapat 1 karakter angka");
      kondisi = false;
    }
    return kondisi;
  }

}
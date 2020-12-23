package com.microservice.emailservice.util;

import java.security.SecureRandom;
import java.util.Random;

/**
 * RandomUtil buat custom kode konfimasi
 */
public class RandomUtil {

  private static final String CHAR_LOWER = "abcdefghijklmnopqrstuvwxyz";
  private static final String CHAR_UPPER = CHAR_LOWER.toUpperCase();
  private static final String NUMBER = "0123456789";

  private static final String DATA_FOR_RANDOM_STRING = CHAR_LOWER + CHAR_UPPER + NUMBER;
  private static final SecureRandom random = new SecureRandom();

  /**
   * Generate random string string.
   *
   * @return the string
   */
  public static String generateRandomString() {

    int batasAwal = 97; // dimulai dari hurup 'a'
    int batasAkhir = 122; // diakhiri dengan hurup 'z'
    int targetPanjangString = 8; // banyak generate yang dihasilkan

    Random random = new Random();

    StringBuilder buffer = new StringBuilder(targetPanjangString);

    for (int index = 0; index < targetPanjangString; index++) {
      int randomLimitedInt = batasAwal + (int) (random.nextFloat() * (batasAkhir - batasAwal + 1));
      buffer.append((char) randomLimitedInt);
    }

    String generetedString = buffer.toString();
    return generetedString.toUpperCase();
  }

  /**
   * Generate random string number string.
   *
   * @param panjang the panjang
   * @return the string
   */
  public static String generateRandomStringNumber(int panjang) {
    if (panjang < 1)
      throw new IllegalArgumentException();

    StringBuilder angkaString = new StringBuilder(panjang);
    for (int i = 0; i < panjang; i++) {
      // 0-62 (bersifat langsung), random mengembalikan 0-61
      int randomCharAt = random.nextInt(DATA_FOR_RANDOM_STRING.length());

      char randomChar = DATA_FOR_RANDOM_STRING.charAt(randomCharAt);
      angkaString.append(randomChar);
    }

    return angkaString.toString();
  }

}
package bokoff.il.utils;

import java.util.List;
import java.util.Random;

public class RandomUtils {

  public static String getRandomString(int length) {
    String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
    StringBuilder result = new StringBuilder();
    Random rnd = new Random();
    while (result.length() < length) {
      int index = (int) (rnd.nextFloat() * SALTCHARS.length());
      result.append(SALTCHARS.charAt(index));
    }
    return result.toString();
  }

  public static String getRandomPhone(int length) {
    String SALTCHARS = "1234567890";
    StringBuilder result = new StringBuilder();
    Random rnd = new Random();
    while (result.length() < length) {
      int index = (int) (rnd.nextFloat() * SALTCHARS.length());
      result.append(SALTCHARS.charAt(index));
    }
    return result.toString();
  }

  public static String getRandomInt(int min, int max) {
    Random r = new Random();
    int result = r.nextInt((max - min) + 1) + min;
    return Integer.toString(result);
  }

  public static String getMonth() {
    Random r = new Random();
    List<String> month =List.of("January", "February", "March", "April",
                                "May","June", "July", "August", "September",
                                "October", "November", "December");
    int index = r.nextInt(month.size());
    return month.get(index);
  }
  public static String getGender() {
    Random r = new Random();
    List<String> gender =List.of("Male", "Female", "Other");
    int index = r.nextInt(gender.size());
    return gender.get(index);
  }

  public static String getHobby() {
    Random r = new Random();
    List<String> hobby =List.of("Sports", "Reading", "Music");
    int index = r.nextInt(hobby.size());

    return hobby.get(index);
  }

  public static String getState() {
    Random r = new Random();
    List<String> state =List.of("NCR", "Uttar Pradesh", "Haryana","Rajasthan");
    int index = r.nextInt(state.size());
    return state.get(index);
  }

  public static String getCity(String state) {
    Random r = new Random();
    List<String> city=List.of();
    switch (state){
      case "NCR":
        city =List.of("Delhi", "Gurgaon", "Noida");
        break;
      case "Uttar Pradesh":
        city =List.of("Agra", "Lucknow", "Merrut");
        break;
      case "Haryana":
        city =List.of("Karnal", "Panipat");
        break;
      case "Rajasthan":
        city =List.of("Jaipur", "Jaiselmer");
        break;
    }
    int index = r.nextInt(city.size());
    return city.get(index);
  }
}


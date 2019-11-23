package company.klarna;

public class Challenge {

  private static final String ST = "st";

  private static final String ND = "nd";

  private static final String RD = "rd";

  private static final String TH = "th";

  public static String numberToOrdinal(Integer number) {
    if (number < 0) {
      throw new IllegalArgumentException("Only accept non-negative number");
    }
    if (number == 0) {
      return "0";
    }
    int lastTwoDigits = number % 100;
    return number + generateSuffix(lastTwoDigits);
  }

  /**
   * generate the suffix based on the last two digits of the original number
   *
   * @param number the number between 0 and 99
   * @return the suffix
   */
  static String generateSuffix(int number) {
    //special case,
    if (number > 10 && number < 20) {
      return TH;
    }
    int lastDigit = number % 10;
    switch (lastDigit) {
      case 0:
        return TH;
      case 1:
        return ST;
      case 2:
        return ND;
      case 3:
        return RD;
      default:
        return TH;
    }
  }
}

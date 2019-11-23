package company.klarna;

public class CreditCard {

  private static char MASK = '#';

  public static String maskify(String creditCardNumber) {
    if (isBlank(creditCardNumber)) {
      return "";
    }
    int length = creditCardNumber.length();
    if (length < 6) {
      return creditCardNumber;
    }
    StringBuilder newCardNumberBuilder = new StringBuilder();
    for (int i = 0; i < length; i++) {
      if (i == 0 || i >= length - 4) {
        newCardNumberBuilder.append(creditCardNumber.charAt(i));
        continue;
      }
      char currentChar = creditCardNumber.charAt(i);
      if (Character.isDigit(currentChar)) {
        newCardNumberBuilder.append(MASK);
      } else {
        newCardNumberBuilder.append(currentChar);
      }
    }
    return newCardNumberBuilder.toString();
  }

  private static boolean isBlank(String s) {
    return s == null || s.length() == 0;
  }

}

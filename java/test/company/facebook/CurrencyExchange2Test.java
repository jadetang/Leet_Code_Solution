package company.facebook;

import static org.junit.Assert.assertEquals;

import company.facebook.CurrencyExchange2.Rate;
import org.junit.Test;

public class CurrencyExchange2Test {

  Rate rate1 = new Rate("USD", "EUR", 0.9);
  Rate rate2 = new Rate("EUR", "CAD", 1.46);
  Rate rate3 = new Rate("EUR", "JPY", 120D);
  Rate rate4 = new Rate("USD", "JPY", 130D);

  @Test
  public void change() {
    var change = new CurrencyExchange2();
    var rest = change.change("CAD", "USD", new Rate[]{rate1, rate2});
    assertEquals(0.76D, rest, 0.009);
  }

  @Test
  public void change2() {
    var change = new CurrencyExchange2();
    var rest = change.change("USD", "JPY", new Rate[]{rate1, rate3, rate4});
    assertEquals(130, rest, 0.009);
  }
}
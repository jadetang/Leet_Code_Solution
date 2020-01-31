package company.klarna;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class CreditCardTest {

  @Test
  public void shouldMaskDigitsForBasicCreditCards() {
    assertEquals("5###########0694", CreditCard.maskify("5512103073210694"));
  }

  @Test
  public void shouldNotMaskDigitsForShortCreditCards() {
    assertEquals("54321", CreditCard.maskify("54321"));
  }


  @Test
  public void shouldOnlyMaskDigits() {
    assertEquals("ABCD-EFGH-IJKLM-NOPQ", CreditCard.maskify("ABCD-EFGH-IJKLM-NOPQ"));
  }

  @Test
  public void shouldOnlyMaskDigitsInMixString() {
    assertEquals("A#######BCDEFG89HI", CreditCard.maskify("A1234567BCDEFG89HI"));
  }

  @Test
  public void shouldReturnEmptyWhenCreditCardIsEmpty() {
    assertEquals("", CreditCard.maskify(""));
    assertEquals("", CreditCard.maskify(null));
  }

  @Test
  public void shouldReturnTheOringalCreditCardWhenThereIsNoNumber() {
    assertEquals("Skippy", CreditCard.maskify("Skippy"));
  }

}
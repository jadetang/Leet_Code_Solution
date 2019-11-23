package company.klarna;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ChallengeTest {

  @Test
  public void shouldHandleNormalCases() {
    assertEquals("21st", Challenge.numberToOrdinal(21));
    assertEquals("222nd", Challenge.numberToOrdinal(222));
    assertEquals("3333rd", Challenge.numberToOrdinal(3333));
    assertEquals("3334th", Challenge.numberToOrdinal(3334));
  }

  @Test
  public void shouldHandleZero() {
    assertEquals("0", Challenge.numberToOrdinal(0));
    assertEquals("1000th", Challenge.numberToOrdinal(1000));
    assertEquals("20th", Challenge.numberToOrdinal(20));
  }

  @Test
  public void shouldHandleSecondLastDigitIsOne() {
    assertEquals("11th", Challenge.numberToOrdinal(11));
    assertEquals("12th", Challenge.numberToOrdinal(12));
    assertEquals("13th", Challenge.numberToOrdinal(13));
    assertEquals("14th", Challenge.numberToOrdinal(14));
    assertEquals("1111th", Challenge.numberToOrdinal(1111));
    assertEquals("1112th", Challenge.numberToOrdinal(1112));
  }

  @Test
  public void shouldHandleLastDigitIsOne() {
    assertEquals("21st", Challenge.numberToOrdinal(21));
    assertEquals("31st", Challenge.numberToOrdinal(31));
    assertEquals("41st", Challenge.numberToOrdinal(41));
    assertEquals("441st", Challenge.numberToOrdinal(441));
  }

  @Test(expected = IllegalArgumentException.class)
  public void shouldHandleNegativeValue() {
    Challenge.numberToOrdinal(-1);
  }
}
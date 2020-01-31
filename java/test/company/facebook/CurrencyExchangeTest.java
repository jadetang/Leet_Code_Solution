package company.facebook;

import static org.junit.Assert.*;

import org.junit.Test;

public class CurrencyExchangeTest {

    String[][] rates = new String[][] {{"USD","EUR"}, {"EUR", "JPY"}, {"USD", "JPY"},{"USD","CNY"},{"CAD", "ANYTHING"}};

    @Test
    public void canChange() {
        CurrencyExchange exchange = new CurrencyExchange(rates);
        assertTrue(exchange.canChange("USD", "JPY"));
        assertTrue(exchange.canChange("USD", "CNY"));
    }

    @Test
    public void canNotChange() {
        CurrencyExchange exchange = new CurrencyExchange(rates);
        assertFalse(exchange.canChange("USD", "CAD"));
        assertFalse(exchange.canChange("USD", "CAD"));
    }
}
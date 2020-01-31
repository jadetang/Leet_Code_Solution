package solution;

import static org.junit.Assert.*;

import org.junit.Test;

public class _1271_HexspeakTest {

    _1271_Hexspeak q = new _1271_Hexspeak();
    @Test
    public void toHexspeak() {
        assertEquals("IOI", q.toHexspeak("257"));
        assertEquals("ERROR", q.toHexspeak("3"));
    }
}
package company.booking;

import static org.junit.Assert.*;

import company.amazon.UniqueNumberInStream;
import org.junit.Test;

public class UniqueNumberInStreamTest {

    @Test
    public void getFirstUniqueNumber() {
        UniqueNumberInStream u = new UniqueNumberInStream();
        u.add(1);
        assertEquals(Integer.valueOf(1), u.getFirstUniqueNumber());
    }

    @Test
    public void test2() {
        UniqueNumberInStream u = new UniqueNumberInStream();
        u.add(1);
        assertEquals(Integer.valueOf(1), u.getFirstUniqueNumber());
        u.add(2);
        u.add(1);
        assertEquals(Integer.valueOf(2), u.getFirstUniqueNumber());
    }

    @Test
    public void test3() {
        UniqueNumberInStream u = new UniqueNumberInStream();
        u.add(1);
        assertEquals(Integer.valueOf(1), u.getFirstUniqueNumber());
        u.add(2);
        u.add(3);
        u.add(1);
        assertEquals(Integer.valueOf(2), u.getFirstUniqueNumber());
        u.add(2);
        assertEquals(Integer.valueOf(3), u.getFirstUniqueNumber());
    }
}
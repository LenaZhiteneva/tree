import org.junit.jupiter.api.Test;
import ru.ac.uniyar.mf.lzh.Main;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class test_for_calculator
{
    @Test
    void test1 ()
    {
        String actual = Main.calculate("2", "+", "2");
        assertEquals("4", actual);
    }
    @Test
    void test2 ()
    {
        String actual = Main.calculate("-2", "+", "1");
        assertEquals("-1", actual);
    }
    @Test
    void test3 ()
    {
        String actual = Main.calculate("3", "*", "2");
        assertEquals("6", actual);
    }
    @Test
    void test4 ()
    {
        String actual = Main.calculate("6", "/", "2");
        assertEquals("3", actual);
    }
    @Test
    void test5 ()
    {
        String actual = Main.calculate("2", "/", "0");
        assertEquals("Division by zero", actual);
    }
    @Test
    void test6 ()
    {
        String actual = Main.calculate("1/2", "+", "1/4");
        assertEquals("3/4", actual);
    }
    @Test
    void test7 ()
    {
        String actual = Main.calculate("1/2", "-", "1");
        assertEquals("-1/2", actual);
    }
    @Test
    void test8 ()
    {
        String actual = Main.calculate("1/0", "+", "1");
        assertEquals("Division by zero", actual);
    }
    @Test
    void test9 ()
    {
        String actual = Main.calculate("1/2", "/", "1/2");
        assertEquals("1", actual);
    }
}

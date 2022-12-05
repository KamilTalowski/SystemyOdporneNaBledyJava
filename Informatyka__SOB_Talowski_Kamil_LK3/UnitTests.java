package testyJednostkowe;

import org.junit.Assert;
import org.junit.Test;

import java.util.EmptyStackException;

import static org.junit.Assert.*;

public class UnitTests {

    @Test(expected = EmptyStackException.class)
    public void stosTest1() {
        Stos s = new Stos();
        String rpp = "rampampam";
        s.push(rpp);
        assertEquals(rpp, s.top());
        assertEquals(rpp, s.top());
        assertEquals(rpp, s.top());
        assertFalse(s.isEmpty());
        String poped = s.pop();
        assertSame(poped, rpp);
        assertTrue(s.isEmpty());
        s.pop();
    }

    @Test
    public void stosTest2() {
        Stos s = new Stos();
        String ram = "ram";
        String pam = "pam";
        String pan = "pan";
        s.push("ram");
        s.push("pam");
        s.push("pan");
        assertSame(pan, s.pop());
        assertSame(pam, s.pop());
        assertSame(ram, s.pop());
        s.push(null);
        assertNull(s.pop());
        try {
            s.pop();
        }catch (EmptyStackException e){
            s.push("ram");
            s.push("pam");
            s.push("pan");
            assertSame(pan, s.pop());
            assertSame(pam, s.pop());
            assertSame(ram, s.pop());
        }
    }

    @Test
    public void onpTest() {
        String infix = "10-3*2/(11-5)=";
        Onp.toONP(infix);
        assertEquals(9.0, Onp.calcONP(), 0.001);
    }

    @Test
    public void onpFloatingTest() {
        String infix = "10*1.5+3-6/2.5=";
        Onp.toONP(infix);
        assertEquals(15.6, Onp.calcONP(), 0.001);
    }
}


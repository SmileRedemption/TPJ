package Lab1;


import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class TestMain {

    @Test
    void testIsPrimary(){
        assertTrue(Main.isPrime(2));
        assertFalse(Main.isPrime(1));
        assertTrue(Main.isPrime(5));
        assertTrue(Main.isPrime(17));
        assertFalse(Main.isPrime(100));
    }


}

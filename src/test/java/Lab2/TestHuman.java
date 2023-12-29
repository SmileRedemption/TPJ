package Lab2;

import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.jupiter.api.Test;

public class TestHuman {
    @Test
    void testEquals(){
        EqualsVerifier.simple().forClass(Person.class).verify();
    }
}

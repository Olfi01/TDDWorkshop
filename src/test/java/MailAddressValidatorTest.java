import com.example.MailAddressValidator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MailAddressValidatorTest {
    @Test
    public void test() {
        // Arrange
        MailAddressValidator validator = new MailAddressValidator();
        String address = "florian.meyer@capgemini.com";

        // Act
        boolean result = validator.isValidEmailAddress(address);

        // Assert
        assertTrue(result);
    }

    @Test
    public void testForAtSymbol() {
        // Arrange
        MailAddressValidator validator = new MailAddressValidator();
        String adress = "florian.meyercapgemini.com";

        // Act
        boolean result = validator.isValidEmailAddress(adress);

        assertFalse(result);
    }

    @Test
    public void testForMaxLength() {
        // Arrange
        MailAddressValidator validator = new MailAddressValidator();
        String adress = "florian.meyercapgeminiflorian.meyercapgeminiflorian.meyercapgeminiflorian.meyercapgeminiflorian.meyercapgeminiflorian.meyercapgeminiflorian.meyercapgeminiflorian.meyercapgemini@.com";

        // Act
        boolean result = validator.isValidEmailAddress(adress);

        assertFalse(result);
    }

    @Test
    public void testForConsecutiveSpecialChars() {
        // Arrange
        MailAddressValidator validator = new MailAddressValidator();
        String adress = "florian.meyercapgemini!?@.com";

        // Act
        boolean result = validator.isValidEmailAddress(adress);

        assertFalse(result);
    }



}

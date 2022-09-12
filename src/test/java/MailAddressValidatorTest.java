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
        String address = "florian.meyercapgemini.com";

        // Act
        boolean result = validator.isValidEmailAddress(address);

        // Assert
        assertFalse(result);
    }

    @Test
    public void shouldHaveRecipientName() {
        // Arrange
        MailAddressValidator validator = new MailAddressValidator();
        String address = "@capgemini.com";

        // Act
        boolean result = validator.isValidEmailAddress(address);

        // Assert
        assertFalse(result);
    }

    @Test
    public void shouldHaveValidRecipientName() {
        // Arrange
        MailAddressValidator validator = new MailAddressValidator();
        String address = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa@capgemini.com";

        // Act
        boolean result = validator.isValidEmailAddress(address);

        // Assert
        assertFalse(result);
    }

    @Test
    public void shouldHaveValidRecipientName1() {
        // Arrange
        MailAddressValidator validator = new MailAddressValidator();
        String address = "florian§meyer@capgemini.com";

        // Act
        boolean result = validator.isValidEmailAddress(address);

        // Assert
        assertFalse(result);
    }

    @Test
    public void shouldHaveValidRecipientName2() {
        // Arrange
        MailAddressValidator validator = new MailAddressValidator();
        String address = "florian!!meyer@capgemini.com";

        // Act
        boolean result = validator.isValidEmailAddress(address);

        // Assert
        assertFalse(result);
    }
}

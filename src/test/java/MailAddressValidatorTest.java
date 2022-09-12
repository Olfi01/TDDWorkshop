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
}

import com.example.MailAddressValidator;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.util.StringUtils;

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
    public void testForRecipientName() {
        MailAddressValidator validator = new MailAddressValidator();
        String longEmail = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa@a.c";

        String shortEmail = "a.a@a.c";

        boolean resultLongEmail = validator.isValidEmailAddress(longEmail);
        boolean resultShortEmail = validator.isValidEmailAddress(shortEmail);

        assertFalse(resultLongEmail);
        assertTrue(resultShortEmail);
    }

    @Test
    public void testForDomainName() {
        MailAddressValidator validator = new MailAddressValidator();
        String email =  "a.b@" + new StringBuilder(254).toString();

        boolean result = validator.isValidEmailAddress(email);

        assertTrue(result);
    }
}

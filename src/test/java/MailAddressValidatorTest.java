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

        // Assert
        assertFalse(result);
    }

    @Test
    public void recipientNameLenght(){
        //Arrange
        MailAddressValidator validator = new MailAddressValidator();
        String adress = "florian.meyerfurchtbarlangerstringderüber64charadcterhatalsohoffentlichichwillnichtzählen@capgemini.com";

        //Act
        boolean result = validator.isValidEmailAddress(adress);

        // Assert
        assertFalse(result);
    }

    @Test
    public void recipientNameIllegalCharacterDoubleSymbol(){
        //Arrange
        MailAddressValidator validator = new MailAddressValidator();
        String adress = "florian.meyer__@capgemini.com";

        //Act
        boolean result = validator.isValidEmailAddress(adress);

        // Assert
        assertFalse(result);
    }

    @Test
    public void recipientNameIllegalCharacter(){
        //Arrange
        MailAddressValidator validator = new MailAddressValidator();
        String adress = "florian.meyerü@capgemini.com";

        //Act
        boolean result = validator.isValidEmailAddress(adress);

        // Assert
        assertFalse(result);
    }
}

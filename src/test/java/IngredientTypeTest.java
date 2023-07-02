import praktikum.IngredientType;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import static org.junit.Assert.assertNotNull;

@RunWith(MockitoJUnitRunner.class)
public class IngredientTypeTest {

    @Test
    public void testSauce() {
        assertNotNull(IngredientType.SAUCE);
    }

    @Test
    public void testFilling() {
        assertNotNull(IngredientType.FILLING);
    }

}

import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    private Burger burger;
    @Mock
    private Bun bun;
    @Mock
    private Ingredient sauce;
    @Mock
    private Ingredient filling;

    String bunName     = "bunTestName";
    String sauceName   = "sauceTestName";
    String fillingName = "fillingTestName";

    float bunPrice     = 100;
    float saucePrice   = 200;
    float fillingPrice = 300;
    float burgerPrice  = bunPrice + saucePrice + fillingPrice + bunPrice;

    @Before
    public void start() {
        MockitoAnnotations.initMocks(this);
        when(bun.getName()).thenReturn(bunName);
        when(bun.getPrice()).thenReturn(bunPrice);
        when(sauce.getType()).thenReturn(IngredientType.SAUCE);
        when(sauce.getName()).thenReturn(sauceName);
        when(sauce.getPrice()).thenReturn(saucePrice);
        when(filling.getType()).thenReturn(IngredientType.FILLING);
        when(filling.getName()).thenReturn(fillingName);
        when(filling.getPrice()).thenReturn(fillingPrice);
        burger = new Burger();
        burger.setBuns(bun);
        burger.setBuns(bun);
        burger.addIngredient(sauce);
        burger.addIngredient(filling);
    }

    @Test
    public void testSetBuns() {
        burger.setBuns(bun);
        assertEquals(bun, burger.bun);
    }

    @Test
    public void testGetPrice() {
        assertEquals(burgerPrice, burger.getPrice(), 0.);
    }

    @Test
    public void testGetReceipt() {
        String expectedReceipt = String.format(
                "(==== " + bunName + " ====)%n" +
                        "= sauce " + sauceName + " =%n" +
                        "= filling " + fillingName + " =%n" +
                        "(==== " + bunName + " ====)%n" +
                        "%nPrice: 700,000000%n"
        );

        assertEquals(expectedReceipt, burger.getReceipt());
    }

    @Test
    public void testRemoveIngredient() {
        burger.removeIngredient(0);

        String expectedReceipt = String.format(
                "(==== " + bunName + " ====)%n" +
                        "= filling " + fillingName + " =%n" +
                        "(==== " + bunName + " ====)%n" +
                        "%n" +
                        "Price: 500,000000%n"
        );

        assertEquals(expectedReceipt, burger.getReceipt());
    }

    @Test
    public void testMoveIngredient() {
        burger.moveIngredient(1, 0);

        String expectedReceipt = String.format(
                "(==== " + bunName + " ====)%n" +
                        "= filling " + fillingName + " =%n" +
                        "= sauce " + sauceName + " =%n" +
                        "(==== " + bunName + " ====)%n" +
                        "%nPrice: 700,000000%n"
        );

        assertEquals(expectedReceipt, burger.getReceipt());
    }

    @Test
    public void testAddIngredient() {
        burger.addIngredient(sauce);
        burger.addIngredient(filling);

        String expectedReceipt = String.format(
                "(==== " + bunName + " ====)%n" +
                        "= sauce " + sauceName + " =%n" +
                        "= filling " + fillingName + " =%n" +
                        "= sauce " + sauceName + " =%n" +
                        "= filling " + fillingName + " =%n" +
                        "(==== " + bunName + " ====)%n" +
                        "%nPrice: 1200,000000%n"
        );

        assertEquals(expectedReceipt, burger.getReceipt());
    }

}

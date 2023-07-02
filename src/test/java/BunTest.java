import praktikum.Bun;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class BunTest {

    private final String bunName;
    private final float  bunPrice;

    public BunTest(String bunName, float bunPrice) {
        this.bunName  = bunName;
        this.bunPrice = bunPrice;
    }

    @Parameterized.Parameters(name = "Тестовые данные: {0} {1}")
    public static Object[][] testData() {
        return new Object[][] {
                {"булка", 100},
                {"хлеб", 99}
        };
    }

    @Test
    public void testGetName() {
        Bun bun = new Bun(bunName, bunPrice);
        assertEquals(bunName, bun.getName());
    }

    @Test
    public void testGetPrice() {
        Bun bun = new Bun(bunName, bunPrice);
        assertEquals(bunPrice, bun.getPrice(), 0);
    }

}

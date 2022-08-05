package practikumtest;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static praktikum.IngredientType.SAUCE;

public class BurgerWithMokTest extends Burger {
    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();
    @Mock
    private Ingredient ingredient;
    @Mock
    private Bun bun;
    //Burger burger;

    @Before //создаем "абстрактный" бургер
    public void setUp() {
        addIngredient(ingredient);
        addIngredient(ingredient);
        addIngredient(ingredient);
        setBuns(bun);
    }

    //Проверяем рецепт бургера, с мокированными ингредиентами
    @Test
    public void getReceiptTestWithMok() {
        Mockito.when(ingredient.getType()).thenReturn(SAUCE);
        Mockito.when(ingredient.getName()).thenReturn("Соус Spicy-X");
        Mockito.when(bun.getName()).thenReturn("Краторная булка N-200i");
        assertTrue(getReceipt().contains("Соус Spicy-X"));
        assertTrue(getReceipt().contains("Краторная булка N-200i"));
        assertTrue(getReceipt().contains(SAUCE.toString().toLowerCase()));
    }

    //Проверяем цену бургера, с мокированными ценами ингредиентов
    @Test
    public void getPriceTestWithMok() {
        Mockito.when(ingredient.getPrice()).thenReturn(199.9f);
        Mockito.when(bun.getPrice()).thenReturn(99.9f);
        assertEquals(799.5, getPrice(), 0);
    }
}

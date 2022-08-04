package practikumtest;

import org.junit.*;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;

import static org.junit.Assert.*;
import static praktikum.IngredientType.FILLING;
import static praktikum.IngredientType.SAUCE;

public class BurgerTest extends Burger{

    private static final Ingredient ingredientSauceOne = new Ingredient(SAUCE, "Соус Spicy-X", 99.99f);
    private static final Ingredient ingredientSauceTwo = new Ingredient(SAUCE, "Соус традиционный галактический", 17.00f);
    private static final Ingredient ingredientFilling = new Ingredient(FILLING, "Мини-салат Экзо-Плантаго", 3333.33f);
    private static final Bun bun = new Bun("Краторная булка N-200i", 1333.00f);

    @Before
    public void setUp() {
        addIngredient(ingredientSauceOne);
        addIngredient(ingredientSauceTwo);
        addIngredient(ingredientFilling);
        setBuns(bun);
    }

    //Проверка, что метод возвращает ингредиенты
    @Test
    public void addIngredientsTest() {
        assertEquals(ingredients.get(0), ingredientSauceOne);
        assertEquals(ingredients.get(1), ingredientSauceTwo);
        assertEquals(ingredients.get(2), ingredientFilling);
    }

    //Проверка, что метод возвращает булку
    @Test
    public void addBunTest() {
        Assert.assertEquals(bun, bun);
    }

    //Проверка, что метод возвращает
    @Test
    public void removeIngredientTest() {
        removeIngredient(0);                                         //Удаляем первый ингредиент
        assertEquals(ingredients.get(0), ingredientSauceTwo);        //Проверяем что второй ингредиент стал первым
    }

    //Проверка перемещения ингредиентов в бургере
    @Test
    public void moveIngredientTest() {
        moveIngredient(0, 2);                                        //Меняем местами ингредиенты
        assertEquals(ingredients.get(0), ingredientSauceTwo);
        assertEquals(ingredients.get(2), ingredientSauceOne);
    }
}
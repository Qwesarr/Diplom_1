package practikumtest;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import praktikum.*;

import static org.junit.Assert.assertEquals;

public class BurgerWithDataBaseDataTest extends Burger{
    private static final Database database = new Database();

    @Before
    public void setUp() {
        addIngredient(database.availableIngredients().get(0));
        addIngredient(database.availableIngredients().get(1));
        addIngredient(database.availableIngredients().get(3));
        setBuns(database.availableBuns().get(0));
    }

    //Проверка, что метод возвращает ингредиенты
    @Test
    public void addIngredientsTest() {
        assertEquals(ingredients.get(0), database.availableIngredients().get(0));
        assertEquals(ingredients.get(1), database.availableIngredients().get(1));
        assertEquals(ingredients.get(2), database.availableIngredients().get(3));
    }

    //Проверка, что метод возвращает булку
    @Test
    public void addBunTest() {
        Assert.assertEquals(bun, database.availableBuns().get(0));
    }

    //Проверка, что метод возвращает
    @Test
    public void removeIngredientTest() {
        removeIngredient(0);                                                                                      //Удаляем первый ингредиент
        assertEquals(ingredients.get(0), database.availableIngredients().get(1));                                       //Проверяем что второй ингредиент стал первым
    }

    //Проверка перемещения ингредиентов в бургере
    @Test
    public void moveIngredientTest() {
        moveIngredient(0, 2);                                                                             //Меняем местами ингредиенты
        assertEquals(ingredients.get(0), database.availableIngredients().get(1));
        assertEquals(ingredients.get(2), database.availableIngredients().get(0));
    }
}

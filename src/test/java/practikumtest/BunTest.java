package practikumtest;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import praktikum.Bun;


public class BunTest {
    private Bun bun;
    private static final String NAME = "Флюоресцентная булка R2-D3";
    private static final float PRICE = 988.55f;

    @Before
    public void setUp(){
        bun = new Bun(NAME, PRICE);
    }

    //Проверяем что метод возвращает имя созданного бургера верно
    @Test
    public void getName() {
        Assert.assertEquals(NAME, bun.getName());
    }

    //Проверяем что метод возвращает цену созданного бургера с точностью до 0
    @Test
    public void getPrice() {
        Assert.assertEquals(PRICE, bun.getPrice(), 0);
    }
}
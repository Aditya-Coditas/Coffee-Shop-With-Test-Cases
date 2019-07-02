import org.junit.BeforeClass;
import org.junit.Test;

import java.util.LinkedHashMap;

import static org.junit.jupiter.api.Assertions.*;

public class CoffeeShopTestCases {
    static CoffeeShop shop;
    static LinkedHashMap<Integer,String> menu;
    static LinkedHashMap<Integer,Integer> order;

    @BeforeClass
    public static void init()
    {
        shop=new CoffeeShop();
        menu=new LinkedHashMap<Integer, String>();
        menu.put(1,"Cold Coffee");
        menu.put(2,"Hot Coffee ");
        menu.put(3,"Mocha      ");
        menu.put(4,"Expresso   ");
        menu.put(5,"Capacuino  ");

        order=new LinkedHashMap<Integer, Integer>();
        order.put(1,2);

    }

    @Test
    public void validateOrderVid()
    {
        String str=shop.validateOrder("1:2,2:3","1:2",menu);
        System.out.println(str);
        assertEquals(str,"1:2,2:3");
    }

    @Test
    public void validateOrderInVid() {
        String str=shop.validateOrder("8:2,2:3","8:2",menu);
        System.out.println(str);
        assertNull(str);
    }

    @Test
    public void validateOrderVName()
    {
        String str=shop.validateOrder("2:2,Mocha:2","Mocha:2",menu);
        System.out.println(str);
        assertEquals(str,"2:2,Mocha:2");
    }

    @Test
    public void validateOrderInVName()
    {
        String str=shop.validateOrder("2:2,xyz:2","xyz:2",menu);
        assertNull(str);
    }

    @Test
    public void validateOrderVQuantity()
    {
        String str=shop.validateOrder("2:2","2:2",menu);
        System.out.println(str);
        assertEquals(str,"2:2");
    }

    @Test
    public void validateOrderInVQuantity()
    {
        String str=shop.validateOrder("2:-2","2:-2",menu);
        assertNull(str);
    }

    @Test
    public void validatePrdictorValidVal()
    {
        String str=shop.predictor("mo",menu);
        assertEquals(str,"Mocha");
    }

    @Test
    public void validatePrdictorInValidVal()
    {
        String str=shop.predictor("xy",menu);
        assertNull(str);
    }

    @Test
    public void validateCheckOrderDataBYIdInOrder()
    {
        assertFalse(shop.checkOrder("1","2",order,menu));
    }

    @Test
    public void validateCheckOrderValDataBYNameInOrder()
    {
        assertFalse(shop.checkOrder("Cold Coffee","2",order,menu));
    }

    @Test
    public void validateCheckOrderDataBYIdNotInOrder()
    {
        assertTrue(shop.checkOrder("2","2",order,menu));
    }

    @Test
    public void validateCheckOrderDataBYNameNotInOrder()
    {
        assertTrue(shop.checkOrder("Expresso","2",order,menu));
    }

    @Test
    public void validateGetOrderByValData()
    {
        assertTrue(shop.getOrder("1:2,3:2,Mocha:3",order,menu));
    }

    @Test
    public void validateGetOrderByInValData()
    {
        assertFalse(shop.getOrder("8:2,Mocha:2",order,menu));
    }

}

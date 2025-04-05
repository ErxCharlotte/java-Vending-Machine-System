package RE08_Group3_A2;

import RE08_Group3_A2.Product.*;
import RE08_Group3_A2.User.Seller;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

public class ProductTest {

    @Test
    void createProductTest(){
        BigDecimal price =new BigDecimal(2.5);
        Product pd = new Product("a", "Drinks", price, 1001, 10);
        pd.setDescription("i am a product");
        assertEquals(pd.getDescription(), "i am a product");
    }

    @Test
    void createDrinkTest(){
        BigDecimal price =new BigDecimal(2.5);
        Drink pd = new Drink("a", price, 1001, 10);
        assertNotNull(pd);
    }

    @Test
    void createChocolateTest(){
        BigDecimal price =new BigDecimal(2.5);
        Chocolate pd = new Chocolate("a", price, 1001, 10);
        assertNotNull(pd);
    }

    @Test
    void createChipTest(){
        BigDecimal price =new BigDecimal(2.5);
        Chip pd = new Chip("a", price, 1001, 10);
        assertNotNull(pd);
    }

    @Test
    void createCandyTest(){
        BigDecimal price =new BigDecimal(2.5);
        Candy pd = new Candy("a", price, 1001, 10);
        assertNotNull(pd);
    }
}

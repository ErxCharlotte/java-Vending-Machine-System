package RE08_Group3_A2;

import RE08_Group3_A2.Product.Product;
import RE08_Group3_A2.User.Seller;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

public class SellerModifyProductTest {
    @Test
    void createSellerTest(){
        Seller seller = new Seller("a", 1001, "abc123");
        assertEquals(seller.getName(), "a");
    }

    @Test
    void sellerModifyProductNameTest(){
        Seller seller = new Seller("a", 1001, "abc123");
        BigDecimal price =new BigDecimal(2.5);
        Product pd = new Product("Sprite", "Drinks", price, 1001, 2);
        seller.modifyProductName(pd, "abc");
        Product pd1 = seller.getProductMap().get(1001);
        assertNotNull(pd1);
        assertTrue(seller.getProductMap().containsKey(pd1.getCode()));
        seller.modifyProductName(pd1, "abc");
        //***
        seller.modifyProductName(pd1, "Sprite");
    }

    @Test
    void sellerModifyProductPriceTest(){
        Seller seller = new Seller("a", 1001, "abc123");
        BigDecimal price =new BigDecimal(2.5);
        Product pd = new Product("Sprite", "Drinks", price, 1001, 2);
        BigDecimal price1 =new BigDecimal(4.1);
        seller.modifyProductPrice(pd, price1);
        Product pd1 = seller.getProductMap().get(1001);

        BigDecimal price2 =new BigDecimal(-100.2);
        seller.modifyProductPrice(pd1,  price2);
        seller.modifyProductPrice(pd1,  price1);
        //***
        seller.modifyProductPrice(pd1, price);
    }

    @Test
    void sellerModifyProductTypeTest(){
        Seller seller = new Seller("a", 1001, "abc123");
        BigDecimal price =new BigDecimal(2.5);
        Product pd = new Product("Sprite", "Drinks", price, 1001, 2);
        seller.modifyProductType(pd, "abc");
        Product pd1 = seller.getProductMap().get(1001);

        seller.modifyProductType(pd1, "Chocolates");
        //***
        seller.modifyProductType(pd1, "Drinks");
    }

    @Test
    void sellerModifyProductCountTest(){
        Seller seller = new Seller("a", 1001, "abc123");
        BigDecimal price =new BigDecimal(2.5);
        Product pd = new Product("Sprite", "Drinks", price, 1001, 2);
        seller.modifyProductCount(pd, 200);
        Product pd1 = seller.getProductMap().get(1001);

        seller.modifyProductCount(pd1, 5);
        //***
        seller.modifyProductCount(pd1, 2);
    }

    @Test
    void sellerModifyProductCodeTest(){
        Seller seller = new Seller("a", 1001, "abc123");
        BigDecimal price =new BigDecimal(2.5);
        Product pd = new Product("Sprite", "Drinks", price, 1001, 2);
        seller.modifyProductCode(pd, 1001);
        Product pd1 = seller.getProductMap().get(1001);

        seller.modifyProductCode(pd1, 1016);

        seller.modifyProductCode(pd1, 1001);
    }
}

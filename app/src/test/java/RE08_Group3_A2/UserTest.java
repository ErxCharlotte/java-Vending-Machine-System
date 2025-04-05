package RE08_Group3_A2;

import RE08_Group3_A2.Product.Product;
import RE08_Group3_A2.User.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserTest {
    @Test
    void createCashierTest(){
        Cashier cashier = new Cashier("a", 1001, "abc123");
        assertEquals(cashier.getName(), "a");
        assertEquals(cashier.getAccount(), 1001);
        assertEquals(cashier.getType(), 2);
        assertEquals(cashier.getPassword(), "abc123");
    }

    @Test
    void createCustomerTest(){
        Customer customer = new Customer("a", 1001, "abc123");
        assertEquals(customer.getName(), "a");
        customer.setType(0);
        customer.setAccount(1002);
        customer.setName("b");
        customer.setPassword("000abc");
        assertEquals(customer.getName(), "b");
        assertEquals(customer.getAccount(), 1002);
        assertEquals(customer.getType(), 0);
        assertEquals(customer.getPassword(), "000abc");

    }

    @Test
    void createOwnerTest(){
        Owner owner = new Owner("a", 1001, "abc123");
        assertEquals(owner.getName(), "a");
    }

    @Test
    void createSellerTest(){
        Seller seller = new Seller("a", 1001, "abc123");
        assertEquals(seller.getName(), "a");
    }

    @Test
    void userCommonTest(){
        User user= new User();
        Product pd = new Product();
        ArrayList<Product> pdList = new ArrayList<Product>();
        pdList.add(pd);
        user.setPurchasedList(pdList);
        user.getPurchasedList();
        assertEquals(user.getPurchasedList().size(), 1);
        user.addPurchasedProduct(pd);
        assertEquals(user.getPurchasedList().size(), 2);
        user.getProductMap();

    }
}

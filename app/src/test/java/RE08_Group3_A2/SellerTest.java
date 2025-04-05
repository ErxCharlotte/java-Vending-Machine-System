package RE08_Group3_A2;

import RE08_Group3_A2.Product.Product;
import RE08_Group3_A2.ReadAndWriteTXT.ReadTXT;
import RE08_Group3_A2.User.Seller;
import RE08_Group3_A2.User.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.HashMap;

public class SellerTest {
    @Test
    void constructTest(){
        Seller seller = new Seller("Jack",123,"111");
        Assertions.assertEquals("Jack", seller.getName());
        Assertions.assertEquals(123, seller.getAccount());
        Assertions.assertEquals("111", seller.getPassword());
    }
    @Test
    void removeProductsTest(){
        ReadTXT rd = new ReadTXT();
        Seller seller = new Seller("Jack",123,"111");
        HashMap<Integer, User> users = rd.readUserTXT();
        HashMap<Integer, Product> products = rd.readProductTXT();
        HashMap<BigDecimal, Money> moneys = rd.readMoneyTXT();
        VendingMachine vm = new VendingMachine(products, users, moneys);
        vm.initializeNumberOfCategory();

        Assertions.assertEquals(35, vm.getNumberOfDrinks());
        seller.removeProduct("1000,2",vm);
        Assertions.assertEquals(5, vm.getProducts().get(1000).getCount());
        seller.removeProduct("1001,-2",vm);
        Assertions.assertEquals(7, vm.getProducts().get(1001).getCount());
        seller.removeProduct("1001,0",vm);
        Assertions.assertEquals(7, vm.getProducts().get(1001).getCount());
        seller.removeProduct("2000,12",vm);
        Assertions.assertEquals(33, vm.getNumberOfDrinks());
        seller.removeProduct("1004,12",vm);
        Assertions.assertEquals(33, vm.getNumberOfDrinks());
    }

    @Test
    void addProductsTest(){
        ReadTXT rd = new ReadTXT();
        Seller seller = new Seller("Jack",123,"111");
        HashMap<Integer, User> users = rd.readUserTXT();
        HashMap<Integer, Product> products = rd.readProductTXT();
        HashMap<BigDecimal, Money> moneys = rd.readMoneyTXT();
        VendingMachine vm = new VendingMachine(products, users, moneys);
        vm.initializeNumberOfCategory();
        Assertions.assertEquals(35, vm.getNumberOfDrinks());

        seller.removeProduct("1000,2",vm);  // 7 - 2 = 5
        seller.removeProduct("1001,2",vm);  // 7 - 2 = 5

        seller.addProduct("1000,4",vm); // 5 + 4 = 9
        Assertions.assertEquals(9, vm.getProducts().get(1000).getCount());

        seller.addProduct("1000,4",vm); // 9 + 4 = 13
        Assertions.assertEquals(13, vm.getProducts().get(1000).getCount());

        seller.addProduct("1000,-2",vm);
        Assertions.assertEquals(13, vm.getProducts().get(1000).getCount());

        seller.removeProduct("1000,2",vm); // 13 - 2 = 11
        seller.addProduct("1012,10",vm);  // 7 + 10 > 15 --> 7

        Assertions.assertEquals(37, vm.getNumberOfDrinks());
        Assertions.assertEquals(7, vm.getProducts().get(1012).getCount());

        seller.addProduct("1006,9",vm);
        Assertions.assertEquals(7, vm.getProducts().get(1006).getCount());
        Assertions.assertEquals(37, vm.getNumberOfDrinks());

        seller.addProduct("1015,8",vm);
        Assertions.assertEquals(15, vm.getProducts().get(1015).getCount());
        Assertions.assertEquals(37, vm.getNumberOfDrinks());
    }
}

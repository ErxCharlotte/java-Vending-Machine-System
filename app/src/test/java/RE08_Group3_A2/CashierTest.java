package RE08_Group3_A2;

import RE08_Group3_A2.Product.Product;
import RE08_Group3_A2.ReadAndWriteTXT.ReadTXT;
import RE08_Group3_A2.User.Cashier;
import RE08_Group3_A2.User.Seller;
import RE08_Group3_A2.User.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;

public class CashierTest {

    @Test
    void CashierInstanceTest(){
        Cashier cashier = new Cashier("happy",123,"abc");
        Assertions.assertEquals("happy", cashier.getName());
        Assertions.assertEquals(123, cashier.getAccount());
        Assertions.assertEquals("abc", cashier.getPassword());
    }

    @Test
    void getReportTest() {
        Cashier cashier = new Cashier("happy",123,"abc");
        BigDecimal value = new BigDecimal(0.1);


        ReadTXT read = new ReadTXT();
        HashMap<BigDecimal, Money> moneyHashMap = read.readMoneyTXT();
        HashMap<Integer, Product> productHashMap = read.readProductTXT();
        VendingMachine vm = new VendingMachine(productHashMap, null, moneyHashMap);

        cashier.getReportOfTheTransaction(vm);
    }
}

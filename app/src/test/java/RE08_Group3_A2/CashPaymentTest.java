package RE08_Group3_A2;

import RE08_Group3_A2.Product.Product;
import RE08_Group3_A2.ReadAndWriteTXT.ReadTXT;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class CashPaymentTest {
    @Test
    void successfulPaid(){
        List<Product> bp = new ArrayList<>();
        List<Money> cp = new ArrayList<>();

        bp.add(new Product("Mineral water", "Drinks", new BigDecimal(2), 1000, 1));
        //bp.add(new Product("Coca cola", "Drinks", new BigDecimal("2.5"), 1002, 2));
        //bp.add(new Product("Mars", "Chocolates", new BigDecimal("1.4"), 1005, 2));
        bp.add(new Product("Smiths", "Chips", new BigDecimal(4), 1009, 1));
        //bp.add(new Product("Skittles", "Candies", new BigDecimal("3.1"), 1015, 1));

        cp.add(new Money("note", new BigDecimal(5), 2));
        cp.add(new Money("note", new BigDecimal(20), 2));
        cp.add(new Money("note", new BigDecimal(50), 1));


        ReadTXT read = new ReadTXT();
        HashMap<BigDecimal, Money> moneyHashMap = read.readMoneyTXT();
        HashMap<Integer, Product> productHashMap = read.readProductTXT();
        VendingMachine vm = new VendingMachine(productHashMap, null, moneyHashMap);
        vm.cashPayment(bp, cp, "1");
        assertEquals(moneyHashMap.get(new BigDecimal(5)).getCount(), 7);
        assertEquals(moneyHashMap.get(new BigDecimal(20)).getCount(), 5);
        assertEquals(moneyHashMap.get(new BigDecimal(50)).getCount(), 5);
        assertEquals(moneyHashMap.get(new BigDecimal(2)).getCount(), 3);

        assertEquals(productHashMap.get(1000).getCount(), 6);
        assertEquals(productHashMap.get(1009).getCount(), 6);

        assertEquals(vm.cashPayment(bp,cp, "1"), "Successful Paid. Please get your product and changes!,94");
    }

    @Test
    void failPaid(){
        List<Product> bp = new ArrayList<>();
        List<Money> cp = new ArrayList<>();

        bp.add(new Product("Mineral water", "Drinks", new BigDecimal(2), 1000, 1));
        bp.add(new Product("Smiths", "Chips", new BigDecimal(4), 1009, 1));

        cp.add(new Money("note", new BigDecimal(5), 1));

        ReadTXT read = new ReadTXT();
        HashMap<BigDecimal, Money> moneyHashMap = read.readMoneyTXT();
        VendingMachine vm = new VendingMachine(null, null, moneyHashMap);
        assertEquals(vm.cashPayment(bp, cp, "1"), "The cash you paid is not enough, you need to input more cash, or you can cancel this order.");
    }

    @Test
    void changeNullTest(){
        ReadTXT read = new ReadTXT();
        HashMap<BigDecimal, Money> moneyHashMap = read.readMoneyTXT();
        HashMap<Integer, Product> productHashMap = read.readProductTXT();
        VendingMachine vm = new VendingMachine(productHashMap, null, moneyHashMap);

        //Change equal to 0
        List<Product> bp = new ArrayList<>();
        List<Money> cp = new ArrayList<>();

        bp.add(new Product("Mineral water", "Drinks", new BigDecimal(2), 1000, 1));
        bp.add(new Product("Smiths", "Chips", new BigDecimal(4), 1009, 1));

        cp.add(new Money("note", new BigDecimal(5), 1));
        cp.add(new Money("coin", new BigDecimal(1), 1));

        assertEquals(vm.cashPayment(bp, cp, "1"), "Successful Paid. Please get your product!");

        //Change less than zero or no available change provided
        List<Product> bp1 = new ArrayList<>();
        List<Money> cp1 = new ArrayList<>();

        bp1.add(new Product("Skittles", "Candies", new BigDecimal("3.13"), 1015, 2));
        bp1.add(new Product("Mineral water", "Drinks", new BigDecimal(2), 1000, 1));
        bp1.add(new Product("Smiths", "Chips", new BigDecimal(4), 1009, 1));

        cp1.add(new Money("note", new BigDecimal(5), 1));
        cp1.add(new Money("coin", new BigDecimal(2), 3));
        cp1.add(new Money("coin", new BigDecimal(1), 2));
        cp1.add(new Money("coin", new BigDecimal("0.05"), 1));


        assertEquals(vm.cashPayment(bp1, cp1, "1"), "There are no available changes, enter the different notes or coins, or you can cancel this order.");
    }
}


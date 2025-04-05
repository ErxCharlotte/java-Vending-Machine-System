package RE08_Group3_A2;

import RE08_Group3_A2.Product.Product;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class RecentlyProductTest {
    @Test
    void printLastFiveProductTest(){
        List<Product> bp = new ArrayList<>();
        bp.add(new Product("Mineral water", "Drinks", new BigDecimal(2), 1000, 1));
        bp.add(new Product("Smiths", "Chips", new BigDecimal(4), 1009, 1));
        bp.add(new Product("Coca cola", "Drinks", new BigDecimal("2.5"), 1002, 1));

        List<Product> newbp = new ArrayList<>();
        newbp.add(new Product("Sprite", "Drinks", new BigDecimal("2.5"), 1001, 1));
        newbp.add(new Product("Bounty", "Chocolates", new BigDecimal(1), 1007, 1));
        newbp.add(new Product("Kettle", "Chips", new BigDecimal("3.5"), 1011, 1));

        VendingMachine vm = new VendingMachine(null, null, null);
        vm.saveTransaction("123", bp, null, null, null);
        List<Product> ls = vm.recentlyProduct("123");
        assertEquals(ls.get(0), bp.get(2));
        assertEquals(ls.get(1), bp.get(1));
        assertEquals(ls.get(2), bp.get(0));

        vm.saveTransaction("123", newbp, null, null, null);
        List<Product> newLs = vm.recentlyProduct("123");
        assertEquals(newLs.get(0).getName(), newbp.get(2).getName());
        assertEquals(newLs.get(1).getName(), newbp.get(1).getName());
        assertEquals(newLs.get(2).getName(), newbp.get(0).getName());
        assertEquals(newLs.get(3).getName(), bp.get(2).getName());
        assertEquals(newLs.get(4).getName(), bp.get(1).getName());
    }




}

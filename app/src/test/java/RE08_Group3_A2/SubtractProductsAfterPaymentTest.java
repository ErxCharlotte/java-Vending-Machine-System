package RE08_Group3_A2;

import RE08_Group3_A2.Product.Product;
import RE08_Group3_A2.ReadAndWriteTXT.ReadTXT;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class SubtractProductsAfterPaymentTest {

    @Test
    void subtractTest(){
        List<Product> bp = new ArrayList<>();

        bp.add(new Product("Mineral water", "Drinks", new BigDecimal(2), 1000, 1));
        bp.add(new Product("Smiths", "Chips", new BigDecimal(4), 1009, 1));
        bp.add(new Product("Coca cola", "Drinks", new BigDecimal("2.5"), 1002, 1));
        bp.add(new Product("Skittles", "Candies", new BigDecimal("3.13"), 1015, 7));

        ReadTXT read = new ReadTXT();
        HashMap<Integer, Product> productHashMap = read.readProductTXT();
        VendingMachine vm = new VendingMachine(productHashMap, null, null);
        vm.subtractProductsAfterPayment(bp);
        assertEquals(productHashMap.get(1000).getCount(), 6);
        assertEquals(productHashMap.get(1009).getCount(), 6);
        assertEquals(productHashMap.get(1002).getCount(), 6);
        assertEquals(productHashMap.get(1015).getCount(),0);

    }
}

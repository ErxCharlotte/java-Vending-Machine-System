package RE08_Group3_A2;

import RE08_Group3_A2.Product.Product;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class ProductAmountTest {

    @Test
    void calculateTP(){
        List<Product> products = new ArrayList<>();
        products.add(new Product("Mineral water", "Drinks", new BigDecimal(2), 1000, 3));
        products.add(new Product("Coca cola", "Drinks", new BigDecimal("2.5"), 1002, 2));
        products.add(new Product("Mars", "Chocolates", new BigDecimal("1.4"), 1005, 3));
        products.add(new Product("Smiths", "Chips", new BigDecimal(4), 1009, 3));
        products.add(new Product("Skittles", "Candies", new BigDecimal("3.1"), 1015, 3));

        VendingMachine vm = new VendingMachine(null, null, null);

        BigDecimal result = vm.productAmount(products);
        assertEquals(result, new BigDecimal("36.5"));
    }
}

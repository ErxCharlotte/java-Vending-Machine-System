package RE08_Group3_A2.Product;

import java.math.BigDecimal;

public class Drink extends Product{
    public Drink(String name, BigDecimal price, int code, int count) {
        super(name, "drink", price, code, count);
    }
}

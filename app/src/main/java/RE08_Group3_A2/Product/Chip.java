package RE08_Group3_A2.Product;

import java.math.BigDecimal;

public class Chip extends Product{
    public Chip(String name, BigDecimal price, int code, int count) {
        super(name, "chip", price, code, count);
    }
}
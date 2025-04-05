package RE08_Group3_A2.Product;

import java.math.BigDecimal;

public class Candy extends Product{
    public Candy(String name, BigDecimal price, int code, int count) {
        super(name, "candy", price, code, count);
    }
}
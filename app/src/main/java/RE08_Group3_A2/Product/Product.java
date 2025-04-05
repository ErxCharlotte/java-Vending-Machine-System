package RE08_Group3_A2.Product;

import java.math.BigDecimal;

public class Product {
    private String name;
    private String type;
    private BigDecimal price;
    private int code;
    private String description;

    private int count;

    public Product(){
    }

    public Product(String name, String type, BigDecimal price, int code, int count){
        this.name = name;
        this.type = type;
        this.price = price;
        this.code = code;
        this.count = count;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public int getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}

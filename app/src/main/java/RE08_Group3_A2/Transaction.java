package RE08_Group3_A2;

import RE08_Group3_A2.Product.Product;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public class Transaction {

    private LocalDateTime time;
    private List<Product> products;
    private BigDecimal amount;
    private BigDecimal changes;
    private String paymentWay;


    public Transaction(){
    }

    public Transaction(LocalDateTime time, List<Product> products, BigDecimal amount, BigDecimal changes, String paymentWay) {
        this.time = time;
        this.products = products;
        this.amount = amount;
        this.changes = changes;
        this.paymentWay = paymentWay;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public BigDecimal getChanges() {
        return changes;
    }

    public void setChanges(BigDecimal changes) {
        this.changes = changes;
    }

    public String getPaymentWay() {
        return paymentWay;
    }

    public void setPaymentWay(String paymentWay) {
        this.paymentWay = paymentWay;
    }
}

package RE08_Group3_A2;

import java.math.BigDecimal;

public class Money {

    private String type;
    private BigDecimal amount;
    private int count;


    public Money(){

    }
    
    public Money(String type, BigDecimal amount, int count) {
        this.type = type;
        this.amount = amount;
        this.count = count;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

}

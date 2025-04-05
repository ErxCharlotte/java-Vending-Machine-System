package RE08_Group3_A2;

import RE08_Group3_A2.Product.Product;
import RE08_Group3_A2.User.Cashier;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class TransactionTest {
    @Test
    void TransactionInstanceTest(){
        Transaction transaction = new Transaction();
        BigDecimal value = new BigDecimal(10.0);
        transaction.setAmount(value);
        transaction.setChanges(value);
        transaction.setPaymentWay("card");
        List<Product> pds = new ArrayList<>();
        transaction.setProducts(pds);
    }

    @Test
    void CardInstanceTest(){
        Card card = new Card();
        BigDecimal value = new BigDecimal(10.0);
        card.setName("111");
        card.setNumber("123");
        card.setAccount("111");
    }

    @Test
    void MoneyInstanceTest(){
        Money money = new Money();
        BigDecimal value = new BigDecimal(10.0);
        money.setAmount(value);
        money.setType("coin");
    }

}

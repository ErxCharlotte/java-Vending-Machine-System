package RE08_Group3_A2;

import RE08_Group3_A2.Product.Product;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class SaveTransactionTest {

    @Test
    void savePainProductTest(){
        List<Product> bp = new ArrayList<>();
        bp.add(new Product("Mineral water", "Drinks", new BigDecimal(2), 1000, 1));
        bp.add(new Product("Smiths", "Chips", new BigDecimal(4), 1009, 1));
        bp.add(new Product("Coca cola", "Drinks", new BigDecimal("2.5"), 1002, 1));

        List<Product> newbp = new ArrayList<>();
        newbp.add(new Product("Sprite", "Drinks", new BigDecimal("2.5"), 1001, 1));
        newbp.add(new Product("Bounty", "Chocolates", new BigDecimal(1), 1007, 1));
        newbp.add(new Product("Kettle", "Chips", new BigDecimal("3.5"), 1011, 1));

        VendingMachine vm = new VendingMachine(null, null, null);
        vm.saveTransaction("aaa", bp, new BigDecimal(23), new BigDecimal(5), "Cash");
        assertEquals(vm.getPaidProduct().get("aaa").get(0), bp.get(0));
        assertEquals(vm.getPaidProduct().get("aaa").get(1), bp.get(1));
        assertEquals(vm.getPaidProduct().get("aaa").get(2), bp.get(2));

        //add boughtProduct into exist account
        vm.saveTransaction("aaa", newbp, new BigDecimal(6), new BigDecimal(1), "Cash");
        assertEquals(vm.getPaidProduct().get("aaa").get(3), newbp.get(0));
        assertEquals(vm.getPaidProduct().get("aaa").get(4), newbp.get(1));
        assertEquals(vm.getPaidProduct().get("aaa").get(5), newbp.get(2));
    }

    @Test
    void saveTransactionTest(){
        List<Product> bp = new ArrayList<>();
        bp.add(new Product("Mineral water", "Drinks", new BigDecimal(2), 1000, 1));
        bp.add(new Product("Smiths", "Chips", new BigDecimal(4), 1009, 1));
        bp.add(new Product("Coca cola", "Drinks", new BigDecimal("2.5"), 1002, 1));

        List<Product> newbp = new ArrayList<>();
        newbp.add(new Product("Sprite", "Drinks", new BigDecimal("2.5"), 1001, 1));
        newbp.add(new Product("Bounty", "Chocolates", new BigDecimal(1), 1007, 1));
        newbp.add(new Product("Kettle", "Chips", new BigDecimal("3.5"), 1011, 1));

        VendingMachine vm = new VendingMachine(null, null, null);
        vm.saveTransaction("bbb", bp, new BigDecimal("8.5"), new BigDecimal("1.5"), "Cash");
        vm.saveTransaction("ccc", newbp, new BigDecimal(7), new BigDecimal(3), "Cash");
        vm.saveTransaction("ccc", newbp, new BigDecimal(7), new BigDecimal(0), "Card");

        assertEquals(vm.getTransactions().get(0).getProducts(), bp);
        assertEquals(vm.getTransactions().get(0).getAmount(), new BigDecimal("8.5"));
        assertEquals(vm.getTransactions().get(0).getChanges(), new BigDecimal("1.5"));
        assertEquals(vm.getTransactions().get(0).getPaymentWay(), "Cash");

        assertEquals(vm.getTransactions().get(1).getProducts(), newbp);
        assertEquals(vm.getTransactions().get(1).getAmount(), new BigDecimal(7));
        assertEquals(vm.getTransactions().get(1).getChanges(), new BigDecimal(3));
        assertEquals(vm.getTransactions().get(1).getPaymentWay(), "Cash");

        assertEquals(vm.getTransactions().get(2).getProducts(), newbp);
        assertEquals(vm.getTransactions().get(2).getAmount(), new BigDecimal(7));
        assertEquals(vm.getTransactions().get(2).getChanges(), new BigDecimal(0));
        assertEquals(vm.getTransactions().get(2).getPaymentWay(), "Card");

    }


}

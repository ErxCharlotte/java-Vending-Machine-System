package RE08_Group3_A2;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class CashAmountTest {

    @Test
    void calculateTotalCash(){
        List<Money> cp = new ArrayList<>();
        cp.add(new Money("note", new BigDecimal(5), 2));
        cp.add(new Money("note", new BigDecimal(20), 1));
        cp.add(new Money("note", new BigDecimal(50), 3));
        cp.add(new Money("coin", new BigDecimal("0.5"), 2));
        cp.add(new Money("coin", new BigDecimal("0.05"), 2));

        VendingMachine vm = new VendingMachine(null, null, null);

        BigDecimal result = vm.cashAmount(cp);
        assertEquals(result, new BigDecimal("181.10"));
    }
}

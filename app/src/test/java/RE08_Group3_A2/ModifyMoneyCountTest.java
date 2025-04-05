package RE08_Group3_A2;

import RE08_Group3_A2.ReadAndWriteTXT.ReadTXT;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
import java.util.HashMap;

public class ModifyMoneyCountTest {

    @Test
    void CheckIfNull(){
        ReadTXT read = new ReadTXT();
        HashMap<BigDecimal, Money> moneyInVM = read.readMoneyTXT();
        assertFalse(moneyInVM.isEmpty());
    }

    @Test
    void addCount(){
        ReadTXT read = new ReadTXT();
        HashMap<BigDecimal, Money> moneyInVM = read.readMoneyTXT();
        VendingMachine vm = new VendingMachine(null, null, moneyInVM);

        //add the Count for exist face value
        vm.modifyMoneyCount(BigDecimal.valueOf(0.5), 2, "coin");
        assertEquals(moneyInVM.get(BigDecimal.valueOf(0.5)).getCount(), 7);

        vm.modifyMoneyCount(BigDecimal.valueOf(0.05), 5, "coin");
        assertEquals(moneyInVM.get(BigDecimal.valueOf(0.05)).getCount(), 10);

        //add the Count for inexistence face value
        vm.modifyMoneyCount(BigDecimal.valueOf(0.3), 5, "coin");
        assertEquals(moneyInVM.get(BigDecimal.valueOf(0.3)).getCount(), 5);

        vm.modifyMoneyCount(BigDecimal.valueOf(35), 6, "note");
        assertEquals(moneyInVM.get(BigDecimal.valueOf(35)).getCount(), 6);
    }

    @Test
    void minusCount(){
        ReadTXT read = new ReadTXT();
        HashMap<BigDecimal, Money> moneyInVM = read.readMoneyTXT();
        VendingMachine vm = new VendingMachine(null, null, moneyInVM);

        //minus the Count for exist face value
        vm.modifyMoneyCount(BigDecimal.valueOf(0.5), -3, "coin");
        assertEquals(moneyInVM.get(BigDecimal.valueOf(0.5)).getCount(), 2);

        vm.modifyMoneyCount(BigDecimal.valueOf(50), -5, "note");
        assertEquals(moneyInVM.get(BigDecimal.valueOf(50)).getCount(), 0);
    }
}

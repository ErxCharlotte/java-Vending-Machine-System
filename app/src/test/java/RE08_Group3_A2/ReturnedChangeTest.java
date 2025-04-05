package RE08_Group3_A2;

import RE08_Group3_A2.ReadAndWriteTXT.ReadTXT;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class ReturnedChangeTest {
    @Test
    void ChangeTest(){

        ReadTXT read = new ReadTXT();
        HashMap<BigDecimal, Money> moneyMap = read.readMoneyTXT();
        VendingMachine vm = new VendingMachine(null, null, moneyMap);

        //CHECK IF THE CHANGE IS NULL
        assertNull(vm.returnedChange(new BigDecimal(0)));
        assertNull(vm.returnedChange(new BigDecimal(-2)));
        assertNull(vm.returnedChange(new BigDecimal("3.14")));

        //CHECK IF THE CHANGE IS NOT NULL
        HashMap<BigDecimal, Money> map = vm.returnedChange(new BigDecimal(50));
        assertEquals(map.get(new BigDecimal(50)).getCount(), 1);

        HashMap<BigDecimal, Money> map2 = vm.returnedChange(new BigDecimal(100));
        assertEquals(map2.get(new BigDecimal(50)).getCount(), 2);

        HashMap<BigDecimal, Money> map3 = vm.returnedChange(new BigDecimal(30));
        assertEquals(map3.get(new BigDecimal(20)).getCount(), 1);
        assertEquals(map3.get(new BigDecimal(10)).getCount(), 1);

        HashMap<BigDecimal, Money> map4 = vm.returnedChange(new BigDecimal("50.5"));
        assertEquals(map4.get(new BigDecimal(50)).getCount(), 1);
        assertEquals(map4.get(new BigDecimal("0.5")).getCount(), 1);
    }

    @Test
    void MoneyCountAfterReturnedChange(){
        ReadTXT read = new ReadTXT();
        HashMap<BigDecimal, Money> moneyMap = read.readMoneyTXT();
        VendingMachine vm = new VendingMachine(null, null, moneyMap);

        vm.returnedChange(new BigDecimal(1));
        assertEquals(moneyMap.get(new BigDecimal(1)).getCount(), 4);

        vm.returnedChange(new BigDecimal(30));
        assertEquals(moneyMap.get(new BigDecimal(20)).getCount(), 4);
        assertEquals(moneyMap.get(new BigDecimal(10)).getCount(), 4);

    }
}
